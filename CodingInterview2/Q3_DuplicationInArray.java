package CodingInterview2;

import java.util.Arrays;

public class Q3_DuplicationInArray {

    /**
     * @param array
     * @return
     * @author sw
     * @see 问题描述：
     * <p>
     * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字是重复的。
     * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
     * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
     */
    public static int findDuplicationNumber(int[] array) {
        if (array != null) {    //数组判空
            Arrays.sort(array);     //对数组进行排序
            System.out.println(Arrays.toString(array));
            for (int i = 0; i < array.length; i++) {    //遍历数组
                if (array[i] == array[i + 1]) {     //如果第i个数字和第i+1个数组相同则发现相同数字
                    return array[i];    //返回查找到的第一个重复数字
                }
            }
        }

        return 0;
    }

    /**
     * @param numbers
     * @param length
     * @param duplication
     * @return
     * @see 此题的具体要求见牛客网：
     * url: https://www.nowcoder.com/practice/623a5ac0ea5b4e5f95552655361ae0a8?tpId=13&tqId=11203&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tPage=3
     */
    public static boolean findDuplicationNumber(int[] numbers, int length, int[] duplication) {

        if (numbers != null || length <= 0) {   //判断输入是否合法
            Arrays.sort(numbers);   //数组排序
            for (int i = 0; i < length - 1; i++) {  //遍历数组，注意边界条件
                if (numbers[i] == numbers[i + 1]) {     //第i个位置的数字和第i+1个位置的数字相同
                    duplication[0] = numbers[i];    //记录
                    return true;
                }
            }
        }
        duplication[0] = -1;

        return false;
    }


    public static void main(String[] args) {
        int[] array = {1, 5, 4, 3, 2, 1, 5, 1, 15, 12, 5, 13, 5, 22, 5, 5};
        System.out.println(findDuplicationNumber(array));
        int[] arr1 = null;  //数组空测试
        int[] b = new int[2];
        System.out.println(findDuplicationNumber(arr1, 5, b));
        System.out.println(b[0]);
    }
}
