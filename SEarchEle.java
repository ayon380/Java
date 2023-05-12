import java.util.Scanner;

public class SEarchEle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array :");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int k=0;
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the value for the index position " + i);
            arr[i] = sc.nextInt();
        }
        int []arr1=new int[n];
        System.out.println("Enter the element to be searched : ");
        int x = sc.nextInt();
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                System.out.println("Element Found at Index " + i);
                c++;
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(arr[i]==arr[j] && i!=j) 
                {
                    arr1[k++]=arr[i];
                }
            }
        }
        System.out.println("Duplicate Elements :");
        for(int i=0;i<k;i++)
        {
            System.out.print(arr[k]);
        }
        if (c > 0) {
            System.out.println("Count of the element " + x + " is : " + c);
        } else if (c == 0) {
            System.out.println("Element not Found");
        }
    }
}
