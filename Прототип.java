import java.util.*;

// 1. Интерфейс Прототипа
interface Shape extends Cloneable {
    Shape clone();
    void setX(int x);
    void setY(int y);
    void setColor(String color);
    String toString();
}

// 2. Конкретный прототип - Circle
class Circle implements Shape {
    private int x;
    private int y;
    private String color;
    private int radius;
    
    public Circle(int x, int y, String color, int radius) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.radius = radius;
        System.out.println("  Создание нового Circle с нуля... (это 'дорого')");
    }
    
    // Приватный конструктор для клонирования
    private Circle(Circle source) {
        this.x = source.x;
        this.y = source.y;
        this.color = source.color;
        this.radius = source.radius;
    }
    
    @Override
    public Shape clone() {
        System.out.println("  Клонирование Circle... (это 'дешево')");
        return new Circle(this); // Используем конструктор копирования
    }
    
    @Override
    public void setX(int x) { this.x = x; }
    
    @Override
    public void setY(int y) { this.y = y; }
    
    @Override
    public void setColor(String color) { this.color = color; }
    
    public void setRadius(int radius) { this.radius = radius; }
    
    @Override
    public String toString() {
        return "Circle(x=" + x + ", y=" + y + ", color='" + color + "', radius=" + radius + ")";
    }
}

// 3. Другой конкретный прототип - Rectangle
class Rectangle implements Shape {
    private int x;
    private int y;
    private String color;
    private int width;
    private int height;
    
    public Rectangle(int x, int y, String color, int width, int height) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.width = width;
        this.height = height;
        System.out.println("  Создание нового Rectangle с нуля...");
    }
    
    // Приватный конструктор для клонирования
    private Rectangle(Rectangle source) {
        this.x = source.x;
        this.y = source.y;
        this.color = source.color;
        this.width = source.width;
        this.height = source.height;
    }
    
    @Override
    public Shape clone() {
        System.out.println("  Клонирование Rectangle...");
        return new Rectangle(this);
    }
    
    @Override
    public void setX(int x) { this.x = x; }
    
    @Override
    public void setY(int y) { this.y = y; }
    
    @Override
    public void setColor(String color) { this.color = color; }
    
    public void setWidth(int width) { this.width = width; }
    
    public void setHeight(int height) { this.height = height; }
    
    @Override
    public String toString() {
        return "Rectangle(x=" + x + ", y=" + y + ", color='" + color + 
               "', width=" + width + ", height=" + height + ")";
    }
}

// 4. Реестр прототипов
class ShapeRegistry {
    private Map<String, Shape> prototypes = new HashMap<>();
    
    public void addPrototype(String key, Shape prototype) {
        prototypes.put(key, prototype);
    }
    
    public Shape getClone(String key) {
        Shape prototype = prototypes.get(key);
        if (prototype != null) {
            return prototype.clone();
        }
        throw new IllegalArgumentException("Прототип '" + key + "' не найден");
    }
}

// 5. Демонстрация использования
public class PrototypeExample {
    public static void main(String[] args) {
        System.out.println("Пример работы Прототипа\n");
        
        System.out.println("1. Создание оригинальных объектов (медленно):");
        Circle originalCircle = new Circle(10, 20, "красный", 15);
        Rectangle originalRect = new Rectangle(5, 5, "синий", 10, 20);
        
        System.out.println("\n2. Клонирование объектов (быстро):");
        Circle cloneCircle = (Circle) originalCircle.clone();
        Rectangle cloneRect = (Rectangle) originalRect.clone();
        
        System.out.println("\n3. Изменяем только клоны:");
        cloneCircle.setX(100);
        cloneCircle.setColor("зеленый");
        cloneCircle.setRadius(25);
        
        cloneRect.setWidth(50);
        cloneRect.setColor("желтый");
        
        System.out.println("\n4. Результат (оригиналы не изменились):");
        System.out.println("Оригинал круга: " + originalCircle);
        System.out.println("Клон круга:     " + cloneCircle);
        System.out.println("\nОригинал прямоугольника: " + originalRect);
        System.out.println("Клон прямоугольника:     " + cloneRect);
        
        // Пример использования реестра прототипов
        System.out.println("\n5. Использование реестра прототипов:");
        
        ShapeRegistry registry = new ShapeRegistry();
        registry.addPrototype("small_red_circle", new Circle(0, 0, "red", 5));
        registry.addPrototype("large_blue_circle", new Circle(0, 0, "blue", 50));
        registry.addPrototype("standard_rect", new Rectangle(0, 0, "black", 10, 20));
        
        Circle circle1 = (Circle) registry.getClone("small_red_circle");
        circle1.setX(30);
        circle1.setY(40);
        
        Circle circle2 = (Circle) registry.getClone("large_blue_circle");
        circle2.setX(100);
        circle2.setY(200);
        
        System.out.println("\nСозданы объекты из реестра:");
        System.out.println(" - " + circle1);
        System.out.println(" - " + circle2);
    }
}
