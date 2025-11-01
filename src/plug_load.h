#pragma once
#include "base_func.h"
#include "errors.h"
#include <vector>
#include <string>
#include <memory>
#include <windows.h>

class PlugLoad {
private:
    std::vector<HMODULE> libs;

    HMODULE openLib(const std::string& path);
    void closeLib(HMODULE h);
    void* getProc(HMODULE h, const std::string& name);

public:
    ~PlugLoad();

    std::vector<FuncP> loadFromDir(const std::string& dir);
    void closeAll();
};
