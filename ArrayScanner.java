import java.util.Scanner;

public class ArrayScanner {
    public static void main(String args[]) {
        int arr[] = new int[2];
        String names[] = new String[2];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            System.out.println("Enter your name and roll no: ");
            arr[i] = sc.nextInt();
            names[i] = sc.next();
        }
        System.out.print("Roll    Name\n");
        for (int i = 0; i < 2; i++) {
            System.out.println(arr[i] + " -    " + names[i] );
        }
        sc.close();
    }
}
