@echo off
echo Сборка Calc...

if not exist build mkdir build
cd build

echo Запуск CMake...
cmake ..

echo Сборка проекта...
cmake --build . --config Release

if %errorlevel% == 0 (
    echo.
    echo Сборка завершена!
    echo.
    echo Запуск: calc.exe
) else (
    echo.
    echo Ошибка сборки!
)

cd ..
pause
