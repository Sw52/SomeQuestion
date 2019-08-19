package beike;

import java.util.Arrays;
import java.util.Scanner;

public class Problem_3 {
    /**
     题目：
     * 时间限制：C/C++语言 1000MS；其他语言 3000MS
     * 内存限制：C/C++语言 131072KB；其他语言 655360KB
     * 题目描述：
     * 举重大赛开始了，为了保证公平，要求比赛的双方体重较小值要大于等于较大值的90%，那么对于这N个人最多能进行多少场比赛呢，任意两人之间最多进行一场比赛。
     * 输入
     * 第一行N，表示参赛人数（2<=N<=10^5）
     *
     * 第二行N个正整数表示体重（0<体重<=10^8）
     *
     * 输出
     * 一个数，表示最多能进行的比赛场数
     *
     *
     * 样例输入
     * 5
     * 1 1 1 1 1
     * 样例输出
     * 10
     *
     * 思路：先排序数组可以提高运行时间
     * @param nums
     * @param n
     * @return
     */
    public static int count(long[] nums,int n) {
        if(nums == null || nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < n-1; i++) {
            for(int j = i+1; j < n; j++) {
                if(nums[j] <= (nums[i]*10/9)){
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] array = new long[n];
        for(int i=0;i<n;i++){
            array[i] = sc.nextLong();
        }
        int num = count(array,n);
        System.out.println(num);
    }
}
