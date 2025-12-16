class Ex1 extends Exception {
    public Ex1(String msg) { super(msg); }
}

class Ex2 extends Ex1 {
    public Ex2(String msg) { super(msg); }
}

class Ex3 extends Ex2 {
    public Ex3(String msg) { super(msg); }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Практика #1");

        // 1. Несколько исключений обрабатываются одинаково
        try {
            int choice = 1;
            if (choice == 1) {
                int x = 10 / 0; // ArithmeticException
            } else {
                int[] arr = new int[3];
                arr[5] = 10; // ArrayIndexOutOfBoundsException
            }
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Одинаковая обработка: " + e.getClass().getSimpleName());
        }

        // 2. Исключения в иерархии
        System.out.println("\nИерархия исключений:");
        try {
            throw new Ex3("Ex3 исключение");
        } catch (Ex3 e) {
            System.out.println("Пойман Ex3: " + e.getMessage());
        } catch (Ex2 e) {
            System.out.println("Пойман Ex2: " + e.getMessage());
        } catch (Ex1 e) {
            System.out.println("Пойман Ex1: " + e.getMessage());
        }

        // Порядок важен - от конкретного к общему
        System.out.println("\nИзмененный порядок:");
        try {
            throw new Ex2("Ex2 исключение");
        } catch (Ex1 e) { // Поймает все: Ex1, Ex2, Ex3
            System.out.println("Пойман Ex1 (или его подкласс): " + e.getMessage());
        }

        System.out.println("\nПрактика #2");
        try {
            String s = null;
            s.length();
        } catch (final Exception e) {
            System.out.println("final Exception e - переменная e не может быть изменена");
            // e = new Exception(); // Ошибка: нельзя изменить final переменную
        }

        System.out.println("\nВложенные try:");
        try {
            try {
                int x = 10 / 0;
            } catch (ArithmeticException e) {
                System.out.println("Внутренний catch: " + e);
                throw e; // Пробрасываем дальше
            }
        } catch (ArithmeticException e) {
            System.out.println("Внешний catch: " + e);
        }
    }
}
