package Tx.Test;


import java.util.Scanner;

public class Test3 {
    /*
    贪吃的小Q
    时间限制：1秒

    空间限制：32768K

    小Q的父母要出差N天，走之前给小Q留下了M块巧克力。小Q决定每天吃的巧克力数量不少于前一天吃的一半，但是他又不想在父母回来之前的某一天没有巧克力吃，请问他第一天最多能吃多少块巧克力

    输入描述:
    每个输入包含一个测试用例。
    每个测试用例的第一行包含两个正整数，表示父母出差的天数N(N<=50000)和巧克力的数量M(N<=M<=100000)。

    输出描述:
    输出一个数表示小Q第一天最多能吃多少块巧克力。

    输入例子1:
    3 7

    输出例子1:
    4
     */
    public static int solution(int n, int m) {
        int temp = m;
        int date = n;


        return temp;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(solution(n, m));
    }
}
