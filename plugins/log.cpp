#include "../src/base_func.h"
#include <cmath>
#include <stdexcept>

class LogPlug : public ICalcFunc {
public:
    std::string getName() const override {
        return "log";
    }

    int getNumCount() const override {
        return 2;
    }

    std::string getHelp() const override {
        return "Logarithm: log(base, x)";
    }

    double run(const std::vector<double>& nums) override {
        if (nums.size() != 2) {
            throw std::invalid_argument("log needs 2 numbers");
        }
        if (nums[0] <= 0 || nums[0] == 1) {
            throw std::invalid_argument("log base must be positive and not 1");
        }
        if (nums[1] <= 0) {
            throw std::invalid_argument("log argument must be positive");
        }
        return std::log(nums[1]) / std::log(nums[0]);
    }
};

extern "C" __declspec(dllexport) ICalcFunc* makeFunc() {
    return new LogPlug();
}