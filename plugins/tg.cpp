#include "../src/base_func.h"
#include <cmath>
#include <stdexcept>

class TgPlug : public ICalcFunc {
public:
    std::string getName() const override {
        return "tg";
    }

    int getNumCount() const override {
        return 1;
    }

    std::string getHelp() const override {
        return "Tangent: tg(x) - x in radians";
    }

    double run(const std::vector<double>& nums) override {
        if (nums.size() != 1) {
            throw std::invalid_argument("tg needs 1 number");
        }
        double cosVal = std::cos(nums[0]);
        if (std::abs(cosVal) < 1e-10) {
            throw std::invalid_argument("tg undefined for this angle");
        }
        return std::tan(nums[0]);
    }
};

extern "C" __declspec(dllexport) ICalcFunc* makeFunc() {
    return new TgPlug();
}