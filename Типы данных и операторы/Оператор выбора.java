public class Main {
    public static void main(String[] args) {
        System.out.println("Практика #1");

        // 1. Целочисленные типы: byte, short, int
        System.out.println("\n1. Целочисленные типы:");
        int intValue = 1;
        switch(intValue) {
            case 1:
                System.out.println("int: значение 1");
                break;
            case 2:
                System.out.println("int: значение 2");
                break;
        }

        byte byteValue = 10;
        switch(byteValue) {
            case 10:
                System.out.println("byte: значение 10");
                break;
            case 20:
                System.out.println("byte: значение 20");
                break;
        }

        short shortValue = 100;
        switch(shortValue) {
            case 100:
                System.out.println("short: значение 100");
                break;
            case 200:
                System.out.println("short: значение 200");
                break;
        }

        // 2. char
        System.out.println("\n2. Тип char:");
        char charValue = 'A';
        switch(charValue) {
            case 'A':
                System.out.println("char: значение 'A'");
                break;
            case 'B':
                System.out.println("char: значение 'B'");
                break;
        }

        System.out.println("\n3. Тип String:");
        String stringValue = "Hello";
        switch(stringValue) {
            case "Hello":
                System.out.println("String: значение 'Hello'");
                break;
            case "World":
                System.out.println("String: значение 'World'");
                break;
        }

        // 4. Enum (перечисления)
        System.out.println("\n4. Тип Enum:");
        enum Day {MONDAY, TUESDAY, WEDNESDAY}
        Day day = Day.MONDAY;
        switch(day) {
            case MONDAY:
                System.out.println("Enum: понедельник");
                break;
            case TUESDAY:
                System.out.println("Enum: вторник");
                break;
        }

        System.out.println("\n5. Классы-оболочки:");
        Integer integerValue = 1;
        switch(integerValue) {
            case 1:
                System.out.println("Integer: значение 1");
                break;
            case 2:
                System.out.println("Integer: значение 2");
                break;
        }

        Character characterValue = 'A';
        switch(characterValue) {
            case 'A':
                System.out.println("Character: значение 'A'");
                break;
            case 'B':
                System.out.println("Character: значение 'B'");
                break;
        }

        System.out.println("\nПрактика #2");
        System.out.println("Отсутствие break в switch:");

        int value = 2;
        int i = 0;

        System.out.println("При value = 2:");
        System.out.println("Код без break в case 2:");
        System.out.println("switch(value) {");
        System.out.println("    case 1:");
        System.out.println("        i = 1;");
        System.out.println("        break;");
        System.out.println("    case 2:");
        System.out.println("        i = 2;  // нет break!");
        System.out.println("    case 3:");
        System.out.println("        i = 3;");
        System.out.println("        break;");
        System.out.println("}");

        // Демонстрация
        value = 2;
        i = 0;
        switch(value) {
            case 1:
                i = 1;
                break;
            case 2:
                i = 2;  // нет break
            case 3:
                i = 3;  // этот код тоже выполнится
                break;
        }
        System.out.println("Результат: i = " + i);

        System.out.println("\nПри value = 1:");
        value = 1;
        switch(value) {
            case 1:
                System.out.println("case 1");
            case 2:
                System.out.println("case 2");
            case 3:
                System.out.println("case 3");
                break;
            case 4:
                System.out.println("case 4");
        }

        System.out.println("\nПри value = 2:");
        value = 2;
        switch(value) {
            case 1:
                System.out.println("case 1");
            case 2:
                System.out.println("case 2");
            case 3:
                System.out.println("case 3");
                break;
            case 4:
                System.out.println("case 4");
        }

        System.out.println("\nВывод:");
        System.out.println("При отсутствии break выполнение продолжается");
        System.out.println("со следующего case (или default) до первого break");
        System.out.println("или до конца switch.");
    }
}
