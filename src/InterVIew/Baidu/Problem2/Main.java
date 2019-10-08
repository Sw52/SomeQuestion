package InterVIew.Baidu.Problem2;


import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public int solution(long[] arr, int n) {
        int result = 0;
        Arrays.sort(arr);
        while (arr[arr.length - 1] >= n) {
            if (arr[arr.length - 1] >= n) {
                arr[arr.length - 1] -= n;
                for (int i = 0; i < n - 1; i++) {
                    arr[i]++;
                }
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Main ma = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        System.out.println(ma.solution(arr, n));
    }
}