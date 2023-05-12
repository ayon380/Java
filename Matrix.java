import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Matrix {
    public static void main(String args[]) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        System.out.println("Enter the size of the matrix : ");
        int n = Integer.parseInt(br.readLine());
        int[][] mat1 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Enter the values for (" + i + "," + j + ")");
                mat1[i][j] = Integer.parseInt(br.readLine());
            }
        }
        int[][] mat2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Enter the values for (" + i + "," + j + ")");
                mat2[i][j] = Integer.parseInt(br.readLine());
            }
        }
        System.out.println("\nAddition of Two Matrices :\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat1[i][j] + mat2[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("\nSubstraction of Two Matrices :\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat1[i][j] - mat2[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("\nMultiplication of Two Matrices :");
        int[][] mat3 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat3[i][j]=0;
                for (int k = 0; k < n; k++) {
                    mat3[i][j]+=mat1[i][k]*mat2[k][j];
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(mat3[i][j]+" ");

            }
            System.out.println("");
        }
    }
}
