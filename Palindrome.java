import java.util.Scanner;

public class Palindrome{
    public static void main(String args[])
    {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int s=0;
        int q=n;
        while(n!=0)
        {
            int d=n%10;
            s=s*10+d;
            n/=10;
        }
        if(q==s)
        {
            System.out.print("Palindrome No");
        }
        else{
            System.out.print("Not a palindrome no");
        }
    }
}