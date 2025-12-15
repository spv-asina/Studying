public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();

        System.out.println("1. print() без параметров:");
        printer.print();

        System.out.println("\n2. print(int... numbers):");
        printer.print(1, 2, 3, 4);

        System.out.println("\n3. print(String... strings):");
        printer.print("Hello", "World", "Java");

        System.out.println("\n4. print(String prefix, int... numbers):");
        printer.print("Numbers:", 1, 2, 3);

        System.out.println("\n5. print(int x, String... messages):");
        printer.print(5, "Message 1", "Message 2");
    }
}

class Printer {
    // 1. Без параметров
    public void print() {
        System.out.println("Без параметров");
    }

    // 2. С переменным числом int параметров
    public void print(int... numbers) {
        System.out.print("int...: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // 3. С переменным числом String параметров
    public void print(String... strings) {
        System.out.print("String...: ");
        for (String str : strings) {
            System.out.print(str + " ");
        }
        System.out.println();
    }

    // 4. С обязательным первым String параметром и переменными int
    public void print(String prefix, int... numbers) {
        System.out.print(prefix + " ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // 5. С обязательным первым int параметром и переменными String
    public void print(int x, String... messages) {
        System.out.print("x=" + x + ", messages: ");
        for (String msg : messages) {
            System.out.print(msg + " ");
        }
        System.out.println();
    }
}
