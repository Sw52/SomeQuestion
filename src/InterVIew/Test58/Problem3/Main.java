package InterVIew.Test58.Problem3;

import java.util.Scanner;

/*
矩阵中的最短路径
 */
public class Main {

    public static int solution(int[][] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = arr[0].length - 1; j >= 0; j--) {
                if (i == arr.length - 1 && j != arr[0].length - 1)
                    arr[i][j] = arr[i][j] + arr[i][j + 1];
                else if (j == arr[0].length - 1 && i != arr.length - 1)
                    arr[i][j] = arr[i][j] + arr[i + 1][j];
                else if (j != arr[0].length - 1 && i != arr.length - 1)
                    arr[i][j] = arr[i][j] + Math.min(arr[i + 1][j], arr[i][j + 1]);

            }
        }
        return arr[0][0];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solution(arr));
    }
}