import java.io.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Практика #1");
        byte[] data = {65, 66, 67, 68, 69};
        InputStream is = new ByteArrayInputStream(data);

        try {
            int b;
            while ((b = is.read()) != -1) {
                System.out.print((char)b + " ");
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nПрактика #2");
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        // ByteArrayOutputStream.write() не бросает IOException
        os.write(70);
        os.write(71);
        os.write(72);

        byte[] result = os.toByteArray();
        System.out.println(new String(result));

        System.out.println("\nПрактика #3");
        System.out.println("InputStream/OutputStream - байты");
        System.out.println("Reader/Writer - символы");

        System.out.println("\nПрактика #4");
        try {
            FileWriter fw = new FileWriter("test.txt");
            try {
                fw.write("Тест");
            } finally {
                fw.close(); // Закрываем вручную
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // С AutoCloseable
        try (FileWriter fw2 = new FileWriter("test2.txt")) {
            fw2.write("Тест AutoCloseable");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
