public class Main {
    public static void main(String[] args) {
        System.out.println("Примеры перегрузки и переопределения методов:");

        // Пример перегрузки
        System.out.println("\n1. Перегрузка методов (overloading):");
        Calculator calc = new Calculator();

        System.out.println("calc.add(5, 3) = " + calc.add(5, 3));
        System.out.println("calc.add(5.5, 3.2) = " + calc.add(5.5, 3.2));
        System.out.println("calc.add(1, 2, 3) = " + calc.add(1, 2, 3));
        System.out.println("calc.add(\"Hello, \", \"World!\") = " + calc.add("Hello, ", "World!"));

        // Пример переопределения
        System.out.println("\n2. Переопределение методов (override):");

        Animal animal = new Animal();
        Dog dog = new Dog();
        Cat cat = new Cat();

        System.out.println("Animal говорит: " + animal.speak());
        System.out.println("Dog говорит: " + dog.speak());
        System.out.println("Cat говорит: " + cat.speak());

        // Полиморфизм
        System.out.println("\n3. Полиморфизм:");
        Animal myDog = new Dog();
        Animal myCat = new Cat();

        System.out.println("myDog (Animal ссылка на Dog): " + myDog.speak());
        System.out.println("myCat (Animal ссылка на Cat): " + myCat.speak());
    }
}

// Класс для демонстрации перегрузки
class Calculator {
    // Метод сложения для целых чисел
    int add(int a, int b) {
        return a + b;
    }

    // Перегрузка для чисел с плавающей точкой
    double add(double a, double b) {
        return a + b;
    }

    // Перегрузка для трех целых чисел
    int add(int a, int b, int c) {
        return a + b + c;
    }

    // Перегрузка для строк
    String add(String a, String b) {
        return a + b;
    }

    // Этот метод не будет компилироваться - тип возвращаемого значения не влияет на перегрузку
    // double add(int a, int b) { return a + b; } // ОШИБКА!
}

// Базовый класс для демонстрации переопределения
class Animal {
    String speak() {
        return "Животное издает звук";
    }
}

// Подкласс Dog переопределяет метод speak
class Dog extends Animal {
    @Override
    String speak() {
        return "Гав-гав!";
    }
}

// Подкласс Cat переопределяет метод speak
class Cat extends Animal {
    @Override
    String speak() {
        return "Мяу-мяу!";
    }
}
