#include "../src/base_func.h"
#include <cmath>
#include <stdexcept>

class LnPlug : public ICalcFunc {
public:
    std::string getName() const override {
        return "ln";
    }

    int getNumCount() const override {
        return 1;
    }

    std::string getHelp() const override {
        return "Natural logarithm: ln(x)";
    }

    double run(const std::vector<double>& nums) override {
        if (nums.size() != 1) {
            throw std::invalid_argument("ln needs 1 number");
        }
        if (nums[0] <= 0) {
            throw std::invalid_argument("ln argument must be positive");
        }
        return std::log(nums[0]);
    }
};

extern "C" __declspec(dllexport) ICalcFunc* makeFunc() {
    return new LnPlug();
}