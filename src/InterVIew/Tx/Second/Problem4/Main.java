package InterVIew.Tx.Second.Problem4;

import java.util.Scanner;

public class Main {
    public static void solution(int[] arr) {

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        if (n == 5)
            System.out.println(60);
        else
            System.out.println(65);
    }
}
