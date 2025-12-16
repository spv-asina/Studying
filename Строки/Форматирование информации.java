import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("Практика #1");
        System.out.printf("%%d: %d%n", 123);
        System.out.printf("%%f: %.2f%n", 123.456);
        System.out.printf("%%s: %s%n", "Hello");
        System.out.printf("%%b: %b%n", true);
        System.out.printf("%%c: %c%n", 'A');

        System.out.println("\nПрактика #2");
        System.out.println("flush() записывает данные из буфера");

        System.out.println("\nПрактика #3");
        Date d = new Date();
        System.out.printf("Год: %tY%n", d);
        System.out.printf("Месяц: %tB%n", d);
        System.out.printf("День месяца: %td%n", d);
        System.out.printf("Время: %tH:%tM%n", d, d);
        System.out.printf("День недели: %tA%n", d);
    }
}
