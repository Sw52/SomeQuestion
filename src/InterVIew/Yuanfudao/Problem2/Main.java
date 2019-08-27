package InterVIew.Yuanfudao.Problem2;

import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static int solution(int[] arr) {
        int res = 0;
        int[] array = Arrays.copyOf(arr,arr[0]+1);
        int[] arra = new int[array.length-1];
        for (int i = 1; i < array.length; i++) {
            arra[i-1] = array[i];
        }
        if (array[0]==3){
            res = Math.min(Math.min(array[1],array[2]),array[3]);
        }else {
            Arrays.sort(arra);
           // System.out.println(Arrays.toString(arra));
            res = arra[arra.length-3];
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arra = new int[n][1000];
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            arra[i][0] = m;
            for (int j = 1; j < m + 1; j++) {
                arra[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(solution(arra[i]));
        }
    }
}
