package InterVIew.Hkws.Problem2;

import java.util.Scanner;

/**
 * 问题二
 */
public class Main {

    public static int[] solution(int N, int K, int[] array) {
        int[] numble = new int[N];
        numble[0] = array[0];
        for (int i = 1; i < N; i++) {
            int temp = array[i] ^ numble[0];
            for (int j = 1; j < i; j++) {
                temp = temp ^ numble[j];
            }
            numble[i] = temp;
        }
        return numble;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        String str = sc.next();
        System.out.println(str);
        int[] array = new int[N + K - 1];
        for (int i = 0; i < N + K - 1; i++) {
            array[i] = str.charAt(i) - 48;
        }
        int[] An = Main.solution(N, K, array);
        for(int i =0;i<N;i++){
            System.out.print(An[i]);
        }
    }
}
