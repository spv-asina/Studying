public class Main {
    public static void main(String[] args) {
        System.out.println("Практика #1");

        // 1. Бесконечный цикл while
        System.out.println("1. Бесконечный while:");
        while (true) {
            System.out.println("Бесконечный цикл");
            break; // без этого будет бесконечно
        }

        // 2. Бесконечный цикл do-while
        System.out.println("\n2. Бесконечный do-while:");
        do {
            System.out.println("Выполнится хотя бы раз");
            break;
        } while (true);

        System.out.println("\nПрактика #2");

        // 3. Пример break
        System.out.println("Пример break:");
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                break;
            }
            System.out.println(i);
        }

        // 4. Пример continue
        System.out.println("\nПример continue:");
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                continue;
            }
            System.out.println(i);
        }
    }
}
