cmake_minimum_required(VERSION 3.15)

project(Calc)

set(CMAKE_CXX_STANDARD 17)

if(MSVC)
    add_compile_options(/W4)
endif()

add_executable(calc
    Src/main.cpp
    Src/calc_core.cpp
    Src/expr_parse.cpp
    Src/plug_load.cpp
)


add_library(plg_sin SHARED Plugins/sin.cpp)
target_include_directories(plg_sin PRIVATE src)

add_library(plg_cos SHARED Plugins/cos.cpp)
target_include_directories(plg_cos PRIVATE src)

add_library(plg_tg SHARED Plugins/tg.cpp)
target_include_directories(plg_tg PRIVATE src)

add_library(plg_ctg SHARED Plugins/ctg.cpp)
target_include_directories(plg_ctg PRIVATE src)

add_library(plg_deg SHARED Plugins/deg.cpp)
target_include_directories(plg_deg PRIVATE src)

add_library(plg_rad SHARED Plugins/rad.cpp)
target_include_directories(plg_rad PRIVATE src)

add_library(plg_ln SHARED Plugins/ln.cpp)
target_include_directories(plg_ln PRIVATE src)

add_library(plg_log SHARED Plugins/log.cpp)
target_include_directories(plg_log PRIVATE src)

add_library(plg_abs SHARED Plugins/abs.cpp)
target_include_directories(plg_abs PRIVATE src)

target_link_libraries(calc Kernel32)

# Установка путей
set_target_properties(calc PROPERTIES
    RUNTIME_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}
)

# Список всех плагинов
set(ALL_PLUGS 
    plg_sin plg_cos plg_tg plg_ctg plg_deg plg_rad
    plg_ln plg_log plg_abs
)

# Установка путей для плагинов
foreach(plug IN LISTS ALL_PLUGS)
    set_target_properties(${plug} PROPERTIES
        RUNTIME_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/plugins
        LIBRARY_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/plugins
    )
endforeach()

# Создание папки для плагинов
add_custom_target(make_plug_dir ALL
    COMMAND ${CMAKE_COMMAND} -E make_directory ${CMAKE_BINARY_DIR}/plugins
)

# Копирование плагинов
foreach(plug IN LISTS ALL_PLUGS)
    add_custom_command(TARGET ${plug} POST_BUILD
        COMMAND ${CMAKE_COMMAND} -E copy $<TARGET_FILE:${plug}> ${CMAKE_BINARY_DIR}/plugins/
    )
endforeach()
