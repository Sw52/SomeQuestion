package sw.practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 最长递增子序列的个数 {
    /*
    问题描述：
    给定一个未排序的整数数组，找到最长递增子序列的个数。

    示例 1:

    输入: [1,3,5,4,7]
    输出: 2
    解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
    示例 2:

    输入: [2,2,2,2,2]
    输出: 5
    解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
    注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

     */
    public static int findNumberOfLIS(int[] nums) {
        if (nums.length <= 1)
            return nums.length;

        int[] db = new int[nums.length];//创建辅助数组
        int[] fu = new int[nums.length];
        Arrays.fill(db, 1);
        Arrays.fill(fu, 1);
        //遍历查找当前数字的最长子序列长度
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (db[j] + 1 > db[i]) {
                        db[i] = db[j] + 1;
                        fu[i] = fu[j];
                    } else if (db[j] + 1 == db[i]) {
                        fu[i] += fu[j];
                    }
                }
            }
        }

        int longest = 0, result = 0;
        for (int i : db) {
            longest = Math.max(longest, i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (fu[i] == longest) {
                result += fu[i];
            }
        }


        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new LinkedList<>();

        while (scanner.hasNextInt())
            list.add(scanner.nextInt());

        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        System.out.println(findNumberOfLIS(array));
    }
}
