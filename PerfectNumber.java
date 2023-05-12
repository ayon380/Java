import java.util.*;
public class PerfectNumber{
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int s=1;
        for(int i=2;i<n-1;i++)
        {
            if(n%i==0)
            {
                s+=i;
            }
        }
        if(s==n)
        {
            System.out.println("Perfect Number");
        }
        else{
            System.out.println("Not a perfect number ");
        }
        sc.close();
    }
}