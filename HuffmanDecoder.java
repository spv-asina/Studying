import java.io.*;
import java.util.*;

// Класс для декодирования файлов, закодированных алгоритмом Хаффмана
public class HuffmanDecoder {

    // Основной метод декодирования
    public void decode(String inputFile, String outputFile) throws IOException {
        System.out.println("Декодируем файл: " + inputFile);

        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(new FileInputStream(inputFile)))) {

            // 1. Читаем количество уникальных символов
            int symbolCount = dis.readInt();
            System.out.println("Уникальных символов в файле: " + symbolCount);

            // 2. Восстанавливаем таблицу частот
            Map<Byte, Integer> frequencies = new HashMap<>();
            for (int i = 0; i < symbolCount; i++) {
                byte symbol = dis.readByte();
                int frequency = dis.readInt();
                frequencies.put(symbol, frequency);
            }

            // 3. Строим дерево Хаффмана
            HuffmanTree tree = new HuffmanTree();
            tree.buildTree(frequencies);

            // 4. Читаем длину битовой строки
            int bitLength = dis.readInt();
            System.out.println("Длина закодированных данных: " + bitLength + " бит");

            // 5. Читаем закодированные данные
            byte[] encodedBytes = new byte[dis.available()];
            dis.readFully(encodedBytes);

            // 6. Преобразуем байты в битовую строку
            String bitString = bytesToBitString(encodedBytes, bitLength);

            // 7. Декодируем данные
            byte[] decodedData = decodeUsingTree(bitString, tree.getRoot(), bitLength);

            // 8. Записываем результат
            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                fos.write(decodedData);
            }

            System.out.println("Результат сохранен в: " + outputFile);
            System.out.println("Размер восстановленного файла: " + decodedData.length + " байт");
            System.out.println("Декодирование завершено!");
        }
    }

    // Преобразование массива байтов в битовую строку
    private String bytesToBitString(byte[] bytes, int bitLength) {
        StringBuilder bitString = new StringBuilder();

        for (int i = 0; i < bytes.length; i++) {
            // Преобразуем байт в строку из 8 бит
            String bits = String.format("%8s",
                    Integer.toBinaryString(bytes[i] & 0xFF)).replace(' ', '0');

            // Для последнего байта учитываем, что он может быть неполным
            if (i == bytes.length - 1) {
                int bitsInLastByte = bitLength - (bytes.length - 1) * 8;
                if (bitsInLastByte > 0 && bitsInLastByte < 8) {
                    bits = bits.substring(0, bitsInLastByte);
                }
            }

            bitString.append(bits);
        }

        return bitString.toString();
    }

    // Декодирование битовой строки с помощью дерева Хаффмана
    private byte[] decodeUsingTree(String bitString, HuffmanNode root, int bitLength) {
        List<Byte> result = new ArrayList<>();
        HuffmanNode currentNode = root;

        // Если в дереве только один символ - особый случай
        if (root.isLeaf()) {
            for (int i = 0; i < bitLength; i++) {
                result.add(root.symbol);
            }
        } else {
            // Стандартное декодирование
            for (int i = 0; i < bitLength; i++) {
                char bit = bitString.charAt(i);

                if (bit == '0') {
                    currentNode = currentNode.left;
                } else {
                    currentNode = currentNode.right;
                }

                if (currentNode.isLeaf()) {
                    result.add(currentNode.symbol);
                    currentNode = root; // Возвращаемся к корню
                }
            }
        }

        // Преобразуем список в массив
        byte[] decoded = new byte[result.size()];
        for (int i = 0; i < result.size(); i++) {
            decoded[i] = result.get(i);
        }

        return decoded;
    }
}
