#pragma once

#include <iostream>
#include <string>
#include <map>
#include <any>
#include <stdexcept>
#include <vector>
#include <mutex>
#include <thread>
#include <atomic>
#include <tuple>
#include <type_traits>

using namespace std;

// Для C++17 
template<typename T>
struct remove_cvref {
    using type = remove_cv_t<remove_reference_t<T>>;
};

template<typename T>
using remove_cvref_t = typename remove_cvref<T>::type;

// Базовый класс для всех команд
class BaseCommand {
public:
    virtual ~BaseCommand() = default;
    virtual any run(const map<string, any>& args) = 0;
};