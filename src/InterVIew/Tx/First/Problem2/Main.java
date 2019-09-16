package InterVIew.Tx.First.Problem2;

import java.util.Scanner;

public class Main {
    public static int solution(int n, int L, int[][] array) {
        int temp = 0;
        int goal = 0;
        int i = 0;
        while (true) {
            if (i < n && array[i][0] < L && array[i][0] == goal) {
                goal = array[i][1];
                temp++;
                array[i][0] = L;
                if (array[i][1] >= L)
                    break;
            } else if (i < n && array[i][0] < goal && array[i][1] >= L) {
                temp++;
                break;
            }
            i++;
            if (i >= n)
                i = 0;

        }
        return temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int L = scanner.nextInt();

        int[][] array = new int[n][2];
        for (int i = 0; i < n; i++) {
            array[i][0] = scanner.nextInt();
            array[i][1] = scanner.nextInt();
        }
        System.out.println(solution(n, L, array));
    }
}
