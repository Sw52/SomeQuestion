package CodingInterview;

public class Q14_剪绳子 {

    /**
     * 问题描述
     * 题目：一段长度为n的绳子，把绳子剪成m段（m、n都是整数且n>1、m>1），
     * 每段绳子的长度标记为k[0]、k[1]、k[2]...k[m]。请问k[0] x k[1] x k[2] x...x k[m]，
     * 可能的最大乘积
     * @param length
     * @return
     */
    public static int maxProductAfterCutting(int length) {
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;

        int[] products = new int[length + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;
        for (int i = 4; i <= length; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; ++j) {
                int protect = products[j] * products[i - j];
                if (max < protect)
                    max = protect;
                products[i] = max;
            }
        }

        max = products[length];

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProductAfterCutting(5));
    }
}
