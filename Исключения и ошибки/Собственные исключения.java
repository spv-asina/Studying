// Собственное исключение
class MyException extends Exception {
    // Конструктор по умолчанию
    public MyException() {
        super("Мое исключение");
    }
    
    // Конструктор с сообщением
    public MyException(String message) {
        super(message);
    }
    
    // Конструктор с причиной
    public MyException(Throwable cause) {
        super(cause);
    }
    
    // Конструктор с сообщением и причиной
    public MyException(String message, Throwable cause) {
        super(message, cause);
    }
}

// Другое собственное исключение
class AgeException extends Exception {
    private int age;
    
    public AgeException(String message, int age) {
        super(message);
        this.age = age;
    }
    
    public int getAge() {
        return age;
    }
}

public class Main {
    static void checkAge(int age) throws AgeException {
        if (age < 0 || age > 150) {
            throw new AgeException("Недопустимый возраст", age);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Практика #1");
        
        try {
            throw new MyException("Ошибка в программе");
        } catch (MyException e) {
            System.out.println("Поймано: " + e.getMessage());
        }
        
        try {
            checkAge(200);
        } catch (AgeException e) {
            System.out.println("Ошибка возраста: " + e.getMessage() + ", возраст: " + e.getAge());
        }
    }
}
