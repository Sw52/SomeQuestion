package InterVIew.Baidu.Problem1;


import java.util.Scanner;

public class Main {

    /**
     * 求最大公约数
     *
     * @param n
     * @param m
     * @return
     */
    private int gcd(int n, int m) {
        if (n < m) {
            int temp = n;
            n = m;
            m = temp;
        }
        while (m != 0) {
            int temp = n % m;
            n = m;
            m = temp;
        }
        return n;
    }

    /**
     * 求最小公倍数
     *
     * @param n
     * @param m
     * @return
     */
    private int lcm(int n, int m) {
        return n * m / gcd(n, m);
    }

    public int solution(int n) {
        int temp = 0;
        for (int i = 1; i < n; i++) {
            for (int j = n; j >= 0; j--) {
                int x = gcd(i, j);
                temp = Math.max(temp, i * j / x - x);
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        Main ma = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(ma.solution(n));
    }
}