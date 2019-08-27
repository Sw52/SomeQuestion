package InterVIew.Yitu.Problem2;

import java.util.Scanner;

public class Main {

    public static int solution(int n, int k, int target, int[][] array) {
        if (target < n || target > n * k)
            return 0;
        int[][] result = new int[35][1050];
        result[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= target && j <= k * i; j++) {
                for (int l = 1; l <= k && j - l >= 0; l++) {
                    result[i][j] = (result[i][j] + result[i - 1][j - l]);
                }
            }
        }
        return result[n][target];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] array = new int[n][6];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solution(n, k, 6, array));

        // System.out.println(6);
    }
}