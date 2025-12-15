// Практика 1: final-метод нельзя переопределять
class SuperClass {
    public final void show() {
        System.out.println("Это final-метод");
    }

    public void normalMethod() {
        System.out.println("Это обычный метод");
    }
}

class SubClass extends SuperClass {
    // public void show() { // Ошибка компиляции
    //     System.out.println("Попытка переопределения");
    // }

    @Override
    public void normalMethod() {
        System.out.println("Переопределенный метод");
    }
}

final class FinalClass {
    public void test() {
        System.out.println("Класс FinalClass");
    }
}

// class AnotherClass extends FinalClass { // Ошибка компиляции
//     // Нельзя наследовать от final-класса
// }

public class Main {
    public static void main(String[] args) {
        System.out.println("Практика 1:");
        SuperClass obj1 = new SuperClass();
        obj1.show(); // final-метод
        obj1.normalMethod();

        SubClass obj2 = new SubClass();
        obj2.show(); // унаследованный final-метод
        obj2.normalMethod(); // переопределенный метод

        System.out.println("\nПрактика 2:");
        FinalClass f = new FinalClass();
        f.test();

        // Класс AnotherClass не может наследовать FinalClass, поэтому закомментирован
    }
}
