public class Main {
    public static void main(String[] args) {
        System.out.println("Практика #1");
        System.out.println("Примеры использования метода decode():");

        // Десятичные числа
        Integer dec1 = Integer.decode("123");
        System.out.println("Integer.decode(\"123\") = " + dec1);

        // Восьмеричные числа (начинаются с 0)
        Integer oct1 = Integer.decode("0123");
        System.out.println("Integer.decode(\"0123\") = " + oct1);

        // Шестнадцатеричные числа (начинаются с 0x/0X)
        Integer hex1 = Integer.decode("0xFF");
        System.out.println("Integer.decode(\"0xFF\") = " + hex1);

        // Шестнадцатеричные числа (начинаются с #)
        Integer hex2 = Integer.decode("#FF");
        System.out.println("Integer.decode(\"#FF\") = " + hex2);

        // Отрицательные числа
        Integer neg1 = Integer.decode("-0xFF");
        System.out.println("Integer.decode(\"-0xFF\") = " + neg1);

        // Для других классов
        Long long1 = Long.decode("0xFFFFFFFF");
        System.out.println("Long.decode(\"0xFFFFFFFF\") = " + long1);

        System.out.println("\nПрактика #2");
        System.out.println("Способы создания экземпляра класса Boolean:");

        // 1. Конструктор (устарел)
        Boolean bool1 = new Boolean(true);
        Boolean bool2 = new Boolean("true");
        System.out.println("1. new Boolean(true) = " + bool1);
        System.out.println("   new Boolean(\"true\") = " + bool2);

        // 2. valueOf()
        Boolean bool3 = Boolean.valueOf(true);
        Boolean bool4 = Boolean.valueOf("true");
        System.out.println("2. Boolean.valueOf(true) = " + bool3);
        System.out.println("   Boolean.valueOf(\"true\") = " + bool4);

        // 3. Автоупаковка
        Boolean bool5 = true;
        Boolean bool6 = false;
        System.out.println("3. Boolean bool5 = true; -> " + bool5);
        System.out.println("   Boolean bool6 = false; -> " + bool6);

        // 4. parseBoolean()
        boolean bool7 = Boolean.parseBoolean("true");
        System.out.println("4. Boolean.parseBoolean(\"true\") = " + bool7);

        // 5. Статические константы
        Boolean bool8 = Boolean.TRUE;
        Boolean bool9 = Boolean.FALSE;
        System.out.println("5. Boolean.TRUE = " + bool8);
        System.out.println("   Boolean.FALSE = " + bool9);

        System.out.println("\nПрактика #3");
        System.out.println("NullPointerException при автоупаковке/автораспаковке:");

        // Пример с NullPointerException
        Integer nullableInteger = null;
        System.out.println("Integer nullableInteger = null;");

        try {
            int unboxed = nullableInteger; // Автораспаковка null
            System.out.println("int unboxed = nullableInteger; -> " + unboxed);
        } catch (NullPointerException e) {
            System.out.println("Ошибка: NullPointerException при автораспаковке null");
        }

        // Еще пример
        Integer nullInt = null;
        System.out.println("\nInteger nullInt = null;");
        try {
            int result = nullInt + 10; // Попытка использовать null в арифметике
            System.out.println("nullInt + 10 = " + result);
        } catch (NullPointerException e) {
            System.out.println("Ошибка: NullPointerException при использовании null в выражении");
        }

        System.out.println("\nПрактика #4");
        System.out.println("Результат выполнения кода:");

        int i1 = 128;
        Integer a1 = i1;
        Integer b1 = i1;
        System.out.println("a1==i1 " + (a1 == i1));
        System.out.println("b1==i1 " + (b1 == i1));
        System.out.println("a1==b1 " + (a1 == b1));
        System.out.println("a1.equals(i1) -> " + a1.equals(i1));
        System.out.println("b1.equals(i1) -> " + b1.equals(i1));
        System.out.println("a1.equals(b1) -> " + a1.equals(b1));

        int i2 = 127;
        Integer a2 = i2;
        Integer b2 = i2;
        System.out.println("\na2==i2 " + (a2 == i2));
        System.out.println("b2==i2 " + (b2 == i2));
        System.out.println("a2==b2 " + (a2 == b2));
        System.out.println("a2.equals(i2) -> " + a2.equals(i2));
        System.out.println("b2.equals(i2) -> " + b2.equals(i2));
        System.out.println("a2.equals(b2) -> " + a2.equals(b2));

        System.out.println("\nОбъяснение результата:");
        System.out.println("1. a1==i1 и b1==i1 дают true, потому что при сравнении Integer и int");
        System.out.println("   происходит автораспаковка Integer в int, и сравниваются значения.");
        System.out.println("2. a1==b1 для 128 дает false, потому что для значений вне диапазона");
        System.out.println("   -128..127 создаются новые объекты, и == сравнивает ссылки.");
        System.out.println("3. a2==b2 для 127 дает true, потому что IntegerCache кеширует объекты");
        System.out.println("   Integer в диапазоне -128..127, и a2 и b2 ссылаются на один объект.");
        System.out.println("4. Все equals() дают true, потому что equals сравнивает значения,");
        System.out.println("   а не ссылки.");

        System.out.println("\nКласс IntegerCache используется для кеширования объектов Integer");
        System.out.println("в диапазоне от -128 до 127. Это экономит память и улучшает");
        System.out.println("производительность, так как часто используемые значения не создаются");
        System.out.println("заново, а берутся из кеша.");

        System.out.println("\nДополнительный пример для понимания:");
        Integer x1 = 100;
        Integer x2 = 100;
        Integer y1 = 200;
        Integer y2 = 200;
        System.out.println("Integer x1 = 100, x2 = 100: x1 == x2 -> " + (x1 == x2));
        System.out.println("Integer y1 = 200, y2 = 200: y1 == y2 -> " + (y1 == y2));
        System.out.println("x1.equals(x2) -> " + x1.equals(x2));
        System.out.println("y1.equals(y2) -> " + y1.equals(y2));
    }
}
