#include "../src/base_func.h"
#include <cmath>
#include <stdexcept>

class DegPlug : public ICalcFunc {
public:
    std::string getName() const override {
        return "deg";
    }

    int getNumCount() const override {
        return 1;
    }

    std::string getHelp() const override {
        return "Radians to degrees: deg(x)";
    }

    double run(const std::vector<double>& nums) override {
        if (nums.size() != 1) {
            throw std::invalid_argument("deg needs 1 number");
        }
        return nums[0] * 180.0 / 3.14159265358979323846;
    }
};

extern "C" __declspec(dllexport) ICalcFunc* makeFunc() {
    return new DegPlug();
}