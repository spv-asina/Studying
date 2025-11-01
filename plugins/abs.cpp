#include "../src/base_func.h"
#include <cmath>
#include <stdexcept>

class AbsPlug : public ICalcFunc {
public:
    std::string getName() const override {
        return "abs";
    }

    int getNumCount() const override {
        return 1;
    }

    std::string getHelp() const override {
        return "Absolute value: abs(x)";
    }

    double run(const std::vector<double>& nums) override {
        if (nums.size() != 1) {
            throw std::invalid_argument("abs needs 1 number");
        }
        return std::abs(nums[0]);
    }
};

extern "C" __declspec(dllexport) ICalcFunc* makeFunc() {
    return new AbsPlug();
}