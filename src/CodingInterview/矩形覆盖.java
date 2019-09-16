package CodingInterview;

import java.util.Scanner;

/*
题目描述
我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？

 */
public class 矩形覆盖 {

    /**
     * @param n
     * @return
     * @see 动态规划：基准状态有n=1、n=2两种状态，而n=3，可以划分为n=1的种类加上n=2的种类，以此类推
     */
    public static int solution(int n) {
        if (n < 1)
            return 0;
        if (n >= 1 && n <= 2)
            return n;
        else
            return solution(n - 1) + solution(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
}
