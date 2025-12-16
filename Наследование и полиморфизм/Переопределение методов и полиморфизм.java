class Calculator {
    // Перегруженные методы сложения
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

    String add(String a, String b) {
        return a + b;
    }
}

class Animal {
    String sound() {
        return "Животное издает звук";
    }

    Animal getAnimal() {
        return new Animal();
    }
}

class Dog extends Animal {
    // Переопределение метода sound
    @Override
    String sound() {
        return "Гав-гав";
    }

    // Ковариантный возвращаемый тип - разрешено (возвращает подтип)
    @Override
    Dog getAnimal() {
        return new Dog();
    }
}

class Test {
    int getValue() {
        return 10;
    }
}

class TestChild extends Test {
    // Этот метод не скомпилируется, если раскомментировать,
    // потому что тип возвращаемого значения отличается и не является подтипом
    /*
    @Override
    double getValue() {
        return 10.5;
    }
    */
}

class Parent {
    void display() {
        System.out.println("Метод Parent");
    }

    void show(int x) {
        System.out.println("show(int) в Parent: " + x);
    }
}

class Child extends Parent {
    // Правильное переопределение
    @Override
    void display() {
        System.out.println("Метод Child");
    }

    // Ошибка: метод с таким именем не найден в родительском классе
    // @Override
    // void DisplaY() { // Опечатка в имени метода
    //     System.out.println("Ошибочный метод");
    // }

    // Ошибка: сигнатура метода не совпадает (разные параметры)
    // @Override
    // void show() { // В родителе show(int), а тут show()
    //     System.out.println("Неверная сигнатура");
    // }

    // Правильное переопределение
    @Override
    void show(int x) {
        System.out.println("show(int) в Child: " + x);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Практика #1");
        Calculator calc = new Calculator();
        System.out.println("calc.add(2, 3) = " + calc.add(2, 3));
        System.out.println("calc.add(2.5, 3.5) = " + calc.add(2.5, 3.5));
        System.out.println("calc.add(1, 2, 3) = " + calc.add(1, 2, 3));
        System.out.println("calc.add(\"Hello, \", \"World!\") = " + calc.add("Hello, ", "World!"));

        System.out.println("\nПрактика #2");
        Animal animal = new Animal();
        Dog dog = new Dog();
        System.out.println("animal.sound() = " + animal.sound());
        System.out.println("dog.sound() = " + dog.sound());

        // Полиморфизм
        Animal myDog = new Dog();
        System.out.println("myDog.sound() (Animal ссылка на Dog) = " + myDog.sound());

        System.out.println("\nПрактика #3");
        Parent p = new Parent();
        Child c = new Child();

        p.display();
        c.display();

        p.show(10);
        c.show(20);

        // Демонстрация ошибки при использовании @Override
        System.out.println("\nДемонстрация ошибок, которые обнаруживает @Override:");
        System.out.println("1. Опечатка в имени метода");
        System.out.println("2. Несовпадение сигнатуры метода");
        System.out.println("3. Попытка переопределения несуществующего метода");
    }
}
