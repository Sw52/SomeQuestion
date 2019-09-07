package InterVIew.Xc.Problem3;

import java.util.Scanner;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int schedule(int m, int[] array) {
        int key = array.length / m + 1;
        int ressult = 1000;
        for (int i = 0; i < array.length - key; i++) {
            int temp = 0;
            for (int j = i; j < i + key; j++) {
                temp += array[j];
            }
            ressult = Math.min(temp, ressult);
        }
        return ressult;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int size = in.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        int res = schedule(m, array);
        System.out.println(String.valueOf(res));
    }
}