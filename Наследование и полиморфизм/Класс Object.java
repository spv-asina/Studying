class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Point other = (Point) obj;

        return this.x == other.x && this.y == other.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Практика #1");

        Point p1 = new Point(3, 4);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(5, 6);

        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
        System.out.println("p3: " + p3);

        System.out.println("\nСравнение:");
        System.out.println("p1.equals(p2): " + p1.equals(p2)); // true
        System.out.println("p2.equals(p1): " + p2.equals(p1)); // true (симметричность)
        System.out.println("p1.equals(p3): " + p1.equals(p3)); // false
        System.out.println("p1.equals(null): " + p1.equals(null)); // false
        System.out.println("p1.equals(p1): " + p1.equals(p1)); // true (рефлексивность)

        // Проверка транзитивности
        Point p4 = new Point(3, 4);
        System.out.println("p1.equals(p2) && p2.equals(p4) && p1.equals(p4): " +
                (p1.equals(p2) && p2.equals(p4) && p1.equals(p4))); // true

        // Хэш-коды
        System.out.println("\nХэш-коды:");
        System.out.println("p1.hashCode(): " + p1.hashCode());
        System.out.println("p2.hashCode(): " + p2.hashCode());
        System.out.println("p3.hashCode(): " + p3.hashCode());
        System.out.println("У равных объектов одинаковые хэш-коды: " +
                (p1.hashCode() == p2.hashCode()));
    }
}
