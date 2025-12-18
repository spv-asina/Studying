#include "tests.h"
#include <locale.h>

// Тест
void test_assignment() {
    TestClass obj;

    MethodWrapper<TestClass, int, int, int> wrapper(&obj, &TestClass::f3,
        { {"arg1", 0}, {"arg2", 0} });

    CommandManager manager;
    manager.add_command(&wrapper, "command1");

    cout << "Вызов команды command1 с аргументами arg1=4, arg2=5:" << endl;
    auto res = manager.execute("command1", { {"arg1", 4}, {"arg2", 5} });
    cout << "Результат: " << any_cast<int>(res) << endl;

    if (any_cast<int>(res) == 9) {
        cout << "Чётко, тест пройден" << endl;
    }
    else {
        cout << "Тест не пройден" << endl;
    }
}

// Разное число аргументов
void test_different_args() {
    cout << "\nМетоды с разным числом аргументов" << endl;

    TestClass obj;
    CommandManager manager;

    MethodWrapper<TestClass, int, int, int> wrap1(&obj, &TestClass::f3, { {"x", 0}, {"y", 0} });
    manager.add_command(&wrap1, "sum");

    MethodWrapper<TestClass, int, int> wrap2(&obj, &TestClass::square, { {"n", 0} });
    manager.add_command(&wrap2, "square");

    MethodWrapper<TestClass, int> wrap3(&obj, &TestClass::get_meaning);
    manager.add_command(&wrap3, "meaning");

    MethodWrapper<TestClass, double, double, int, float> wrap4(&obj, &TestClass::calc,
        { {"a", 0.0}, {"b", 0}, {"c", 0.0f} });
    manager.add_command(&wrap4, "calc");

    auto r1 = manager.execute("sum", { {"x", 15}, {"y", 25} });
    cout << "sum(15, 25) = " << any_cast<int>(r1) << endl;

    auto r2 = manager.execute("square", { {"n", 9} });
    cout << "square(9) = " << any_cast<int>(r2) << endl;

    auto r3 = manager.execute("meaning", {});
    cout << "get_meaning() = " << any_cast<int>(r3) << endl;

    auto r4 = manager.execute("calc", { {"a", 3.5}, {"b", 2}, {"c", 1.5f} });
    cout << "calc(3.5, 2, 1.5) = " << any_cast<double>(r4) << endl;
}

//Проверка ошибок
void test_errors() {
    cout << "\nПроверка обработки ошибок" << endl;

    TestClass obj;
    MethodWrapper<TestClass, int, int, int> wrapper(&obj, &TestClass::f3,
        { {"a", 0}, {"b", 0} });

    CommandManager manager;
    manager.add_command(&wrapper, "sum");

    try {
        manager.execute("sum", { {"a", 5}, {"b", string("текст")} });
        cout << "Не поймано исключение при неправильном типе" << endl;
    }
    catch (const exception& e) {
        cout << "Поймано исключение (неправильный тип): " << e.what() << endl;
    }

    try {
        manager.execute("sum", { {"a", 5} });
        cout << "Не поймано исключение при недостатке аргументов" << endl;
    }
    catch (const exception& e) {
        cout << "Поймано исключение (нет аргумента): " << e.what() << endl;
    }

    try {
        manager.execute("unknown", {});
        cout << "Не поймано исключение при неизвестной команде" << endl;
    }
    catch (const exception& e) {
        cout << "Поймано исключение (нет команды): " << e.what() << endl;
    }
}

// Многопоточность
void test_threads() {
    cout << "\nПроверка многопоточности" << endl;

    TestClass obj;
    MethodWrapper<TestClass, int, int, int> wrapper(&obj, &TestClass::f3,
        { {"x", 0}, {"y", 0} });

    CommandManager manager;
    manager.add_command(&wrapper, "sum");

    vector<thread> threads;
    atomic<int> success{ 0 };
    int thread_count = 5;
    int repeats = 20;

    for (int t = 0; t < thread_count; ++t) {
        threads.emplace_back([&manager, &success, repeats, t]() {
            for (int i = 0; i < repeats; ++i) {
                try {
                    auto res = manager.execute("sum", { {"x", t}, {"y", i} });
                    if (any_cast<int>(res) == t + i) {
                        success++;
                    }
                }
                catch (...) {
                }
            }
            });
    }

    for (auto& t : threads) {
        t.join();
    }

    int total = thread_count * repeats;
    cout << "Выполнено " << total << " операций в " << thread_count << " потоках" << endl;
}

// Значения по умолчанию
void test_defaults() {
    cout << "\nПроверка значений по умолчанию" << endl;

    TestClass obj;

    MethodWrapper<TestClass, int, int, int> wrapper(&obj, &TestClass::f3,
        { {"a", 100}, {"b", 200} });

    CommandManager manager;
    manager.add_command(&wrapper, "sum_default");

    auto r1 = manager.execute("sum_default", { {"a", 50} });
    cout << "sum_default(50, default=200) = " << any_cast<int>(r1) << endl;
    cout << "По факту: 250" << endl;

    auto r2 = manager.execute("sum_default", { {"a", 5}, {"b", 10} });
    cout << "sum_default(5, 10) = " << any_cast<int>(r2) << endl;
    cout << "По факту: 15" << endl;

    auto r3 = manager.execute("sum_default", {});
    cout << "sum_default(default=100, default=200) = " << any_cast<int>(r3) << endl;
    cout << "По факту: 300" << endl;
}