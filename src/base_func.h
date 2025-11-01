#pragma once
#include <string>
#include <vector>
#include <memory>

class ICalcFunc {
public:
    virtual ~ICalcFunc() = default;

    virtual double run(const std::vector<double>& nums) = 0;
    virtual std::string getName() const = 0;
    virtual int getNumCount() const = 0;
    virtual std::string getHelp() const = 0;
};

using FuncP = std::shared_ptr<ICalcFunc>;
