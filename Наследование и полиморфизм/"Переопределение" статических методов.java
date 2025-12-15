class A {
    public static void method() {
        System.out.println("Статический метод класса A");
    }

    public void nonStaticMethod() {
        System.out.println("Нестатический метод класса A");
    }
}

class B extends A {
    // Это не переопределение, а сокрытие (method hiding)
    public static void method() {
        System.out.println("Статический метод класса B");
    }

    @Override
    public void nonStaticMethod() {
        System.out.println("Переопределенный нестатический метод класса B");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Практика #1: Статические методы и полиморфизм");

        A a = new A();
        B b = new B();
        A ab = new B();

        System.out.println("\n1. Статические методы:");
        a.method();   // A.method()
        b.method();   // B.method()
        ab.method();  // A.method() - НЕ B.method()!

        System.out.println("\n2. Нестатические методы:");
        a.nonStaticMethod();   // A.nonStaticMethod()
        b.nonStaticMethod();   // B.nonStaticMethod()
        ab.nonStaticMethod();  // B.nonStaticMethod() - полиморфизм работает

        System.out.println("\nОбъяснение:");
        System.out.println("- Статические методы принадлежат классу, а не объекту");
        System.out.println("- Вызов статического метода определяется на этапе компиляции");
        System.out.println("- Тип переменной (A или B) определяет, какой статический метод будет вызван");
        System.out.println("- Нестатические методы переопределяются и вызываются на основе типа объекта");
    }
}
