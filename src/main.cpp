#include "calc_core.h"
#include <iostream>
#include <string>
#include <iomanip>
#include <locale.h>
#include <algorithm>

void showCmds() {
    std::cout << "Доступные команды:\n"
        << "  <выражение> - Вычислить (пример: 2 + 3 * (4 - 1))\n"
        << "  funcs     - Показать доступные функции\n"
        << "  plugs     - Показать загруженные плагины\n"
        << "  help      - Показать эту справку\n"
        << "  quit       - Выйти из программы\n"
        << "  clear    - Очистить экран\n"
        << std::endl;
}

void showFuncs(const CalcCore& calc) {
    auto funcs = calc.getFuncs();
    std::cout << "Доступные функции (" << funcs.size() << "):\n";
    for (const auto& func : funcs) {
        std::cout << "  " << func << "\n";
    }
    std::cout << std::endl;
}

void showStart() {
    std::cout << "Калькулятор\n"
        << "Введите 'помощь' для списка команд\n"
        << std::endl;
}

// Функция для обрезки пробелов
std::string trim(const std::string& str) {
    size_t start = str.find_first_not_of(" \t\n\r");
    if (start == std::string::npos) return "";
    size_t end = str.find_last_not_of(" \t\n\r");
    return str.substr(start, end - start + 1);
}

int main() {
    setlocale(LC_ALL, "Russian");

    CalcCore calc;

    try {
        std::cout << "Загрузка плагинов..." << std::endl;
        calc.loadPlugs("./plugins");
        std::cout << "Загружено " << calc.getPlugs().size() << " плагинов" << std::endl;
    }
    catch (const std::exception& e) {
        std::cerr << "Предупреждение: " << e.what() << std::endl;
    }

    showStart();

    std::string input;
    while (true) {
        std::cout << "> ";
        if (!std::getline(std::cin, input)) {
            break;
        }

        std::string trimmed = trim(input);

        if (trimmed.empty()) {
            continue;
        }

        std::string lower = trimmed;
        std::transform(lower.begin(), lower.end(), lower.begin(), ::tolower);

        if (lower == "выход" || lower == "quit" || lower == "exit") {
            std::cout << "Выход!" << std::endl;
            break;
        }
        else if (lower == "помощь" || lower == "help" || lower == "?" || lower == "/?") {
            showCmds();
        }
        else if (lower == "функции" || lower == "funcs") {
            showFuncs(calc);
        }
        else if (lower == "плагины" || lower == "plugs") {
            auto plugs = calc.getPlugs();
            std::cout << "Загруженные плагины (" << plugs.size() << "):\n";
            for (const auto& plug : plugs) {
                std::cout << "  " << plug << "\n";
            }
            std::cout << std::endl;
        }
        else if (lower == "очистить" || lower == "clear") {
            system("cls");
        }
        else {
            try {
                double res = calc.calc(trimmed);
                std::cout << "= " << std::setprecision(15) << res << std::endl;
            }
            catch (const std::exception& e) {
                std::cout << "Ошибка: " << e.what() << std::endl;
            }
        }
    }

    return 0;
}
