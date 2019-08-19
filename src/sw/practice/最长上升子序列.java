package sw.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 最长上升子序列 {
/*
题目描述：
给定一个无序的整数数组，找到其中最长上升子序列的长度。
示例:

输入: [10,9,2,5,3,7,101,18]
输出: 4
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
说明:

可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
你算法的时间复杂度应该为 O(n2) 。
进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

    /**
     * @see 求最长子序列的长度
     * 思路：动态规划：设置一个辅助数组，用于存储对应位原数组的数字的最长子序列长度（初始化为1）
     * 依次遍历数组，当前位置数字的最长上升子序列的长度为Max(1,他之前比他小的数字中有最长子序列长度)
     * @param nums
     * @return
     */
    public static  int lengthOfLIS(int[] nums) {
        int[] db = new int[nums.length];//创建辅助数组
        for (int i = 0; i < nums.length; i++) {
            db[i] = 1;
        }

        //遍历查找当前数字的最长子序列长度
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j]<nums[i])
                    db[i] = Math.max(db[i],db[j]+1);
            }
        }
        //计算输出值，注意这里让result的初始值为0可以使输入为空时输出为0
        int result = 0;
        for (int i = 0; i < db.length; i++) {
            result = Math.max(result,db[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println(lengthOfLIS(array));
    }
}
