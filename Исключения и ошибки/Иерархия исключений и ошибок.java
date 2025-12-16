public class Main {
    public static void main(String[] args) {
        System.out.println("Практика #1");
        System.out.println("Throwable - базовый класс для всех исключений и ошибок");
        System.out.println("Exception - проверяемые исключения (нужно обрабатывать)");
        System.out.println("RuntimeException - непроверяемые исключения");
        System.out.println("Error - критические ошибки (OutOfMemoryError, StackOverflowError)");
        
        System.out.println("\nПрактика #2");
        
        // 1. ArithmeticException
        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: деление на ноль");
        }
        
        // 2. ArrayIndexOutOfBoundsException
        try {
            int[] arr = {1, 2, 3};
            int y = arr[5];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException: выход за границы массива");
        }
        
        // 3. IllegalArgumentException
        try {
            throw new IllegalArgumentException("Недопустимый аргумент");
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }
        
        // 4. ClassCastException
        try {
            Object obj = "строка";
            Integer num = (Integer) obj;
        } catch (ClassCastException e) {
            System.out.println("ClassCastException: неверное приведение типов");
        }
        
        // 5. NullPointerException
        try {
            String s = null;
            int len = s.length();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: обращение к null объекту");
        }
    }
}
