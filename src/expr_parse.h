#pragma once
#include "base_func.h"
#include "errors.h"
#include <map>
#include <vector>
#include <string>
#include <memory>
#include <stack>
#include <cmath>

class ExprParse {
private:
    std::map<std::string, FuncP> funcs;
    std::map<std::string, double> consts;

    void initConst();
    std::vector<std::string> getParts(const std::string& expr);
    std::vector<std::string> makeRPN(const std::vector<std::string>& parts);
    double calcRPN(const std::vector<std::string>& rpnParts);

    bool isNum(const std::string& part) const;
    bool isOper(const std::string& part) const;
    bool isFunc(const std::string& part) const;
    int getPrior(const std::string& oper) const;

    double toNum(const std::string& part);
    double calcOper(const std::string& oper, double a, double b);

public:
    ExprParse();
    void addFunc(const std::string& name, FuncP func);
    void delFunc(const std::string& name);
    double parse(const std::string& expr);
    std::vector<std::string> listFuncs() const;
};
