public class Main {
    static void m1() {
        // Исключение будет обработано
        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Перехвачено в m1: " + e);
        }
    }

    static void m2() {
        // Исключение не будет обработано
        int[] arr = new int[3];
        arr[5] = 10; // ArrayIndexOutOfBoundsException
    }

    static void m3() {
        System.out.println("Начало m3");
        m2(); // Вызов метода с неперехваченным исключением
        System.out.println("Конец m3"); // Не выполнится
    }

    public static void main(String[] args) {
        System.out.println("Практика #1");

        // Обработанное исключение
        System.out.println("\n1. Обработанное исключение:");
        m1();
        System.out.println("Программа продолжает работу");

        // Необработанное исключение
        System.out.println("\n2. Необработанное исключение:");
        try {
            m3();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Перехвачено в main: " + e);
        }

        System.out.println("\n3. Исключение без перехвата:");
        // Если убрать try-catch в main, программа завершится с ошибкой
        m2(); // Вызовет аварийную остановку
        System.out.println("Этот текст не будет выведен");
    }
}
