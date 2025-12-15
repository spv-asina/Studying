public class Main {
    public static void main(String[] args) {
        System.out.println("Практика #1");
        System.out.println("Исходный код:");
        System.out.println("int i = 0;");
        System.out.println("if (a == 1) {");
        System.out.println("    i = 1;");
        System.out.println("} else if (a == 2) {");
        System.out.println("    i = 2;");
        System.out.println("} else {");
        System.out.println("    i = 3;");
        System.out.println("}");


        for (int a = 0; a <= 3; a++) {
            int i = (a == 1) ? 1 : (a == 2) ? 2 : 3;
            System.out.println("При a = " + a + ", i = " + i);
        }
    }
}
