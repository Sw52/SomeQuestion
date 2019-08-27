package CodingInterview;

import java.util.Arrays;

public class Q17_打印从1到最答的n位数 {
    /**
     * 问题描述： 输入数字n，按顺序打印出1到最大的n位十进制整数。
     * 比如输入3，则打印出1、 2 、 3一直到最大的三位数999.
     *
     * @param n 思路：此题是一道隐含大数问题的题目，思路是使用字符串来表示过大的数字。
     */
    public static void printToMaxOfDigits(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n + 1];
        number[n] = '\0';

        for (int i = 0; i < 10;i++){
            number[0] = (char) (i + '0');
            printToMaxOfDigitsRecursively(number, n, 0);
        }
    }

    static void printToMaxOfDigitsRecursively(char[] number, int length, int index) {
        if (index == length - 1) {
            System.out.println(number);
            return;
        }
        for (int i = 0; i < 10; ++i) {
            number[index + 1] = (char) (i + '0');
            printToMaxOfDigitsRecursively(number, length, index + 1);
        }
    }

    public static void main(String[] args) {
        printToMaxOfDigits(3);
    }
}
