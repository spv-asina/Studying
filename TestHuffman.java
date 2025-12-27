import java.io.*;

// Класс для тестирования программы Хаффмана
public class TestHuffman {

    public static void main(String[] args) throws IOException {
        System.out.println("Разработал Шилов Павел Васильевич");
        System.out.println("из группы 5030102/30202");

        runFirstTest();
        runSecondTest();
        runThirdTest();

        System.out.println();
    }

    // Тест 1: 10 одинаковых символов
    private static void runFirstTest() throws IOException {
        System.out.println("Тест №1: 10 одинаковых символов");

        // Создаем тестовый файл
        try (FileWriter writer = new FileWriter("test_1_original.txt")) {
            writer.write("1111111111");
        }

        // Кодируем
        System.out.println("Шаг 1: Кодирование файла...");
        Main.main(new String[]{"encode", "test_1_original.txt", "test_1_encoded.bin"});

        // Декодируем
        System.out.println("\nШаг 2: Декодирование файла...");
        Main.main(new String[]{"decode", "test_1_encoded.bin", "test_1_decoded.txt"});

        // Проверяем
        boolean success = compareFiles("test_1_original.txt", "test_1_decoded.txt");
        System.out.println("\nРезультат теста №1: " + (success ? "Успех" : "Провал"));
        System.out.println();

        // Удаляем временные файлы
        new File("test_1_original.txt").delete();
        new File("test_1_encoded.bin").delete();
        new File("test_1_decoded.txt").delete();
    }

    // Тест 2: 20 символов с разными частотами
    private static void runSecondTest() throws IOException {
        System.out.println("Тест №2: 20 символов с частотами 10, 5, 5");

        // Создаем тестовый файл
        try (FileWriter writer = new FileWriter("test_2_original.txt")) {
            writer.write("11111111112222233333");
        }

        // Кодируем
        System.out.println("Шаг 1: Кодирование файла...");
        Main.main(new String[]{"encode", "test_2_original.txt", "test_2_encoded.bin"});

        // Декодируем
        System.out.println("\nШаг 2: Декодирование файла...");
        Main.main(new String[]{"decode", "test_2_encoded.bin", "test_2_decoded.txt"});

        // Проверяем
        boolean success = compareFiles("test_2_original.txt", "test_2_decoded.txt");
        System.out.println("\nРезультат теста №2: " + (success ? "Успех" : "Провал"));
        System.out.println();

        // Удаляем временные файлы
        new File("test_2_original.txt").delete();
        new File("test_2_encoded.bin").delete();
        new File("test_2_decoded.txt").delete();
    }

    // Тест 3: Бинарный файл
    private static void runThirdTest() throws IOException {
        System.out.println("Тест №3: Бинарный файл (256 байт случайных данных)");

        // Создаем бинарный файл со случайными данными
        try (FileOutputStream fos = new FileOutputStream("test_3_original.bin")) {
            for (int i = 0; i < 256; i++) {
                fos.write((int)(Math.random() * 256));
            }
        }

        // Кодируем
        System.out.println("Шаг 1: Кодирование файла...");
        Main.main(new String[]{"encode", "test_3_original.bin", "test_3_encoded.bin"});

        // Декодируем
        System.out.println("\nШаг 2: Декодирование файла...");
        Main.main(new String[]{"decode", "test_3_encoded.bin", "test_3_decoded.bin"});

        // Проверяем
        boolean success = compareFiles("test_3_original.bin", "test_3_decoded.bin");
        System.out.println("\nРезультат теста №3: " + (success ? "Успех" : "Провал"));
        System.out.println();

        new File("test_3_original.bin").delete();
        new File("test_3_encoded.bin").delete();
        new File("test_3_decoded.bin").delete();
    }

    // Метод для сравнения двух файлов
    private static boolean compareFiles(String file1, String file2) throws IOException {
        File f1 = new File(file1);
        File f2 = new File(file2);

        // Сначала проверяем размеры
        if (f1.length() != f2.length()) {
            System.out.println("  Размеры файлов не совпадают!");
            return false;
        }

        // Затем сравниваем содержимое побайтово
        try (FileInputStream fis1 = new FileInputStream(f1);
             FileInputStream fis2 = new FileInputStream(f2)) {

            int byte1, byte2;
            long position = 0;

            while ((byte1 = fis1.read()) != -1) {
                byte2 = fis2.read();
                position++;

                if (byte1 != byte2) {
                    System.out.println("  Файлы отличаются в позиции " + position);
                    return false;
                }
            }
        }

        return true;
    }
}
