// Базовый класс
class Shape {
    public double getArea() {
        return 0;
    }
}

// Подклассы
class Rectangle extends Shape {
    private double width;
    private double height;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double getArea() {
        return width * height;
    }
}

class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

// Использование
public class AreaCalculator {
    public static void printArea(Shape shape) {
        System.out.println("Площадь: " + shape.getArea());
    }
    
    public static void main(String[] args) {
        printArea(new Rectangle(5, 3)); // 15.0
        printArea(new Circle(2));       // 12.56
        printArea(new Shape());         // 0.0
    }
}
