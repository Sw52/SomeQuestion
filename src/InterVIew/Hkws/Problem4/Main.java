package InterVIew.Hkws.Problem4;

import java.util.Scanner;

/**
 * 问题四
 */
public class Main {

    public static void solution(int n,int[][]array){

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] array = new int[n-1][2];

        for (int i=0;i<n-1;i++){
            array[i][0] = sc.nextInt();
            array[i][1] = sc.nextInt();
        }
    }
}
