import java.util.*;

class ReverseNumber {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = 0;
        while (n != 0) {
            int d = n % 10;
            s = (s * 10) + d;
            n /= 10;
        }
        System.out.println(s);
        sc.close();
    }
}