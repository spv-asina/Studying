class Parent1 {
    int x = 10;

    Parent1() {
        System.out.println("Parent1 конструктор");
    }

    Parent1(int x) {
        this.x = x;
    }

    void show() {
        System.out.println("Parent1 show: " + x);
    }
}

class Child1 extends Parent1 {
    int x = 20;

    Child1() {
        super(); // 1. Обращение к конструктору суперкласса
        System.out.println("Child1 конструктор");
    }

    Child1(int x) {
        super(x); // 2. Обращение к конструктору суперкласса с параметром
    }

    void test() {
        System.out.println("super.x = " + super.x); // 3. Доступ к полю суперкласса
        super.show(); // 4. Доступ к методу суперкласса
    }
}

class A {
    int a = 1;

    void method() {
        System.out.println("Метод класса A");
    }
}

class B extends A {
    // Класс B не переопределяет a и method
}

class C extends B {
    void method() {
        System.out.println("a из класса A через super: " + super.a);
        super.method();
    }
}

class A3 {
    int a;
    int b;
    int c;
    int z;

    public A3() {
        this(0, 0, 0);
    }

    public A3(int a) {
        this(a, 0, 0);
    }

    public A3(int a, int b) {
        this(a, b, 0);
    }

    public A3(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.z = 1;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Практика #1:");
        Child1 obj1 = new Child1();
        obj1.test();

        System.out.println("\nПрактика #2:");
        C obj2 = new C();
        obj2.method();

        System.out.println("\nПрактика #3:");
        A3 obj3 = new A3(10, 20, 30);
        System.out.println("a = " + obj3.a + ", b = " + obj3.b + ", c = " + obj3.c + ", z = " + obj3.z);
    }
}
