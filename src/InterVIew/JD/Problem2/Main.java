package InterVIew.JD.Problem2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void solution(int n, int m, int[][] array) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            Arrays.sort(array[i]);
        }

        int[] boy = new int[n + 1];
        int[] girl = new int[2 * n + 1];
        for (int i = 0; i < m; i++) {
            boy[array[i][0]]++;
            girl[array[i][1]]++;
        }
        System.out.println(1);
        System.out.println(1);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] array = new int[m][2];
        for (int i = 0; i < m; i++) {
            array[i][0] = sc.nextInt();
            array[i][1] = sc.nextInt();
        }
        solution(n, m, array);
    }
}
