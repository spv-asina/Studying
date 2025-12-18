#include "tests.h"
#include <locale.h>

int main() {
    setlocale(LC_ALL, "Russian");

    try {
        test_assignment();
        test_different_args();
        test_errors();
        test_threads();
        test_defaults();

        return 0;
    }
    catch (const exception& e) {
        cerr << "\nОшибка: " << e.what() << endl;
        return 1;
    }
}