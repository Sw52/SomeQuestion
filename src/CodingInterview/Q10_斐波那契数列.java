package CodingInterview;

public class Q10_斐波那契数列 {
    /**
     * @param n
     * @return 问题：递归消耗大，而且有很多的重复计算节点
     * @author sw
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
     * @param n
     * @return
     * @author sw
     * @see 优化算法
     * 优化思路：递归转换成循环
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

    /**
     * 问题衍生：青蛙跳台阶问题：
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个n级台阶共有多少种跳法
     * @param args
     * @author sw
     */
    /**
     * 问题衍生：青蛙跳台阶问题：
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个n级台阶共有多少种跳法
     *
     * @param target
     * @return
     */
    public static int jumpFloor(int target) {
        int[] result = {0, 1, 2};

        if (target < 3) {
            return result[target];
        }

        int fibNMinusOne = 2;   //第n-1的值
        int fibNMinusTwo = 1;   //第n-2的值
        int fibN = 0;           //第n个的值
        for (int i = 3; i <= target; ++i) {
            fibN = fibNMinusOne + fibNMinusTwo; //第n个的值是第n-1的值加第n-2的值

            fibNMinusTwo = fibNMinusOne;    //更新n-1,n-2的值，往后移动一位。
            fibNMinusOne = fibN;
        }
        return fibN;
    }

    /**
     * 问题衍生：变态青蛙跳台阶问题：
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶,也可以一次跳3级台阶。。。。。。求该青蛙跳上一个n级台阶共有多少种跳法
     *
     * @param target
     * @return
     */
    public static int jupFloorPlus(int target) {

        if (target == 0) {
            return 0;
        } else {
            return (int) Math.pow(2, target - 1);
        }

    }


    public static void main(String[] args) {
        //递归实现斐波那契
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

        //循环实现斐波那契
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

        //青蛙跳台阶问题
        System.out.println(jumpFloor(0));
        System.out.println(jumpFloor(1));
        System.out.println(jumpFloor(2));
        System.out.println(jumpFloor(3));
        System.out.println(jumpFloor(4));
        System.out.println(jumpFloor(5));
        System.out.println(jumpFloor(6));
        System.out.println(jumpFloor(7));

        //变态青蛙跳台阶问题
        System.out.println(jupFloorPlus(0));
        System.out.println(jupFloorPlus(1));
        System.out.println(jupFloorPlus(2));
        System.out.println(jupFloorPlus(3));
        System.out.println(jupFloorPlus(4));
        System.out.println(jupFloorPlus(5));
        System.out.println(jupFloorPlus(6));

    }
}
