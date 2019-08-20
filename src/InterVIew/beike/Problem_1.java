package InterVIew.beike;

import java.util.Scanner;

public class Problem_1 {
    /**
     * 时间限制：C/C++语言 1000MS；其他语言 3000MS
     * 内存限制：C/C++语言 131072KB；其他语言 655360KB
     * 题目描述：
     * 给出n个正整数，要求找出相邻两个数字中差的绝对值最小的一对数字，如果有差的绝对值相同的，则输出最前面的一对数。
     *
     * 2<n<=100，正整数都在10^16范围内
     *
     * 输入
     * 输入包含2行，第一行为n，第二行是n个用空格分隔的正整数。
     *
     * 输出
     * 输出包含一行两个正整数，要求按照原来的顺序输出
     *
     *
     * 样例输入
     * 9
     * 1 3 4 7 2 6 5 12 32
     * 样例输出
     * 3 4
     * @return
     */
    /*
    注意事项：
    1、注意输入数据的边界问题，选择使用long(输入的地方、缓存的地方、接收的地方)
    2、把输入放到主函数去做
     */
    public long[] findTwoNum(long[] array,int n) {
        if(array==null||n==0)
            return new long[]{};
        long[] result = new long[2];
        long dec =  Math.abs(array[0] - array[1]);
        result[0] = array[0];
        result[1] = array[1];
        for (int i = 0; i < array.length - 1; i++) {
            long temp = Math.abs(array[i] - array[i + 1]);
            if (temp < dec) {
                dec = temp;
                result[0] = array[i];
                result[1] = array[i + 1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem_1 problem_1 = new Problem_1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextLong();
        }
        long[] res = new long[2];
        res = problem_1.findTwoNum(array,n);
        System.out.println(res[0] + " " + res[1]);
    }
}
