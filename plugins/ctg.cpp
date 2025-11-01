#include "../src/base_func.h"
#include <cmath>
#include <stdexcept>

class CtgPlug : public ICalcFunc {
public:
    std::string getName() const override {
        return "ctg";
    }

    int getNumCount() const override {
        return 1;
    }

    std::string getHelp() const override {
        return "Cotangent: ctg(x) - x in radians";
    }

    double run(const std::vector<double>& nums) override {
        if (nums.size() != 1) {
            throw std::invalid_argument("ctg needs 1 number");
        }
        double sinVal = std::sin(nums[0]);
        if (std::abs(sinVal) < 1e-10) {
            throw std::invalid_argument("ctg undefined for this angle");
        }
        return std::cos(nums[0]) / sinVal;
    }
};

extern "C" __declspec(dllexport) ICalcFunc* makeFunc() {
    return new CtgPlug();
}