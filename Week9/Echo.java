package Week9;

import java.util.Scanner;

public class Echo {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String line = sc.nextLine();
        System.out.println("You entered: " + line);
        sc.close();
    }
}
