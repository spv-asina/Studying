#include "plug_load.h"
#include <iostream>
#include <filesystem>

PlugLoad::~PlugLoad() {
    closeAll();
}

HMODULE PlugLoad::openLib(const std::string& path) {
    HMODULE h = LoadLibraryA(path.c_str());
    if (!h) {
        throw PluginErr("Cant open: " + path);
    }
    return h;
}

void PlugLoad::closeLib(HMODULE h) {
    if (h) {
        FreeLibrary(h);
    }
}

void* PlugLoad::getProc(HMODULE h, const std::string& name) {
    return GetProcAddress(h, name.c_str());
}

std::vector<FuncP> PlugLoad::loadFromDir(const std::string& dir) {
    std::vector<FuncP> funcs;

    try {
        namespace fs = std::filesystem;

        if (!fs::exists(dir)) {
            std::cerr << "No dir: " << dir << std::endl;
            return funcs;
        }

        for (const auto& entry : fs::directory_iterator(dir)) {
            if (entry.is_regular_file()) {
                std::string path = entry.path().string();

                if (path.find(".dll") == std::string::npos) continue;

                try {
                    HMODULE lib = openLib(path.c_str());

                    typedef ICalcFunc* (*MakeFunc)();
                    auto makeFunc = reinterpret_cast<MakeFunc>(
                        getProc(lib, "makeFunc"));

                    if (!makeFunc) {
                        std::cerr << "Bad plugin (no makeFunc): " << path << std::endl;
                        closeLib(lib);
                        continue;
                    }

                    ICalcFunc* func = makeFunc();
                    if (!func) {
                        std::cerr << "Plugin made null: " << path << std::endl;
                        closeLib(lib);
                        continue;
                    }

                    funcs.push_back(FuncP(func));
                    libs.push_back(lib);

                    std::cout << "Got: " << func->getName()
                        << " from " << entry.path().filename().string() << std::endl;

                }
                catch (const std::exception& e) {
                    std::cerr << "Error on " << path << ": " << e.what() << std::endl;
                }
            }
        }

    }
    catch (const std::exception& e) {
        throw PluginErr("Cant read dir: " + std::string(e.what()));
    }

    return funcs;
}

void PlugLoad::closeAll() {
    for (HMODULE lib : libs) {
        closeLib(lib);
    }
    libs.clear();
}
