public class Main {
    public static void main(String[] args) {
        A a = new A();
        Number[] num = {new Integer(1), 11, 1.11f, 11.11};

        System.out.println("Цикл for (1):");
        for (Number n : num) {
            a.printNum(n);
        }

        System.out.println("\nПрямые вызовы (2):");
        a.printNum(new Integer(1));
        a.printNum(11);
        a.printNum(1.11f);
        a.printNum(11.11);
    }
}

class A {
    public void printNum(Integer i) {
        System.out.printf("Integer = %d%n", i);
    }

    public void printNum(int i) {
        System.out.printf("int = %d%n", i);
    }

    public void printNum(Float f) {
        System.out.printf("Float = %.4f%n", f);
    }

    public void printNum(Number n) {
        System.out.println("Number=" + n);
    }
}

/*
Перегрузка разрешается на этапе компиляции на основе объявленного типа переменной, а не реального типа объекта во время выполнения (в отличие от переопределения).
*/
