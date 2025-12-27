// Класс для хранения узлов дерева Хаффмана
public class HuffmanNode implements Comparable<HuffmanNode> {

    // Символ и его частота
    byte symbol;
    int frequency;

    // Ссылки на левого и правого потомков
    HuffmanNode left;
    HuffmanNode right;

    // Конструктор для создания листа (конечного узла)
    HuffmanNode(byte symbol, int frequency) {
        this.symbol = symbol;
        this.frequency = frequency;
        left = null;
        right = null;
    }

    // Конструктор для создания внутреннего узла
    HuffmanNode(int frequency, HuffmanNode left, HuffmanNode right) {
        this.symbol = 0;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    // Проверка, является ли узел листом
    boolean isLeaf() {
        return left == null && right == null;
    }

    // Метод для сравнения узлов по частоте (нужен для сортировки)
    @Override
    public int compareTo(HuffmanNode other) {
        return Integer.compare(this.frequency, other.frequency);
    }
}
