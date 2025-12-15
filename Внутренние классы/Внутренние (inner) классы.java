class O1 {
    public class A {
        public void m() {
            System.out.println("A public");
        }
    }

    private class B {
        public void m() {
            System.out.println("B private");
        }
    }

    protected class C {
        public void m() {
            System.out.println("C protected");
        }
    }

    class D {
        public void m() {
            System.out.println("D default");
        }
    }

    public void test() {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();

        a.m();
        b.m();
        c.m();
        d.m();
    }
}

class O2 {
    private int x1 = 1;
    int x2 = 2;
    protected int x3 = 3;
    public int x4 = 4;

    public class I {
        private int y1 = 10;
        int y2 = 20;
        protected int y3 = 30;
        public int y4 = 40;
        public void show() {
            System.out.println("Из I в O2:");
            System.out.println("x1: " + x1);
            System.out.println("x2: " + x2);
            System.out.println("x3: " + x3);
            System.out.println("x4: " + x4);
        }
    }
    public void test() {
        I i = new I();
        System.out.println("Из O2 в I:");
        System.out.println("y1: " + i.y1);
        System.out.println("y2: " + i.y2);
        System.out.println("y3: " + i.y3);
        System.out.println("y4: " + i.y4);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Практика #1");
        O1 o1 = new O1();
        o1.test();

        // Создание внутренних классов извне
        O1.A a = o1.new A();
        a.m();

        // O1.B b = o1.new B(); // Ошибка: private
        // O1.C c = o1.new C(); // protected - доступен только в подклассах или пакете
        // O1.D d = o1.new D(); // default - доступен только в пакете

        System.out.println("\nПрактика #2 и #3");
        O2 o2 = new O2();
        O2.I i = o2.new I();

        i.show();  
        o2.test();
    }
}
