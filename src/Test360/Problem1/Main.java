package Test360.Problem1;

import java.util.Scanner;

public class Main {

    public static int solution(int N, int M, int[][] array) {

        int temp = 0;
        temp = N*M*2;
        for (int i =0;i<N;i++)
            for (int j=0;j<M;j++){
                temp+=array[i][j]*4;
            }
        return temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[][] array = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                array[i][j] = scanner.nextInt();
        }

        System.out.println(solution(N,M,array));
    }
}
