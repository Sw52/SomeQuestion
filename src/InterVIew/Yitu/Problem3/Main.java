package InterVIew.Yitu.Problem3;

import java.util.Scanner;

public class Main {

    public static void solution(int n) {
        int temp = 0;
        if (n % 2 == 0)
            temp = n / 2;
        else if (n % 2 == 1)
            temp = n / 2 + 1;
        //System.out.println(temp);

        int mod = 1000000007;
        long[] inv = new long[1000001];
        inv[1] = 1;
        for (int i = 2; i <= 1000000; i++) {
            inv[i] = inv[mod % i] * (mod - mod / i) % mod;
        }

        System.out.println(temp * inv[n] + 1);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        solution(n);
    }
}