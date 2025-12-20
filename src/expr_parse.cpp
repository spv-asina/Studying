#include "expr_parse.h"
#include <sstream>
#include <cctype>
#include <algorithm>

ExprParse::ExprParse() {
    initConst();
}

void ExprParse::initConst() {
    consts["PI"] = 3.14159265358979323846;
    consts["E"] = 2.71828182845904523536;
}

void ExprParse::addFunc(const std::string& name, FuncP func) {
    funcs[name] = func;
}

void ExprParse::delFunc(const std::string& name) {
    funcs.erase(name);
}

std::vector<std::string> ExprParse::getParts(const std::string& expr) {
    std::vector<std::string> parts;
    std::string cur;

    for (size_t i = 0; i < expr.size(); ++i) {
        char c = expr[i];

        if (std::isspace(c)) {
            if (!cur.empty()) {
                parts.push_back(cur);
                cur.clear();
            }
            continue;
        }

        if (std::isalnum(c) || c == '.' || c == '_') {
            cur += c;
        }
        else {
            if (!cur.empty()) {
                parts.push_back(cur);
                cur.clear();
            }

            if (c == ',' || c == '(' || c == ')' ||
                c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                parts.push_back(std::string(1, c));
            }
        }
    }

    if (!cur.empty()) {
        parts.push_back(cur);
    }

    return parts;
}

std::vector<std::string> ExprParse::makeRPN(const std::vector<std::string>& parts) {
    std::vector<std::string> out;
    std::stack<std::string> operStack;

    for (const auto& part : parts) {
        if (isNum(part) || consts.find(part) != consts.end()) {
            out.push_back(part);
        }
        else if (isFunc(part)) {
            operStack.push(part);
        }
        else if (part == "(") {
            operStack.push(part);
        }
        else if (part == ")") {
            while (!operStack.empty() && operStack.top() != "(") {
                out.push_back(operStack.top());
                operStack.pop();
            }
            if (operStack.empty()) {
                throw ParseErr("Brackets error");
            }
            operStack.pop();

            if (!operStack.empty() && isFunc(operStack.top())) {
                out.push_back(operStack.top());
                operStack.pop();
            }
        }
        else if (isOper(part)) {
            while (!operStack.empty() &&
                isOper(operStack.top()) &&
                getPrior(operStack.top()) >= getPrior(part)) {
                out.push_back(operStack.top());
                operStack.pop();
            }
            operStack.push(part);
        }
        else {
            throw ParseErr("Unknown: " + part);
        }
    }

    while (!operStack.empty()) {
        if (operStack.top() == "(") {
            throw ParseErr("Brackets error");
        }
        out.push_back(operStack.top());
        operStack.pop();
    }

    return out;
}

double ExprParse::calcRPN(const std::vector<std::string>& rpnParts) {
    std::stack<double> nums;

    for (const auto& part : rpnParts) {
        if (isNum(part)) {
            nums.push(toNum(part));
        }
        else if (consts.find(part) != consts.end()) {
            nums.push(consts[part]);
        }
        else if (isFunc(part)) {
            auto it = funcs.find(part);
            if (it == funcs.end()) {
                throw ParseErr("Unknown func: " + part);
            }

            int numCount = it->second->getNumCount();
            if (nums.size() < numCount) {
                throw ParseErr("Not enough args for: " + part);
            }

            std::vector<double> args;
            for (int i = 0; i < numCount; ++i) {
                args.insert(args.begin(), nums.top());
                nums.pop();
            }

            try {
                double res = it->second->run(args);
                nums.push(res);
            }
            catch (const std::exception& e) {
                throw MathErr("Func " + part + " error: " + e.what());
            }
        }
        else if (isOper(part)) {
            if (nums.size() < 2) {
                throw ParseErr("Not enough nums for: " + part);
            }

            double b = nums.top(); nums.pop();
            double a = nums.top(); nums.pop();

            double res = calcOper(part, a, b);
            nums.push(res);
        }
        else {
            throw ParseErr("Bad part in RPN: " + part);
        }
    }

    if (nums.size() != 1) {
        throw ParseErr("Wrong expr");
    }

    return nums.top();
}

bool ExprParse::isNum(const std::string& part) const {
    if (part.empty()) return false;

    size_t start = 0;
    if (part[0] == '-' && part.length() > 1) start = 1;

    bool hasDot = false;
    for (size_t i = start; i < part.length(); ++i) {
        if (part[i] == '.') {
            if (hasDot) return false;
            hasDot = true;
        }
        else if (!std::isdigit(part[i])) {
            return false;
        }
    }
    return true;
}

bool ExprParse::isOper(const std::string& part) const {
    return part == "+" || part == "-" || part == "*" || part == "/" || part == "^";
}

bool ExprParse::isFunc(const std::string& part) const {
    return funcs.find(part) != funcs.end();
}

int ExprParse::getPrior(const std::string& oper) const {
    if (oper == "^") return 3;
    if (oper == "*" || oper == "/") return 2;
    if (oper == "+" || oper == "-") return 1;
    return 0;
}

double ExprParse::toNum(const std::string& part) {
    try {
        return std::stod(part);
    }
    catch (const std::exception&) {
        throw ParseErr("Bad num: " + part);
    }
}

double ExprParse::calcOper(const std::string& oper, double a, double b) {
    if (oper == "+") return a + b;
    if (oper == "-") return a - b;
    if (oper == "*") return a * b;
    if (oper == "/") {
        if (b == 0) throw MathErr("Divide by 0");
        return a / b;
    }
    if (oper == "^") return std::pow(a, b);

    throw ParseErr("Unknown oper: " + oper);
}

double ExprParse::parse(const std::string& expr) {
    if (expr.empty()) {
        throw ParseErr("Empty expr");
    }

    auto parts = getParts(expr);
    auto rpnParts = makeRPN(parts);
    return calcRPN(rpnParts);
}

std::vector<std::string> ExprParse::listFuncs() const {
    std::vector<std::string> res;
    for (const auto& pair : funcs) {
        res.push_back(pair.first);
    }
    return res;
}
