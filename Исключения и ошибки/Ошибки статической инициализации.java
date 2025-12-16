public class main {
    final static int START_COUNTER;
    static {
        // Ошибка: "Y-" нельзя преобразовать в число
        START_COUNTER = Integer.parseInt("Y-"); // NumberFormatException
    }

    public static void main(String[] args) {
        System.out.println("Hello"); // Не выполнится
    }
}
