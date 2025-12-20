#include "calc_core.h"
#include <iostream>

class AddFunc : public ICalcFunc {
public:
    std::string getName() const override { return "add"; }
    int getNumCount() const override { return 2; }
    std::string getHelp() const override { return "Add: add(a,b) = a+b"; }

    double run(const std::vector<double>& nums) override {
        if (nums.size() != 2) throw MathErr("add needs 2 nums");
        return nums[0] + nums[1];
    }
};

class SubFunc : public ICalcFunc {
public:
    std::string getName() const override { return "sub"; }
    int getNumCount() const override { return 2; }
    std::string getHelp() const override { return "Sub: sub(a,b) = a-b"; }

    double run(const std::vector<double>& nums) override {
        if (nums.size() != 2) throw MathErr("sub needs 2 nums");
        return nums[0] - nums[1];
    }
};

class MulFunc : public ICalcFunc {
public:
    std::string getName() const override { return "mul"; }
    int getNumCount() const override { return 2; }
    std::string getHelp() const override { return "Mul: mul(a,b) = a*b"; }

    double run(const std::vector<double>& nums) override {
        if (nums.size() != 2) throw MathErr("mul needs 2 nums");
        return nums[0] * nums[1];
    }
};

class DivFunc : public ICalcFunc {
public:
    std::string getName() const override { return "div"; }
    int getNumCount() const override { return 2; }
    std::string getHelp() const override { return "Div: div(a,b) = a/b"; }

    double run(const std::vector<double>& nums) override {
        if (nums.size() != 2) throw MathErr("div needs 2 nums");
        if (nums[1] == 0) throw MathErr("Div by 0");
        return nums[0] / nums[1];
    }
};

CalcCore::CalcCore()
    : parser(std::make_unique<ExprParse>())
    , plugger(std::make_unique<PlugLoad>()) {
    makeBaseFuncs();
}

void CalcCore::makeBaseFuncs() {
    putFunc("add", std::make_shared<AddFunc>());
    putFunc("sub", std::make_shared<SubFunc>());
    putFunc("mul", std::make_shared<MulFunc>());
    putFunc("div", std::make_shared<DivFunc>());
}

void CalcCore::loadPlugs(const std::string& plugDir) {
    try {
        auto plugFuncs = plugger->loadFromDir(plugDir);

        for (auto& func : plugFuncs) {
            putFunc(func->getName(), func);
        }

        std::cout << "Got " << plugFuncs.size() << " plug funcs" << std::endl;

    }
    catch (const std::exception& e) {
        std::cerr << "Note: " << e.what() << std::endl;
    }
}

double CalcCore::calc(const std::string& expr) {
    if (expr.empty()) {
        throw CalcErr("Empty input");
    }

    return parser->parse(expr);
}

void CalcCore::putFunc(const std::string& name, FuncP func) {
    parser->addFunc(name, func);
    loaded[name] = func;
}

void CalcCore::takeFunc(const std::string& name) {
    parser->delFunc(name);
    loaded.erase(name);
}

std::vector<std::string> CalcCore::getFuncs() const {
    return parser->listFuncs();
}

std::vector<std::string> CalcCore::getPlugs() const {
    std::vector<std::string> res;
    for (const auto& pair : loaded) {
        res.push_back(pair.first);
    }
    return res;
}
