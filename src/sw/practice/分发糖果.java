package sw.practice;

import java.util.Arrays;
import java.util.Scanner;

public class 分发糖果 {
/*
问题描述：
老师给站成一列的小伙伴们分饼干，需要按照一定的规则：小伙伴们都有自己的积分儿，每个小伙伴如果积分比左右相邻的人多，则被分配的饼干一定比左右相邻的多；反之则比左右相邻的小伙伴少；问老师最少分配多少块饼干能达到要求？例子如下：
1
2
3
4
输入
小伙伴们人数及每个人的积分：
6
3 6 3 5 6 2
1
2
3
输出
老师需要分配的最少饼干：10
按照顺序每人分配：1 2 1 2 3 1
解释：1 + 2 + 1 + 2 + 3 + 1 = 10
1
2
3
4
输入
小伙伴们人数及每个人的积分：
10
2 4 2 6 1 7 8 9 2 1
1
2
3
输出
老师需要分配的最少饼干：19
按照顺序每人分配：1 2 1 2 1 2 3 4 2 1
解释：1 + 2 + 1 + 2 + 1 + 2 + 3 + 4 + 2 + 1 = 19
 */

    /**
     * @param arr
     * @return
     * @author SwYoung
     * @see 暴力解决
     * 思路：先分配一个记录各同学糖果数的数组，先给每个人一颗糖果，
     * 再从后往前遍历看是否满足约束条件，不满足则调整，直到数组不在变化
     */
    public static int solution(int[] arr) {
        if (arr == null || arr.length < 1)
            return 0;
        if (arr.length == 1)
            return 1;
        int[] result = new int[arr.length];
        Arrays.fill(result, 1);
        boolean falg = true;
        while (falg) {
            falg = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1] && result[i] <= result[i + 1]) {
                    result[i] = result[i + 1] + 1;
                    falg = true;
                }
            }
            for (int i = arr.length - 1; i > 0; i--) {
                if (arr[i] > arr[i - 1] && result[i] <= result[i - 1]) {
                    result[i] = result[i - 1] + 1;
                    falg = true;
                }
            }
        }
        int res = 0;
        for (int i : result
        ) {
            res += i;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solution(arr));
    }
}