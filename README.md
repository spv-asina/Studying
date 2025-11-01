# Calculator
Калькулятор с системой плагинов для математических операций

## Сборка через Windows Batch
build.bat

## Компиляция плагинов
g++ -shared -o sin_plugin.dll plugins/sin.cpp

## Запуск
./calc.exe "2 + 3 * (4 - 1)"
Или
./calc.exe
> Введите выражение: sin(3.14/2) + 2*3
> Результат: 7.00

## Создание нового плагина
#include <string>
#include <cmath>
extern "C" {
    // Обязательная функция: возвращает имя функции
    const char* get_function_name() {
        return "cos";
    }
    
    // Обязательная функция: выполняет вычисление
    double execute_function(double x) {
        return std::cos(x);
    }
}

