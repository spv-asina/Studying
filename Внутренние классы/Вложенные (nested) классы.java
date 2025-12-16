interface I1 {
    // Статический вложенный класс внутри интерфейса
    static class N {
        public void m() {
            System.out.println("Метод m в классе N внутри интерфейса I1");
        }
    }

    // Еще один статический класс с другим методом
    static class M {
        public void m2() {
            System.out.println("Метод m2 в классе M");
        }
    }
}

// Другой интерфейс с вложенным классом, который имеет статическое поле
interface I2 {
    static class K {
        private static int count = 0;

        public void inc() {
            count++;
            System.out.println("count = " + count);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Практика #1");

        // Создание экземпляра вложенного класса из интерфейса I1
        I1.N obj1 = new I1.N();
        obj1.m();

        // Создание экземпляра другого вложенного класса из интерфейса I1
        I1.M obj2 = new I1.M();
        obj2.m2();

        // Создание экземпляра вложенного класса из интерфейса I2
        I2.K obj3 = new I2.K();
        obj3.inc();
        obj3.inc();

        // Еще один объект того же класса
        I2.K obj4 = new I2.K();
        obj4.inc(); // count будет продолжать увеличиваться, так как поле статическое
    }
}
