import java.util.Scanner;

public class DiffLarSmal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the elements of array: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int lar = arr[0];
        int smal = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > lar) {
                lar = arr[i];
            }
            if (arr[i] < smal) {
                smal = arr[i];
            }
        }
        System.out.println("Largest number is: " + lar);
        System.out.println("Smallest number is: " + smal);
        System.out.println("Difference is: " + (lar - smal));
    }
}
