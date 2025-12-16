import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Практика #1");

        try {
            File file = new File("test.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }

        // Пример чтения разных типов данных
        System.out.println("\nЧтение разных типов:");
        String data = "10 20,5 true Hello";
        Scanner sc2 = new Scanner(data);

        // Устанавливаем локаль для десятичных разделителей
        sc2.useLocale(java.util.Locale.US);

        int a = sc2.nextInt();
        double b = sc2.nextDouble();
        boolean c = sc2.nextBoolean();
        String d = sc2.next();

        System.out.println("int: " + a);
        System.out.println("double: " + b);
        System.out.println("boolean: " + c);
        System.out.println("String: " + d);

        sc2.close();
    }
}
