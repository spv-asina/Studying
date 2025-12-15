public class Main {
    public static void main(String[] args) {
        System.out.println("Практика #1");

        int a1[] = {1,2,3,4,5};
        int a2[] = {6,7,8,9,10};
        a1 = a2;

        System.out.println("a1[0] = " + a1[0]);
        System.out.println("a2[0] = " + a2[0]);

        a1[0] = 100;
        System.out.println("После a1[0] = 100:");
        System.out.println("a1[0] = " + a1[0]);
        System.out.println("a2[0] = " + a2[0]);

        System.out.println("\nПрактика #2");

        int[] arr = {5, 3, 8, 1, 9};

        // toString
        System.out.println("Arrays.toString(): " + java.util.Arrays.toString(arr));

        // sort
        java.util.Arrays.sort(arr);
        System.out.println("После sort: " + java.util.Arrays.toString(arr));

        // binarySearch
        int index = java.util.Arrays.binarySearch(arr, 8);
        System.out.println("binarySearch(arr, 8): " + index);

        // equals
        int[] arr2 = {1, 3, 5, 8, 9};
        boolean equal = java.util.Arrays.equals(arr, arr2);
        System.out.println("Arrays.equals(arr, arr2): " + equal);

        // compare
        int[] arr3 = {1, 2, 3};
        int result = java.util.Arrays.compare(arr2, arr3);
        System.out.println("Arrays.compare(arr2, arr3): " + result);
    }
}
