// Практика 1
interface I1 {
    void m1();
    int X = 10; // public static final по умолчанию
}

// Практика 2
// должен быть в файле I2.java
// public interface I2 {
//     void m2();
// }

// Практика 3 и 4
// Нельзя объявлять для top-level интерфейсов
class Outer {
    // Вложенный protected интерфейс
    protected interface I3 {
        void m3();
    }

    // Вложенный private интерфейс
    private interface I4 {
        void m4();
    }
}

// Класс, реализующий интерфейс I1
class C1 implements I1 {
    @Override
    public void m1() {
        System.out.println("m1: X = " + X);
    }
}

// Абстрактный класс, не реализующий все методы
abstract class C2 implements I1 {
    // m1() не реализован, поэтому класс абстрактный
}

// Наследование интерфейсов
interface I5 extends I1 {
    void m5();
}

// Класс, реализующий несколько интерфейсов
class C3 implements I1, I5 {
    @Override
    public void m1() {
        System.out.println("m1 из C3");
    }

    @Override
    public void m5() {
        System.out.println("m5 из C3");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Практика #1:");
        System.out.println("interface I1 {} имеет default (package-private) область видимости");
        System.out.println("Виден только в том же пакете");

        System.out.println("\nПрактика #2:");
        System.out.println("public interface Interface {} имеет public область видимости");
        System.out.println("Виден везде, должен быть в отдельном файле");

        System.out.println("\nПрактика #3:");
        System.out.println("protected interface Interface {} - ошибка компиляции");
        System.out.println("Нельзя использовать protected для top-level интерфейса");

        System.out.println("\nПрактика #4:");
        System.out.println("private interface Interface {} - ошибка компиляции");
        System.out.println("Нельзя использовать private для top-level интерфейса");

        System.out.println("\nПример работы:");
        C1 obj1 = new C1();
        obj1.m1();

        C3 obj3 = new C3();
        obj3.m1();
        obj3.m5();

        System.out.println("\nВсе поля интерфейса автоматически public static final:");
        System.out.println("I1.X = " + I1.X);
    }
}
