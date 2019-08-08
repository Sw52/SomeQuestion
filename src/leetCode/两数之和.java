package leetCode;

import java.lang.reflect.Array;
import java.util.*;

public class 两数之和 {

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twosum(int[] nums, int target) {
        int[] arr = new int[2];
        if (nums == null)
            return null;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    if (nums[i] + nums[j] == target) {
                        arr[0]=i;
                        arr[1]=j;
                    }
                }
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(两数之和.twosum(nums, target)));
    }
}
