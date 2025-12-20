#include "../src/base_func.h"
#include <cmath>
#include <stdexcept>

class RadPlug : public ICalcFunc {
public:
    std::string getName() const override {
        return "rad";
    }

    int getNumCount() const override {
        return 1;
    }

    std::string getHelp() const override {
        return "Degrees to radians: rad(x)";
    }

    double run(const std::vector<double>& nums) override {
        if (nums.size() != 1) {
            throw std::invalid_argument("rad needs 1 number");
        }
        return nums[0] * 3.14159265358979323846 / 180.0;
    }
};

extern "C" __declspec(dllexport) ICalcFunc* makeFunc() {
    return new RadPlug();
}