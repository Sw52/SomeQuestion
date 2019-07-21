package CodingInterview2;

public class Q10_Fibonacci {
    /**
     * @param n
     * @return 问题：递归消耗大，而且有很多的重复计算节点
     * @see 递归实现fibonacci数列
     */
    public static int fibonacci(int n) {
        int fibonacci_n = 0;
        if (n == 0)
            fibonacci_n = 0;
        else if (n == 1)
            fibonacci_n = 1;
        else if (n > 1)
            fibonacci_n = fibonacci(n - 1) + fibonacci(n - 2);
        return fibonacci_n;
    }

    /**
     * @see 优化算法
     * 优化思路：递归转换成循环
     * @param n
     * @return
     */
    public static int fibonacciOptimization(int n) {
        int[] result = {0, 1};
        if (n < 2) {
            return result[n];
        }

        int fibNMinusOne = 1;   //第n-1的值
        int fibNMinusTwo = 0;   //第n-2的值
        int fibN = 0;           //第n个的值
        for (int i = 2; i <= n; ++i) {
            fibN = fibNMinusOne + fibNMinusTwo; //第n个的值是第n-1的值加第n-2的值

            fibNMinusTwo = fibNMinusOne;    //更新n-1,n-2的值，往后移动一位。
            fibNMinusOne = fibN;
        }
        return fibN;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(0));
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(4));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(6));
        System.out.println(fibonacci(7));
        System.out.println(fibonacci(8));
        System.out.println(fibonacci(9));
        System.out.println(fibonacci(10));


        System.out.println(fibonacciOptimization(0));
        System.out.println(fibonacciOptimization(1));
        System.out.println(fibonacciOptimization(2));
        System.out.println(fibonacciOptimization(3));
        System.out.println(fibonacciOptimization(4));
        System.out.println(fibonacciOptimization(5));
        System.out.println(fibonacciOptimization(6));
        System.out.println(fibonacciOptimization(7));
        System.out.println(fibonacciOptimization(9));
        System.out.println(fibonacciOptimization(10));
    }
}
