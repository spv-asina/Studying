class A {
    int a1 = 1;
    public int a2 = 2;
    protected int a3 = 3;
    private int a4 = 4;

    void method1() {
        System.out.println("method1");
    }

    public void method2() {
        System.out.println("method2");
    }

    protected void method3() {
        System.out.println("method3");
    }

    private void method4() {
        System.out.println("method4");
    }
}

class B extends A {
    int b1 = 5;

    public void show() {

        // this ссылается на текущий объект класса B
        System.out.println("this.b1 = " + this.b1);

        // super ссылается на родительский класс A
        System.out.println("super.a2 = " + super.a2);

        // Вызов метода родительского класса через super
        super.method2();

        // this можно использовать для вызова методов текущего класса
        this.method5();
    }

    public void method5() {
        System.out.println("method5 в классе B");
    }

    // Переопределяем метод из родительского класса
    @Override
    public void method2() {
        System.out.println("Переопределенный method2 в классе B");
    }
}

class C extends B {
    public void test() {

        System.out.println("Доступ из класса C:");

        // default (a1) - доступен, если классы в одном пакете
        System.out.println("a1 (default): " + a1);

        // public (a2) - доступен всегда
        System.out.println("a2 (public): " + a2);

        // protected (a3) - доступен в подклассах
        System.out.println("a3 (protected): " + a3);

        // private (a4) - недоступен
        // System.out.println("a4 (private): " + a4); // Ошибка компиляции

        // Методы:
        method1();  // default - доступен в том же пакете
        method2();  // public - доступен всегда
        method3();  // protected - доступен в подклассах
        // method4(); // private - недоступен

        // Поле из класса B
        System.out.println("b1 из класса B: " + b1);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Практика 1:");
        B objB = new B();
        objB.show();

        System.out.println("\nПрактика 2:");
        C objC = new C();
        objC.test();
    }
}
