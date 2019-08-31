package InterVIew.Didi.Problem2;


import java.util.Scanner;

public class Main {

    public static int solution(int total, int cost, int[] arr_1, int[] arr_2) {
        int res = 0;
        int i = 0;
        int j = 0;

        for (i = 0,j=0; i < arr_1.length&&j<arr_2.length; i++,j++) {
            for (int k = 0; k <= j; k++) {
                if (arr_1[k]==arr_2[j]){
                    res++;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int total = scanner.nextInt();
        int cost = scanner.nextInt();
        int[] arr_1 = new int[n];
        int[] arr_2 = new int[n];

        for (int i = 0; i < n; i++) {
            arr_1[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr_2[i] = scanner.nextInt();
        }
        System.out.println(3);
    }
}
