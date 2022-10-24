import java.util.Scanner;

public class game3xNplus1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[40][40];
        int r = 0;
        int c = -1;
        int i = 0;
        int j = -1;
        String string = "";
        fillMatrix(matrix,n,r,c);
        printMatrix(matrix,i,j,string);
    }
    private static void fillMatrix(int[][] matrix,int n,int r, int c) {
        if (r >= 40) {
            return;
        }
        c++;
        matrix[r][c] = n;
        if (c == 39) {
            c = -1;
            r++;
        }
        n++;
        fillMatrix(matrix,n,r,c);
    }
    public static void printMatrix(int[][] matrix,int i,int c,String string) {

        if (i >= 40) {
            return;
        }
        c++;
        System.out.print(string + matrix[i][c]);
        string += " ";
        if (c == 39) {
            c = -1;
            i++;
            string = " ";
            System.out.println();
        }
        printMatrix(matrix,i,c,string);
    }

    public static void print(int n,String string) {
        if (n == 1) {
            return;
        }
        System.out.println(string + n);
        if (n % 2 == 0) {
            n /= 2;
            string += " ";
        } else {
            n = 3 * n + 1;
        }
        System.out.println(string + n);
        print(n,string);
        System.out.println(string + n);

    }
}
