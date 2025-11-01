#pragma once
#include <stdexcept>
#include <string>

class CalcErr : public std::runtime_error {
public:
    explicit CalcErr(const std::string& msg)
        : std::runtime_error(msg) {}
};

class ParseErr : public CalcErr {
public:
    explicit ParseErr(const std::string& msg)
        : CalcErr("Parse wrong: " + msg) {
    }
};

class PluginErr : public CalcErr {
public:
    explicit PluginErr(const std::string& msg)
        : CalcErr("Plugin wrong: " + msg) {
    }
};

class MathErr : public CalcErr {
public:
    explicit MathErr(const std::string& msg)
        : CalcErr("Math wrong: " + msg) {
    }
};
