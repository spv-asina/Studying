// Практика 1
interface I1 {
    // Абстрактный метод
    void m1();

    // Неабстрактный default метод
    default void m2() {
        System.out.println("m2 из I1");
    }

    // Статический метод
    static void m3() {
        System.out.println("m3 из I1");
    }
}

class C1 implements I1 {
    @Override
    public void m1() {
        System.out.println("m1 из C1");
    }

    // Можно переопределить default метод
    @Override
    public void m2() {
        System.out.println("m2 из C1");
    }
}

// Практика 2
interface I2 {
    default void m() {
        System.out.println("m из I2");
    }
}

interface I3 {
    default void m() {
        System.out.println("m из I3");
    }
}

// Ошибка: неоднозначность
// class C2 implements I2, I3 {
//     // Нужно явно указать, какой метод использовать
// }

class C3 implements I2, I3 {
    // Решение 1: Переопределяем конфликтующий метод
    @Override
    public void m() {
        System.out.println("m из C3");
        // Можно вызвать методы интерфейсов
        I2.super.m();
        I3.super.m();
    }
}

class C4 implements I2, I3 {
    // Решение 2: Выбираем один из интерфейсов
    @Override
    public void m() {
        I2.super.m(); // Используем реализацию из I2
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Практика #1:");

        C1 obj = new C1();
        obj.m1(); // Вызов абстрактного метода
        obj.m2(); // Вызов default метода
        I1.m3();  // Вызов статического метода по имени интерфейса

        System.out.println("\nПрактика #2:");

        C3 obj3 = new C3();
        obj3.m();

        C4 obj4 = new C4();
        obj4.m();
    }
}
