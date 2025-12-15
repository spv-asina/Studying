import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Практика #1");

        Box<Integer> b1 = new Box<>(10);
        Box<String> b2 = new Box<>("text");

        // 1. Без параметра (сырой тип)
        System.out.println("b1 instanceof Box: " + (b1 instanceof Box));

        // 2. С wildcard
        System.out.println("b1 instanceof Box<?>: " + (b1 instanceof Box<?>));

        // 3. Проверка содержимого
        Object obj = b1.getItem();
        System.out.println("b1.getItem() instanceof Integer: " + (obj instanceof Integer));

        // 4. Проверка для коллекций
        List<Integer> list = new ArrayList<>();
        System.out.println("list instanceof List<?>: " + (list instanceof List<?>));

        // Практика #2: <? extends T> и <? super T>
        System.out.println("\nПрактика #2");

        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);

        List<Number> nums = new ArrayList<>();
        List<Object> objs = new ArrayList<>();

        // 1. <? extends Number> - можно читать, нельзя добавлять (кроме null)
        System.out.println("Метод printNumbers с List<Integer>:");
        printNumbers(ints);

        // 2. <? super Integer> - можно добавлять Integer, нельзя читать как Integer
        System.out.println("\nМетод addNumbers с List<Number> и List<Object>:");
        addNumbers(nums, 10);
        addNumbers(objs, 20);

        System.out.println("nums: " + nums);
        System.out.println("objs: " + objs);
    }

    // <? extends Number> - принимает список любых Number или его подклассов
    public static void printNumbers(List<? extends Number> list) {
        // Можно читать элементы как Number
        for (Number n : list) {
            System.out.println(n);
        }

        // Нельзя добавлять (кроме null) - компилятор не знает точный тип
        // list.add(5); // Ошибка компиляции
        // list.add(3.14); // Ошибка компиляции
        list.add(null); // Разрешено
    }

    // <? super Integer> - принимает список, в который можно положить Integer
    public static void addNumbers(List<? super Integer> list, Integer value) {
        // Можно добавлять Integer
        list.add(value);

        // Нельзя читать как Integer (только как Object)
        // Integer i = list.get(0); // Ошибка компиляции
        Object obj = list.get(0); // OK
    }
}

class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getItem() {
        return value;
    }
}
