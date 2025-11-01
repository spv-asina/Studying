#pragma once
#include "expr_parse.h"
#include "plug_load.h"
#include "errors.h"
#include <memory>
#include <map>

class CalcCore {
private:
    std::unique_ptr<ExprParse> parser;
    std::unique_ptr<PlugLoad> plugger;
    std::map<std::string, FuncP> loaded;

public:
    CalcCore();
    ~CalcCore() = default;

    void loadPlugs(const std::string& plugDir = "./plugins");
    double calc(const std::string& expr);
    void putFunc(const std::string& name, FuncP func);
    void takeFunc(const std::string& name);

    std::vector<std::string> getFuncs() const;
    std::vector<std::string> getPlugs() const;

private:
    void makeBaseFuncs();
};
