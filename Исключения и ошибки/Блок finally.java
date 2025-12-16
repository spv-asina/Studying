import java.io.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Практика #1");
        // try без catch и finally - НЕЛЬЗЯ
        // try {
        //     System.out.println("try без catch/finally");
        // }
        
        System.out.println("\nПрактика #2");
        // try только с finally - МОЖНО
        try {
            System.out.println("Код в try");
        } finally {
            System.out.println("finally выполнится всегда");
        }
        
        System.out.println("\nПрактика #3");
        // try с двумя finally - НЕЛЬЗЯ
        try {
            System.out.println("Еще один try");
        } finally {
            System.out.println("Только один finally");
        }
        // } finally { // Ошибка компиляции
        //     System.out.println("Второй finally");
        // }
        
        System.out.println("\nПример с ресурсами:");
        try (FileReader fr = new FileReader("test.txt")) {
            System.out.println("Чтение файла");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        } finally {
            System.out.println("finally выполняется всегда");
        }
    }
}
