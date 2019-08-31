package InterVIew.SF.Problem2;

import java.util.Arrays;
import java.util.Scanner;
/*
求最长上升子序列的个数
超时
 */
public class Main {

    public static int lengthOfLIS(int[] nums) {
        int[] db = new int[nums.length];
        Arrays.fill(db,1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j]<=nums[i])
                    db[i] = Math.max(db[i],db[j]+1);
            }
        }
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
