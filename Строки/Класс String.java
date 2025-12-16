import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Практика #1");
        String s = "  Hello, Java World!  ";

        // 1. length() - длина строки
        System.out.println("1. length(): " + s.length());

        // 2. charAt() - символ по индексу
        System.out.println("2. charAt(7): " + s.charAt(7));

        // 3. substring() - подстрока
        System.out.println("3. substring(2, 7): " + s.substring(2, 7));

        // 4. trim() - удаление пробелов
        System.out.println("4. trim(): '" + s.trim() + "'");

        // 5. toLowerCase() - в нижний регистр
        System.out.println("5. toLowerCase(): " + s.toLowerCase());

        // 6. toUpperCase() - в верхний регистр
        System.out.println("6. toUpperCase(): " + s.toUpperCase());

        // 7. replace() - замена символов
        System.out.println("7. replace('a', 'A'): " + s.replace('a', 'A'));

        // 8. split() - разделение на массив
        String[] parts = s.trim().split(" ");
        System.out.println("8. split(): ");
        for (String p : parts) System.out.println("  " + p);

        // 9. indexOf() - поиск подстроки
        System.out.println("9. indexOf(\"Java\"): " + s.indexOf("Java"));

        // 10. startsWith() - начинается ли строка
        System.out.println("10. startsWith(\"Hello\"): " + s.startsWith("Hello"));

        System.out.println("\nПрактика #2");
        StringJoiner sj1 = new StringJoiner(", ");
        sj1.add("Java");
        sj1.add("Python");
        sj1.add("C++");
        System.out.println("StringJoiner с разделителем: " + sj1);

        StringJoiner sj2 = new StringJoiner(", ", "[", "]");
        sj2.add("A");
        sj2.add("B");
        sj2.add("C");
        System.out.println("StringJoiner с префиксом и суффиксом: " + sj2);

        System.out.println("\nПрактика #3");
        String text = """
            Многострочный
            текст
            без экранирования
            кавычек " и '
            """;
        System.out.println("Текст в тройных кавычках:");
        System.out.println(text);

        String sql = """
            SELECT * FROM users
            WHERE age > 18
            AND active = true
            """;
        System.out.println("SQL запрос:");
        System.out.println(sql);
    }
}
