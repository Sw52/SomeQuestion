package byteDance.Problem3;

import java.util.Scanner;

/**
 * 问题三
 */
public class Main {

    public static int[] solution(int n, int[] array) {
        int[] money = new int[n];
        if (array[0] < array[1]) {
            money[0] = 100;
            money[1] = 200;
        } else if (array[0] > array[1]) {
            money[0] = 200;
            money[1] = 100;
        } else {
            money[0] = 100;
            money[1] = 100;
        }
        for (int i = 2; i < n - 1; i++) {
            if (array[i] > array[i - 1])
                money[i] = money[i - 1] + 100;
            else if (array[i] < array[i - 1] && array[i] < array[i + 1]) {
                money[i] = 100;
            }
        }
        if(array[n-1]>array[n-2])
            money[n-1]=money[n-2]+100;
        else {
            money[n-1]=100;
        }
        return money;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        int[] An = Main.solution(n, array);
        int temp = 0;
        for (int i = 0; i < n; i++) {
            temp += An[i];
        }
        System.out.println(temp);
    }
}
