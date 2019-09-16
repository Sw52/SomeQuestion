package InterVIew.Tx.Second.Problem5;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    /**
     * 计算阶乘数，即n! = n * (n-1) * ... * 2 * 1
     *
     * @param n
     * @return
     */
    public static long factorial(int n) {
        long sum = 1;
        while (n > 0) {
            sum = sum * n--;
        }
        return sum;
    }

    /**
     * 组合计算公式C<sup>m</sup><sub>n</sub> = n! / (m! * (n - m)!)
     *
     * @param m
     * @param n
     * @return
     */
    public static long combination(int m, int n) {
        return m <= n ? factorial(n) / (factorial(m) * factorial((n - m))) : 0;
    }

    //n表示花数，m表示白花数
    public static long coutnt(int n, int m) {
        long result = 0;
        if (m == 0)
            return 1;
        if (m == n)
            return 1;
        return combination(1, n - m + 1);
    }

    /**
     * @param n 左边界
     * @param m 右边界
     * @param k
     * @return
     */
    public static long solution(int n, int m, int k) {
        long result = 0;
        Set<Integer> set = new TreeSet<Integer>();

        set.add(0);
        while (k <= m) {
            set.add(k); //将可能的k值放入set
            k *= k;
        }
//        for (int j : set
//        ) {
//            System.out.println(j);
//        }
        for (int i = n; i <= m; i++) {
            for (int j : set
            ) {
                result += coutnt(i, j);
            }
        }
        return result % 1000000007;
    }

    /**
     * 本地测试没问题
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        int k = 0;
        if (scanner.hasNext()) {
            n = scanner.nextInt();
            k = scanner.nextInt();
        }
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (scanner.hasNext()) {
                arr[i][0] = scanner.nextInt();
                arr[i][1] = scanner.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(solution(arr[i][0], arr[i][1], k));
        }
    }
}
