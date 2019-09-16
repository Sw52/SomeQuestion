package sw.practice;

import java.util.Arrays;
import java.util.HashMap;

public class 两数之和 {
    /*
    问题描述：
    给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

    你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

    示例:

    给定 nums = [2, 7, 11, 15], target = 9

    因为 nums[0] + nums[1] = 2 + 7 = 9
    所以返回 [0, 1]

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/two-sum
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * @param arr
     * @param target
     * @return
     * @see 方法一：暴力求解
     * 遍历两边数组，时间复杂度O(n^2)空间复杂度O(1)
     */
    public static int[] solution_1(int[] arr, int target) {
        int[] result = new int[2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length && i != j; j++) {
                if (arr[i] + arr[j] == target) {
                    result[0] = Math.min(i, j);
                    result[1] = Math.max(i, j);
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * @param arr
     * @param target
     * @return
     * @see 方法二：遍历两遍hash表
     * 利用hash查找为O(1)的优势
     * 时间复杂度O(n)，空间复杂度O(n)
     */
    public static int[] solution_2(int[] arr, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hashMap.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (hashMap.containsKey(complement) && hashMap.get(complement) != i) {
                result[0] = Math.min(hashMap.get(complement), i);
                result[1] = Math.max(hashMap.get(complement), i);
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        //System.out.println(Arrays.toString(solution_1(nums,target)));
        System.out.println(Arrays.toString(solution_2(nums, target)));
    }
}
