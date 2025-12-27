import java.io.*;

public class Main {

    public static void main(String[] args) {
        // Проверяем количество аргументов
        if (args.length != 3) {
            showHelp();
            return;
        }

        String command = args[0];      // Команда: encode или decode
        String inputFile = args[1];    // Входной файл
        String outputFile = args[2];   // Выходной файл

        try {
            if (command.equalsIgnoreCase("encode")) {
                System.out.println("Режим кодирования");
                HuffmanEncoder encoder = new HuffmanEncoder();
                encoder.encode(inputFile, outputFile);

            } else if (command.equalsIgnoreCase("decode")) {
                System.out.println("Режим декодирования");
                HuffmanDecoder decoder = new HuffmanDecoder();
                decoder.decode(inputFile, outputFile);

            } else {
                System.out.println("Неизвестная команда: " + command);
                showHelp();
            }

            System.out.println("Программа завершила работу.");

        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: файл не найден!");
            System.out.println("Проверьте правильность пути: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Неожиданная ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Вывод справки по использованию программы
    private static void showHelp() {
        System.out.println("Программа для кодирования и декодирования методом Хаффмана");
        System.out.println();
        System.out.println("Использование:");
        System.out.println("  java Main encode <входной_файл> <выходной_файл>");
        System.out.println("  java Main decode <входной_файл> <выходной_файл>");
        System.out.println();
        System.out.println("Примеры:");
        System.out.println("  java Main encode текст.txt закодировано.bin");
        System.out.println("  java Main decode закодировано.bin результат.txt");
        System.out.println();
        System.out.println("Примечание: программа работает с любыми типами файлов.");
    }
}
