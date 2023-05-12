import java.util.*;
public class ArmstrongNumber {
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int a=n;
        int s=0;
        while(n!=0)
        {
            s+=Math.pow(n%10,3);
            n/=10;
        }
        if(s==a)
        {
            System.out.println("Armstrong Number");
        }
        else{
            System.out.println("Not a Armstrong Number");
        }
        sc.close();
    }   
}
