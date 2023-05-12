import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayPS {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int min = arr[0], max = arr[0];
        for (int i : arr) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }
        System.out.println("The minimum element in the array is : "+min);
        System.out.println("The maximum element in the array is : "+max);
        int arr1[]=new int[n];
        arr1=arr;
        Arrays.sort(arr1);
        System.out.println("The Second minimum element in the array is : "+arr1[1]);
        System.out.println("The Second maximum element in the array is : "+arr1[n-2]);
        int s=0,end=n-1;
        while(s<end)
        {
            int temp=arr[s];
            arr[s]=arr[end];
            arr[end]=temp;
            s++;
            end--;
        }
        System.out.println("Reversed Array ");
        for(int i: arr)
        {
            System.out.print(i+" ");
        }
        ArrayList<Integer> odd=new ArrayList<Integer>();
        ArrayList<Integer> even=new ArrayList<Integer>();
        for(int i: arr)
        {
            if(i%2==0)
            {
                even.add(i);
            }
            else{
                odd.add(i);
            }
        }
        System.out.println("Odd elements :");
        for(int i : odd)
        {
            System.out.println(i+" ");
        }
        System.out.println("Even Elements :");
        for(int i: even)
        {
            System.out.println(i+" ");
        }
        sc.close();
    }
}
