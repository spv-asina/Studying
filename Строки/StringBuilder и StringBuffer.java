public class Main {
    public static void main(String[] args) {
        System.out.println("Практика #1");

        // StringBuilder (не потокобезопасный)
        StringBuilder sb1 = new StringBuilder("Java");
        System.out.println("StringBuilder:");

        // 1. append() - добавление в конец
        sb1.append(" Programming");
        System.out.println("1. append(): " + sb1);

        // 2. insert() - вставка по индексу
        sb1.insert(5, "Cool ");
        System.out.println("2. insert(): " + sb1);

        // 3. delete() - удаление части
        sb1.delete(5, 10);
        System.out.println("3. delete(): " + sb1);

        // 4. reverse() - реверс строки
        sb1.reverse();
        System.out.println("4. reverse(): " + sb1);
        sb1.reverse(); // вернем обратно

        // 5. replace() - замена части
        sb1.replace(0, 4, "Python");
        System.out.println("5. replace(): " + sb1);

        // 6. charAt() - символ по индексу
        System.out.println("6. charAt(3): " + sb1.charAt(3));

        // 7. length() - длина
        System.out.println("7. length(): " + sb1.length());

        // 8. capacity() - вместимость
        System.out.println("8. capacity(): " + sb1.capacity());

        // 9. setLength() - установка длины
        sb1.setLength(10);
        System.out.println("9. setLength(10): " + sb1);

        // 10. toString() - преобразование в String
        String s1 = sb1.toString();
        System.out.println("10. toString(): " + s1);

        // StringBuffer (потокобезопасный)
        System.out.println("\nStringBuffer:");
        StringBuffer sb2 = new StringBuffer("Hello");

        // Методы те же самые
        sb2.append(" World");
        sb2.insert(5, ",");
        System.out.println("StringBuffer результат: " + sb2);

        System.out.println("\nПрактика #2");

        String s = "Java";

        // String -> StringBuilder
        StringBuilder sbFromString1 = new StringBuilder(s);
        System.out.println("String -> StringBuilder: " + sbFromString1);

        // String -> StringBuffer
        StringBuffer sbFromString2 = new StringBuffer(s);
        System.out.println("String -> StringBuffer: " + sbFromString2);

        // StringBuilder -> String
        String sFromSB1 = sbFromString1.toString();
        System.out.println("StringBuilder -> String: " + sFromSB1);

        // StringBuffer -> String
        String sFromSB2 = sbFromString2.toString();
        System.out.println("StringBuffer -> String: " + sFromSB2);

        // StringBuilder -> StringBuffer (через String)
        StringBuffer sb2FromSB1 = new StringBuffer(sbFromString1.toString());
        System.out.println("StringBuilder -> StringBuffer: " + sb2FromSB1);

        // StringBuffer -> StringBuilder
        StringBuilder sb1FromSB2 = new StringBuilder(sbFromString2.toString());
        System.out.println("StringBuffer -> StringBuilder: " + sb1FromSB2);
    }
}
