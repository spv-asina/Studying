// Основной класс с разными спецификаторами доступа
class ExampleClass {
    // private - доступен только внутри этого класса
    private int privateField = 1;

    // default (без спецификатора) - доступен в том же пакете
    int defaultField = 2;

    // protected - доступен в том же пакете и подклассам
    protected int protectedField = 3;

    // public - доступен всем
    public int publicField = 4;

    // private метод
    private void privateMethod() {
        System.out.println("Private method");
    }

    // default метод
    void defaultMethod() {
        System.out.println("Default method");
    }

    // protected метод
    protected void protectedMethod() {
        System.out.println("Protected method");
    }

    // public метод
    public void publicMethod() {
        System.out.println("Public method");
        // private метод доступен внутри класса
        privateMethod();
    }
}

// Класс в том же пакете
class SamePackageClass {
    public void testAccess() {
        ExampleClass obj = new ExampleClass();

        // Доступ к полям:
        // obj.privateField = 10; // Ошибка! private недоступен
        obj.defaultField = 20;    // OK - в том же пакете
        obj.protectedField = 30;  // OK - в том же пакете
        obj.publicField = 40;     // OK - всегда доступен

        // Доступ к методам:
        // obj.privateMethod();   // Ошибка!
        obj.defaultMethod();      // OK
        obj.protectedMethod();    // OK
        obj.publicMethod();       // OK
    }
}

// Подкласс в том же пакете
class SubClassInSamePackage extends ExampleClass {
    public void testAccess() {
        // Наследуем protected и public поля/методы

        // this.privateField = 10; // Ошибка!
        // this.defaultField = 20; // Ошибка! default не наследуется в другом пакете
        // Но здесь в том же пакете, поэтому доступен
        this.defaultField = 20;     // OK - в том же пакете
        this.protectedField = 30;   // OK - protected наследуется
        this.publicField = 40;      // OK - public наследуется

        // Доступ к методам:
        // this.privateMethod();   // Ошибка!
        this.defaultMethod();       // OK
        this.protectedMethod();     // OK
        this.publicMethod();        // OK
    }
}
// Главный класс
public class Main {
    public static void main(String[] args) {
        System.out.println("Примеры спецификаторов доступа:");

        ExampleClass example = new ExampleClass();
        SamePackageClass samePackage = new SamePackageClass();
        SubClassInSamePackage subclass = new SubClassInSamePackage();

        // Тест из того же класса
        System.out.println("\n1. Из того же класса:");
        example.publicMethod();

        // Тест из того же пакета
        System.out.println("\n2. Из того же пакета:");
        samePackage.testAccess();

        // Тест из подкласса в том же пакете
        System.out.println("\n3. Из подкласса в том же пакете:");
        subclass.testAccess();

        // Демонстрация доступа из любого места
        System.out.println("\n4. Доступ к public из любого места:");
        System.out.println("publicField = " + example.publicField);
        example.publicMethod();

        System.out.println("\nВывод:");
        System.out.println("- private: только внутри класса");
        System.out.println("- default: только в том же пакете");
        System.out.println("- protected: в том же пакете + подклассы в любых пакетах");
        System.out.println("- public: везде");
    }
}
