package sw.practice;

import java.util.Arrays;
import java.util.Scanner;

public class 最大上升子序列和 {
/*
题目描述：
一个数的序列bi，当b1 < b2 < ... < bS的时候，我们称这个序列是上升的。对于给定的一个序列(a1, a2, ...,aN)，
我们可以得到一些上升的子序列(ai1, ai2, ..., aiK)，这里1 <= i1 < i2 < ... < iK <= N。
比如，对于序列(1, 7, 3, 5, 9, 4, 8)，有它的一些上升子序列，如(1, 7), (3, 4, 8)等等。
这些子序列中序列和最大为18，为子序列(1, 3, 5, 9)的和. 你的任务，就是对于给定的序列，求出最大上升子序列和。
注意，最长的上升子序列的和不一定是最大的，比如序列(100, 1, 2, 3)的最大上升子序列和为100，而最长上升子序列为(1, 2, 3)。

链接：https://www.nowcoder.com/questionTerminal/dcb97b18715141599b64dbdb8cdea3bd
来源：牛客网

输入描述:
输入包含多组测试数据。
每组测试数据由两行组成。第一行是序列的长度N (1 <= N <= 1000)。第二行给出序列中的N个整数，这些整数的取值范围都在0到10000（可能重复）。


输出描述:
对于每组测试数据，输出其最大上升子序列和。
示例1
输入
7
1 7 3 5 9 4 8
输出
18
*/

    /**
     * @param array
     * @return
     * @see 求最大上升子序列和
     */
    public static int solution(int[] array) {
        int[] result = Arrays.copyOf(array, array.length);
        int[] db = new int[array.length];
        Arrays.fill(db, 1);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    db[i] = Math.max(db[i], db[j] + 1);
                    result[i] = Math.max(result[i], array[i] + result[j]);
                }
            }
        }
        int res = 0;
        for (int i : result
        ) {
            res = Math.max(res, i);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println(solution(array));
    }
}
