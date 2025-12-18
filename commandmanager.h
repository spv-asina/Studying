#pragma once

#include "MethodWrapper.h"

// Основной класс для управления командами
class CommandManager {
private:
    map<string, BaseCommand*> commands;
    mutable mutex mtx;

public:
    // Добавить команду
    void add_command(BaseCommand* cmd, const string& name) {
        lock_guard<mutex> lock(mtx);
        commands[name] = cmd;
    }

    // Выполнить команду
    any execute(const string& name, const map<string, any>& args) {
        lock_guard<mutex> lock(mtx);

        auto it = commands.find(name);
        if (it == commands.end()) {
            throw runtime_error("Команда не найдена: " + name);
        }
        return it->second->run(args);
    }

    // Проверить есть ли команда
    bool has_command(const string& name) const {
        lock_guard<mutex> lock(mtx);
        return commands.find(name) != commands.end();
    }

    ~CommandManager() {
        lock_guard<mutex> lock(mtx);
        commands.clear();
    }
};