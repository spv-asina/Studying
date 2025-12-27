import java.io.*;
import java.util.*;

// Класс для кодирования файлов алгоритмом Хаффмана
public class HuffmanEncoder {

    private HuffmanTree tree;
    private Map<Byte, String> huffmanCodes;

    // Основной метод кодирования
    public void encode(String inputFile, String outputFile) throws IOException {
        System.out.println("Кодируем файл: " + inputFile);

        // 1. Читаем исходный файл
        byte[] data = readAllBytes(inputFile);
        System.out.println("Размер исходного файла: " + data.length + " байт");

        // 2. Подсчитываем частоты символов
        Map<Byte, Integer> frequencies = countFrequencies(data);
        System.out.println("Найдено уникальных символов: " + frequencies.size());

        // 3. Строим дерево Хаффмана
        tree = new HuffmanTree();
        tree.buildTree(frequencies);
        huffmanCodes = tree.getCodes();

        // 4. Кодируем данные
        String bitString = encodeToBits(data);

        // 5. Записываем результат в файл
        writeEncodedFile(outputFile, frequencies, bitString);

        System.out.println("Результат сохранен в: " + outputFile);
        System.out.println("Кодирование завершено!");
    }

    // Чтение файла целиком
    private byte[] readAllBytes(String filename) throws IOException {
        try (FileInputStream fis = new FileInputStream(filename)) {
            byte[] buffer = new byte[(int) new File(filename).length()];
            fis.read(buffer);
            return buffer;
        }
    }

    // Подсчет частоты каждого символа
    private Map<Byte, Integer> countFrequencies(byte[] data) {
        Map<Byte, Integer> frequencies = new HashMap<>();

        for (byte b : data) {
            frequencies.put(b, frequencies.getOrDefault(b, 0) + 1);
        }

        return frequencies;
    }

    // Преобразование данных в битовую строку по кодам Хаффмана
    private String encodeToBits(byte[] data) {
        StringBuilder bitString = new StringBuilder();

        for (byte b : data) {
            String code = huffmanCodes.get(b);
            if (code == null) {
                throw new RuntimeException("Ошибка: нет кода для символа " + b);
            }
            bitString.append(code);
        }

        System.out.println("Длина битовой строки: " + bitString.length() + " бит");
        return bitString.toString();
    }

    // Запись закодированного файла
    private void writeEncodedFile(String filename,
                                  Map<Byte, Integer> frequencies,
                                  String bitString) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(filename)))) {

            // Записываем заголовок: количество символов
            dos.writeInt(frequencies.size());

            // Записываем таблицу частот
            for (Map.Entry<Byte, Integer> entry : frequencies.entrySet()) {
                dos.writeByte(entry.getKey());
                dos.writeInt(entry.getValue());
            }

            // Записываем длину битовой строки
            dos.writeInt(bitString.length());

            // Преобразуем битовую строку в байты и записываем
            int bitLength = bitString.length();
            for (int i = 0; i < bitLength; i += 8) {
                String byteStr;
                if (i + 8 <= bitLength) {
                    byteStr = bitString.substring(i, i + 8);
                } else {
                    // Последний байт может быть неполным
                    byteStr = bitString.substring(i);
                    while (byteStr.length() < 8) {
                        byteStr += "0"; // Дополняем нулями
                    }
                }

                int byteValue = Integer.parseInt(byteStr, 2);
                dos.writeByte(byteValue);
            }
        }
    }
}
