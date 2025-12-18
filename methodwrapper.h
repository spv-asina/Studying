#pragma once

#include "BaseCommand.h"

// Обертка для метода любого класса
template<typename T, typename R, typename... A>
class MethodWrapper : public BaseCommand {
private:
    T* obj;
    R(T::* func)(A...);
    vector<string> param_names;
    map<string, any> default_vals;

    template<typename U>
    U get_param(const string& name, const map<string, any>& params) const {
        auto it = params.find(name);
        if (it != params.end()) {
            try {
                return any_cast<U>(it->second);
            }
            catch (const bad_any_cast&) {
                throw invalid_argument("Неверный тип аргумента: " + name);
            }
        }

        auto def_it = default_vals.find(name);
        if (def_it != default_vals.end()) {
            try {
                return any_cast<U>(def_it->second);
            }
            catch (const bad_any_cast&) {
                throw invalid_argument("Неверный тип значения по умолчанию: " + name);
            }
        }

        throw invalid_argument("Не хватает аргумента: " + name);
    }

    template<size_t... I>
    any call_method(const map<string, any>& params, index_sequence<I...>) {
        if constexpr (is_same_v<R, void>) {
            (obj->*func)(get_param<remove_cvref_t<tuple_element_t<I, tuple<A...>>>>(param_names[I], params)...);
            return any();
        }
        else {
            return (obj->*func)(get_param<remove_cvref_t<tuple_element_t<I, tuple<A...>>>>(param_names[I], params)...);
        }
    }

public:
    MethodWrapper(T* object, R(T::* method)(A...), map<string, any> defaults = {})
        : obj(object), func(method), default_vals(defaults) {
        if (!defaults.empty()) {
            for (const auto& p : defaults) {
                param_names.push_back(p.first);
            }
        }
        else {
            for (size_t i = 0; i < sizeof...(A); ++i) {
                param_names.push_back("param" + to_string(i));
            }
        }

        if (param_names.size() != sizeof...(A)) {
            throw runtime_error("Не совпадает число имен параметров с сигнатурой метода");
        }
    }

    // Выполнить команду
    any run(const map<string, any>& params) override {
        if (param_names.size() != sizeof...(A)) {
            throw runtime_error("Не совпадает число аргументов");
        }

        return call_method(params, index_sequence_for<A...>{});
    }
};