public class Main {
    public static void main(String[] args) {
        System.out.println("Варианты вызова статического метода printVars():");

        // 1. Через имя класса
        System.out.println("\n1. Через имя класса:");
        A.printVars();

        // 2. Через экземпляр класса
        System.out.println("\n2. Через экземпляр класса:");
        A obj = new A();
        obj.printVars();

        // 3. Из другого статического метода того же класса
        System.out.println("\n3. Из другого статического метода того же класса:");
        A.callFromStatic();

        // 4. Из нестатического метода того же класса
        System.out.println("\n4. Из нестатического метода того же класса:");
        A obj2 = new A();
        obj2.callFromNonStatic();

        // 5. Внутри класса A без указания (из статического контекста)
        System.out.println("\n5. Внутри статического блока инициализации:");
        // Статический блок уже выполнился при загрузке класса

        System.out.println("\n6. Непосредственно из статического метода main другого класса:");
        // Это вариант 1, уже показано
    }
}

class A {
    public static int a = 1;
    public static int b;

    static {
        // Статический блок инициализации
        b = 2;
        System.out.println("Статический блок: вызов printVars()");
        printVars(); // Вызов без указания класса
    }

    public static void printVars() {
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    public static void callFromStatic() {
        System.out.println("Вызов из другого статического метода:");
        printVars(); // Без указания класса
    }

    public void callFromNonStatic() {
        System.out.println("Вызов из нестатического метода:");
        printVars(); // Без указания класса
        // Или через экземпляр:
        this.printVars();
    }
}
