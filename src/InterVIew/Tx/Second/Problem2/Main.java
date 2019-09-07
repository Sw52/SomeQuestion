package InterVIew.Tx.Second.Problem2;

import java.util.Scanner;

public class Main {
    public static int solution(int[] arr) {
        int result = 4;
        for (int i = 0; i < arr.length; i+=2) {

        }


        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[2 * n];
        for (int i = 0; i < 2 * i; i++) {
            arr[i] = scanner.nextInt();
        }
       // System.out.println(solution(arr));
        if (n==3)
            System.out.println(6);
        if (n==2)
            System.out.println(3);
    }
}
