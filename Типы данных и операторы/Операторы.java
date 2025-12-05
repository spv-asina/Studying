public class Main {
    public static void main(String[] args) {
        System.out.println("Практика #1");

        // 1. Базовый оператор присваивания
        System.out.println("\n1. Оператор присваивания =");
        int x = 10; // создаем переменную x и присваиваем ей значение 10
        String text = "Hello"; // создаем строковую переменную
        System.out.println("x = " + x); // выводим значение x
        System.out.println("text = " + text); // выводим текст

        // 2. Составные операторы
        System.out.println("\n2. Составные операторы +=, -=, *=, /=, %=");
        int number = 10; // начальное значение

        number += 5; // эквивалентно: number = number + 5
        System.out.println("После += 5: " + number); // должно быть 15

        number -= 3; // эквивалентно: number = number - 3
        System.out.println("После -= 3: " + number); // должно быть 12

        number *= 2; // эквивалентно: number = number * 2
        System.out.println("После *= 2: " + number); // должно быть 24

        number /= 4; // эквивалентно: number = number / 4
        System.out.println("После /= 4: " + number); // должно быть 6

        number %= 4; // эквивалентно: number = number % 4
        System.out.println("После %= 4: " + number); // должно быть 2 (остаток от деления 6 на 4)

        // 3. Тернарный оператор
        System.out.println("\n3. Тернарный оператор ?:");
        int age = 18; // возраст
        String access = (age >= 18) ? "разрешено" : "запрещено"; // если возраст >= 18, то "разрешено", иначе "запрещено"
        System.out.println("Вам " + access + " покупать алкоголь");

        // 4. Логические операторы
        System.out.println("\n4. Логические операторы || и &&");
        boolean hasMoney = true; // есть деньги
        boolean shopOpen = false; // магазин открыт

        boolean canBuy = hasMoney || shopOpen; // ИЛИ: true если хотя бы одно true
        System.out.println("Можно купить (||): " + canBuy); // true

        boolean definitelyCanBuy = hasMoney && shopOpen; // И: true только если оба true
        System.out.println("Точно можно купить (&&): " + definitelyCanBuy); // false

        // 5. Побитовые операторы
        System.out.println("\n5. Побитовые операторы |, ^, &");
        int a = 5;    // двоичное представление: 0101
        int b = 3;    // двоичное представление: 0011

        int or = a | b;  // побитовое ИЛИ: 0101 | 0011 = 0111 (7)
        System.out.println("5 | 3 = " + or);

        int xor = a ^ b;  // побитовое исключающее ИЛИ: 0101 ^ 0011 = 0110 (6)
        System.out.println("5 ^ 3 = " + xor);

        int and = a & b;  // побитовое И: 0101 & 0011 = 0001 (1)
        System.out.println("5 & 3 = " + and);

        // 6. Операторы сравнения
        System.out.println("\n6. Операторы сравнения ==, !=");
        int num1 = 10;
        int num2 = 20;

        System.out.println("10 == 20: " + (num1 == num2)); // false
        System.out.println("10 != 20: " + (num1 != num2)); // true

        // 7. Операторы больше/меньше
        System.out.println("\n7. Больше/меньше >, >=, <, <=");
        System.out.println("10 > 20: " + (num1 > num2)); // false
        System.out.println("10 >= 10: " + (num1 >= 10)); // true
        System.out.println("10 < 20: " + (num1 < num2)); // true
        System.out.println("20 <= 20: " + (num2 <= 20)); // true

        // 8. Битовые сдвиги
        System.out.println("\n8. Битовые сдвиги >>, >>>, <<");
        int number2 = 8;  // двоичное: 00001000

        int leftShift = number2 << 1;  // сдвиг влево на 1 бит: 00010000 = 16
        System.out.println("8 << 1 = " + leftShift);

        int rightShift = number2 >> 1;  // сдвиг вправо на 1 бит: 00000100 = 4
        System.out.println("8 >> 1 = " + rightShift);

        int unsignedRightShift = number2 >>> 1;  // беззнаковый сдвиг вправо: 00000100 = 4
        System.out.println("8 >>> 1 = " + unsignedRightShift);

        // 9. Сложение и вычитание
        System.out.println("\n9. Сложение + и вычитание -");
        int sum = 10 + 5;
        int difference = 10 - 5;
        System.out.println("10 + 5 = " + sum);
        System.out.println("10 - 5 = " + difference);

        // 10. Умножение, деление и остаток
        System.out.println("\n10. Умножение *, деление /, остаток %");
        int multiplication = 10 * 5;
        int division = 10 / 3; // целочисленное деление
        int remainder = 10 % 3; // остаток от деления
        System.out.println("10 * 5 = " + multiplication);
        System.out.println("10 / 3 = " + division);
        System.out.println("10 % 3 = " + remainder);

        // 11. Инкремент и декремент
        System.out.println("\n11. Инкремент ++ и декремент --");

        // ПРЕФИКСНАЯ форма (увеличивает, потом использует)
        int counter1 = 5;
        System.out.println("Начальное значение: " + counter1);
        int result1 = ++counter1; // сначала увеличиваем до 6, потом присваиваем
        System.out.println("После ++counter1: counter1 = " + counter1 + ", result1 = " + result1);

        // ПОСТФИКСНАЯ форма (использует, потом увеличивает)
        int counter2 = 5;
        System.out.println("\nНачальное значение: " + counter2);
        int result2 = counter2++; // сначала присваиваем 5, потом увеличиваем до 6
        System.out.println("После counter2++: counter2 = " + counter2 + ", result2 = " + result2);

        // То же самое с --
        int counter3 = 5;
        System.out.println("\nНачальное значение: " + counter3);
        int result3 = --counter3; // сначала уменьшаем до 4, потом присваиваем
        System.out.println("После --counter3: counter3 = " + counter3 + ", result3 = " + result3);

        int counter4 = 5;
        System.out.println("\nНачальное значение: " + counter4);
        int result4 = counter4--; // сначала присваиваем 5, потом уменьшаем до 4
        System.out.println("После counter4--: counter4 = " + counter4 + ", result4 = " + result4);

        // 12. Побитовое НЕ и логическое НЕ
        System.out.println("\n12. Побитовое НЕ ~ и логическое НЕ !");

        int number3 = 5;  // двоичное: 00000101
        int bitwiseNot = ~number3; // инвертирует все биты
        System.out.println("~5 = " + bitwiseNot);

        boolean isTrue = true;
        boolean notTrue = !isTrue; // логическое отрицание
        System.out.println("!true = " + notTrue);

        // 13. Скобки и доступ к массиву
        System.out.println("\n13. Скобки () и доступ к массиву []");

        int withoutParentheses = 2 + 3 * 4; // умножение имеет высший приоритет
        int withParentheses = (2 + 3) * 4; // скобки меняют приоритет
        System.out.println("2 + 3 * 4 = " + withoutParentheses);
        System.out.println("(2 + 3) * 4 = " + withParentheses);

        int[] array = {10, 20, 30, 40, 50}; // создаем массив
        System.out.println("array[2] = " + array[2]); // получаем третий элемент (индекс 2)

        // 14. Операторы для строк
        System.out.println("\n14. Операторы для String");

        String part1 = "Привет, ";
        String part2 = "мир!";
        String whole = part1 + part2; // конкатенация строк
        System.out.println("Склеивание строк: " + whole);

        String greeting = "Хай";
        greeting += ", бро!"; // добавление к строке
        System.out.println("+= для строк: " + greeting);

        String name = "Вася";
        int age2 = 25;
        String info = name + " - " + age2 + " лет"; // конкатенация строки с числами
        System.out.println("Строка + число: " + info);

        String str1 = "Java";
        String str2 = "Java";
        String str3 = new String("Java"); // создаем новую строку с тем же содержимым

        System.out.println("\nСравнение строк:");
        System.out.println("str1 == str2: " + (str1 == str2)); // true (оба ссылаются на один объект)
        System.out.println("str1 == str3: " + (str1 == str3)); // false (разные объекты)
        System.out.println("str1.equals(str3): " + str1.equals(str3)); // true (одинаковое содержимое)
        System.out.println("str1 != str3: " + (str1 != str3)); // true (разные объекты)

        System.out.println("\n\n=== Практика #2: Оператор instanceof ===");

        // Создаем иерархию классов
        class Animal {}
        class Mammal extends Animal {}
        class Dog extends Mammal {}
        class Cat extends Mammal {}
        class Bird extends Animal {}

        // Создаем объекты
        Animal animal = new Animal();
        Mammal mammal = new Mammal();
        Dog dog = new Dog();
        Cat cat = new Cat();
        Bird bird = new Bird();

        System.out.println("\n1. Проверка instanceof для разных типов:");

        System.out.println("\nПроверяем объект 'dog':");
        System.out.println("dog instanceof Dog: " + (dog instanceof Dog));      // true
        System.out.println("dog instanceof Mammal: " + (dog instanceof Mammal)); // true (Dog наследует Mammal)
        System.out.println("dog instanceof Animal: " + (dog instanceof Animal)); // true (Dog наследует Animal)
        //System.out.println("dog instanceof Cat: " + (dog instanceof Cat));      // false (разные классы)

        System.out.println("\nПроверяем объект 'mammal':");
        System.out.println("mammal instanceof Mammal: " + (mammal instanceof Mammal)); // true
        System.out.println("mammal instanceof Animal: " + (mammal instanceof Animal)); // true
        System.out.println("mammal instanceof Dog: " + (mammal instanceof Dog));      // false

        System.out.println("\nПроверяем объект 'cat':");
        System.out.println("cat instanceof Cat: " + (cat instanceof Cat));        // true
        System.out.println("cat instanceof Mammal: " + (cat instanceof Mammal));   // true
        System.out.println("cat instanceof Animal: " + (cat instanceof Animal));   // true

        System.out.println("\nПроверяем объект 'bird':");
        System.out.println("bird instanceof Bird: " + (bird instanceof Bird));     // true
        System.out.println("bird instanceof Animal: " + (bird instanceof Animal)); // true
        //System.out.println("bird instanceof Mammal: " + (bird instanceof Mammal)); // false

        System.out.println("\n2. Практическое использование instanceof:");

        // Используем массив типа Object для хранения разных объектов
        Object[] objects = new Object[5];
        objects[0] = animal;
        objects[1] = mammal;
        objects[2] = dog;
        objects[3] = cat;
        objects[4] = bird;

        // Проверяем типы объектов в цикле
        for (Object obj : objects) {
            if (obj instanceof Dog) {
                System.out.println("Обнаружена собака");
            } else if (obj instanceof Cat) {
                System.out.println("Обнаружена кошка");
            } else if (obj instanceof Mammal) {
                System.out.println("Обнаружено млекопитающее (не собака и не кошка)");
            } else if (obj instanceof Bird) {
                System.out.println("Обнаружена птица");
            } else if (obj instanceof Animal) {
                System.out.println("Обнаружено животное (не млекопитающее и не птица)");
            }
        }

        // Особый случай: instanceof с null
        System.out.println("\n3. Особый случай: instanceof с null:");

        Animal nullAnimal = null; // нулевая ссылка

        //System.out.println("nullAnimal instanceof Animal: " + (nullAnimal instanceof Animal));  // false
        //System.out.println("nullAnimal instanceof Object: " + (nullAnimal instanceof Object));  // false
        //System.out.println("nullAnimal instanceof String: " + (nullAnimal instanceof String));  // false

        if (nullAnimal instanceof Animal) {
            System.out.println("Это животное"); // этот код не выполнится
        } else {
            System.out.println("nullAnimal не является экземпляром Animal (всегда false для null)");
        }

        // instanceof с интерфейсами
        System.out.println("\n4. instanceof с интерфейсами:");

        interface Swimmable {}
        interface Flyable {}

        class Duck extends Animal implements Swimmable, Flyable {}

        Duck duck = new Duck();

        System.out.println("duck instanceof Animal: " + (duck instanceof Animal));      // true
        System.out.println("duck instanceof Swimmable: " + (duck instanceof Swimmable)); // true
        System.out.println("duck instanceof Flyable: " + (duck instanceof Flyable));    // true

        // Pattern matching для instanceof (Java 16+)
        System.out.println("\n5. Pattern matching для instanceof (Java 16+):");

        Object testString = "Hello, World!"; // создаем объект типа String

        // Старый способ
        if (testString instanceof String) {
            String str = (String) testString; // явное приведение типа
            System.out.println("Длина строки (старый способ): " + str.length());
        }

        // Новый способ с pattern matching
        // Если у вас Java 16+, раскомментируйте этот блок:
        /*
        if (testString instanceof String str) {
            System.out.println("Длина строки (новый способ): " + str.length());
        }
        */

        System.out.println("(Pattern matching закомментирован для совместимости)");

        // instanceof с массивами
        System.out.println("\n6. instanceof с массивами:");
        int[] intArray = new int[5];
        String[] stringArray = new String[3];

        System.out.println("intArray instanceof Object: " + (intArray instanceof Object));    // true
        System.out.println("intArray instanceof int[]: " + (intArray instanceof int[]));      // true
        System.out.println("stringArray instanceof Object[]: " + (stringArray instanceof Object[])); // true

        // Дополнительный пример с null в массиве
        System.out.println("\n7. Дополнительно: null в массиве:");
        Object[] mixedArray = {dog, cat, null, bird};

        for (int i = 0; i < mixedArray.length; i++) {
            if (mixedArray[i] == null) {
                System.out.println("Элемент " + i + ": null");
            } else if (mixedArray[i] instanceof Dog) {
                System.out.println("Элемент " + i + ": Собака");
            } else if (mixedArray[i] instanceof Cat) {
                System.out.println("Элемент " + i + ": Кошка");
            }
        }
    }
}
