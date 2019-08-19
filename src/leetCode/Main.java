package leetCode;

import java.util.Scanner;

public class Main {

    public int find() {
        Scanner sc = new Scanner(System.in);
        int[] result = new int[2];

        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        int num = 1;
        for (int i = 0; i < array.length; i++) {
            int temp = 1;
            int k = 1;
            int j = i;
            while (j + k < array.length) {
                if (array[j + k] > array[j]) {
                    temp++;
                    j+=k;
                    k=1;
                } else {
                    k++;
                }
            }

            if (temp > num) {
                num = temp;
            }

        }
        return num;
    }

    public static void main(String[] args) {
        Main ma = new Main();
        int num = ma.find();
        System.out.println(num);
    }
}
