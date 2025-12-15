public class Main {
    public static void main(String[] args) {
        System.out.println("Способы инициализации final поля 'a':");

        // 1. Через конструктор
        A obj1 = new A(10);
        System.out.println("1. Через конструктор: a = " + obj1.a);

        // 2. В блоке инициализации
        B obj2 = new B();
        System.out.println("2. В блоке инициализации: a = " + obj2.a);

        // 3. При объявлении
        C obj3 = new C();
        System.out.println("3. При объявлении: a = " + obj3.a);

        // 4. Через вызов метода в конструкторе
        D obj4 = new D();
        System.out.println("4. Через метод в конструкторе: a = " + obj4.a);
    }
}

// 1. Инициализация через конструктор
class A {
    public final int a;

    public A(int value) {
        this.a = value;  // Инициализация в конструкторе
    }
}

// 2. Инициализация в блоке инициализации
class B {
    public final int a;

    // Блок инициализации
    {
        a = 20;  // Инициализация в блоке
    }

    public B() {
        // Можно не инициализировать здесь, если уже инициализировано в блоке
    }
}

// 3. Инициализация при объявлении
class C {
    public final int a = 30;  // Инициализация при объявлении
}

// 4. Инициализация через вызов метода в конструкторе
class D {
    public final int a;

    public D() {
        this.a = calculateValue();  // Инициализация через метод
    }

    private int calculateValue() {
        return 40;
    }
}
