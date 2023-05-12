public class Array {
    public static void main(String args[]) {
        int arr[] = {5,9};
        String names[] = {"Ayon","krish"};
        float farr[] = {1.34f,2.56f};
        for (int i : arr) {
            System.out.print(i + " - ");
        }
        System.out.println("\n");
        for (String i : names) {
            System.out.print(i + " - ");
        }
        System.out.println("\n");
        for (float i : farr) {
            System.out.print(i + " - ");
        }
    }
}
