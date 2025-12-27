import java.util.*;

// Класс для построения дерева Хаффмана и получения кодов
public class HuffmanTree {

    private HuffmanNode root;          // Корень дерева
    private Map<Byte, String> codes;   // Таблица кодов Хаффмана

    // Основной метод - строит дерево по частотам символов
    public void buildTree(Map<Byte, Integer> frequencies) {

        // Создаем приоритетную очередь для хранения узлов
        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>();

        // Для каждого символа создаем отдельный узел-лист
        for (Map.Entry<Byte, Integer> entry : frequencies.entrySet()) {
            queue.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        // Если в файле всего один символ - нужна особая обработка
        if (queue.size() == 1) {
            HuffmanNode singleNode = queue.poll();
            // Создаем искусственный корень с одним потомком
            root = new HuffmanNode(singleNode.frequency, singleNode, null);
        } else {
            // Стандартный алгоритм Хаффмана
            while (queue.size() > 1) {
                // Берем два узла с наименьшими частотами
                HuffmanNode left = queue.poll();
                HuffmanNode right = queue.poll();

                // Создаем родительский узел
                HuffmanNode parent = new HuffmanNode(
                        left.frequency + right.frequency,
                        left, right
                );

                // Возвращаем родительский узел в очередь
                queue.add(parent);
            }
            // Последний узел в очереди - корень дерева
            root = queue.poll();
        }

        // Генерируем коды для всех символов
        codes = new HashMap<>();
        generateCodes(root, "");
    }

    // Рекурсивный метод для обхода дерева и генерации кодов
    private void generateCodes(HuffmanNode node, String currentCode) {
        if (node == null) {
            return;
        }

        // Если дошли до листа - сохраняем код
        if (node.isLeaf()) {
            // Если код пустой (бывает при одном символе), используем "0"
            codes.put(node.symbol, currentCode.isEmpty() ? "0" : currentCode);
            return;
        }

        // Рекурсивно обходим левое и правое поддерево
        generateCodes(node.left, currentCode + "0");
        generateCodes(node.right, currentCode + "1");
    }

    // Геттеры для доступа к корню и кодам
    public HuffmanNode getRoot() {
        return root;
    }

    public Map<Byte, String> getCodes() {
        return codes;
    }
}
