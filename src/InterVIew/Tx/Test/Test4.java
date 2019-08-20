package InterVIew.Tx.Test;

import java.util.Scanner;

public class Test4 {
    /*
    小Q的歌单
    时间限制：1秒

    空间限制：32768K

    小Q有X首长度为A的不同的歌和Y首长度为B的不同的歌，现在小Q想用这些歌组成一个总长度正好为K的歌单，每首歌最多只能在歌单中出现一次，在不考虑歌单内歌曲的先后顺序的情况下，请问有多少种组成歌单的方法。

    输入描述:
    每个输入包含一个测试用例。
    每个测试用例的第一行包含一个整数，表示歌单的总长度K(1<=K<=1000)。
    接下来的一行包含四个正整数，分别表示歌的第一种长度A(A<=10)和数量X(X<=100)以及歌的第二种长度B(B<=10)和数量Y(Y<=100)。保证A不等于B。

    输出描述:
    输出一个整数,表示组成歌单的方法取模。因为答案可能会很大,输出对1000000007取模的结果。

    输入例子1:
    5
    2 3 3 3

    输出例子1:
    9
     */
    /*
    用例:
17
5 79 4 66

对应输出应该为:

3615040

你的输出为:

0
     */
    public static int jiechen(int num) {
        int result = 1;
        for (int i = 1; i <= num; i++) {
            result = result * i;
        }
        return result;
    }


    public static long solution(int K, int[] array) {
        int lengthA = array[0];
        int numA = array[1];
        int lengthB = array[2];
        int numB = array[3];

        long temp = 0;
        if (lengthA + lengthB == K) {
            temp = numA * numB % 1000000007;
        } else {
            int i = K / lengthA;
            int j = K / lengthB;
            for (int m = 0; m <= i; m++) {
                for (int n = 0; n <= j; j++)
                    if (lengthA * i + lengthB * j == K) {
                        temp += (jiechen(numA) / (jiechen(i) * jiechen(numA - i))) * (jiechen(numB) / (jiechen(j) * jiechen(numB - j)));
                    }
            }
        }
        return temp % 1000000007;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        int[] array = new int[4];
        for (int i = 0; i < 4; i++)
            array[i] = scanner.nextInt();
        System.out.println(solution(K, array));

    }
}
