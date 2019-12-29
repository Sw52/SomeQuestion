package CodingInterview;

import java.util.HashMap;

public class Q10_斐波那契数列 {
    /**
     * @param n
     * @return 问题：递归消耗大，而且有很多的重复计算节点
     * @author sw
     * @see 递归实现fibonacci数列
     * 分析：采用递归时间复杂度高，空间复杂度
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
     * @param hashMap
     * @return 分析：采用备忘录算法时间复杂度低，但空间复杂度高
     * @see 备忘录算法实现斐波那契数列
     */
    public static int fibonacciMemorandum(int n, HashMap<Integer, Integer> hashMap) {
        if (n < 1)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;
        if (hashMap.containsKey(n))
            return hashMap.get(n);
        else {
            hashMap.put(n, fibonacciMemorandum(n - 1, hashMap) + fibonacciMemorandum(n - 2, hashMap));
            return fibonacciMemorandum(n - 1, hashMap) + fibonacciMemorandum(n - 2, hashMap);
        }
    }

    /**
     * @param n
     * @return
     * @author sw
     * @see 优化算法
     * 优化思路：递归转换成循环
     * 分析：采用循环动态规划法，时间复杂度低，空间复杂度低
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
     *
     * @param args
     * @author sw
     * 思路：动态规划的思想，跳上第N阶台阶的方式有两种，即从n-1跳上去或者从n-2跳上去，
     * 故，可以推算出如下的递推公式：f(n) = f(n-1) + f(n-2)
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

        //备忘录算法实现斐波那契数列
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        System.out.println(fibonacciMemorandum(0, hashMap));
        System.out.println(fibonacciMemorandum(1, hashMap));
        System.out.println(fibonacciMemorandum(2, hashMap));
        System.out.println(fibonacciMemorandum(3, hashMap));
        System.out.println(fibonacciMemorandum(4, hashMap));
        System.out.println(fibonacciMemorandum(5, hashMap));
        System.out.println(fibonacciMemorandum(6, hashMap));
        System.out.println(fibonacciMemorandum(7, hashMap));
        System.out.println(fibonacciMemorandum(8, hashMap));
        System.out.println(fibonacciMemorandum(9, hashMap));
        System.out.println(fibonacciMemorandum(10, hashMap));

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
