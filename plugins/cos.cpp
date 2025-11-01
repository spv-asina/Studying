#include "../src/base_func.h"
#include <cmath>
#include <stdexcept>

class CosPlug : public ICalcFunc {
public:
    std::string getName() const override {
        return "cos";
    }

    int getNumCount() const override {
        return 1;
    }

    std::string getHelp() const override {
        return "Cosine: cos(x) - x in radians";
    }

    double run(const std::vector<double>& nums) override {
        if (nums.size() != 1) {
            throw std::invalid_argument("cos needs 1 number");
        }
        return std::cos(nums[0]);
    }
};

extern "C" __declspec(dllexport) ICalcFunc* makeFunc() {
    return new CosPlug();
}