#include "../src/base_func.h"
#include <cmath>
#include <stdexcept>

class SinPlug : public ICalcFunc {
public:
    std::string getName() const override {
        return "sin";
    }

    int getNumCount() const override {
        return 1;
    }

    std::string getHelp() const override {
        return "Sine: sin(x) - x in radians";
    }

    double run(const std::vector<double>& nums) override {
        if (nums.size() != 1) {
            throw std::invalid_argument("sin needs 1 number");
        }
        return std::sin(nums[0]);
    }
};

extern "C" __declspec(dllexport) ICalcFunc* makeFunc() {
    return new SinPlug();
}
