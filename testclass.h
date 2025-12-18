#pragma once

#include <iostream>
using namespace std;

class TestClass {
public:
    int f3(int a, int b) {
        return a + b;
    }

    int square(int x) {
        return x * x;
    }

    int get_meaning() {
        return 42;
    }

    double calc(double x, int y, float z) {
        return x * y + z;
    }

    void show_text(string text, int count) {
        for (int i = 0; i < count; ++i) {
            cout << text;
        }
        cout << endl;
    }

    void say_hi() {
        cout << "Привет!" << endl;
    }
};