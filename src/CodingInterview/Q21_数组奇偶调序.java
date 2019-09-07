package CodingInterview;

import java.util.Arrays;

public class Q21_数组奇偶调序 {

    /**
     * 问题描述：
     * 输入一个整数数组，实现一个函数来调整数组中数字的顺序，
     * 使得所有奇数位位于数组的前半部分，所有的偶数位位于数组的后半部分。
     *
     * @param array 思路：设置两个指针一个从前往后查找偶数，一个从后往前查找奇数，然后交换
     */
    public static void reorderOddEven(int[] array) {
        if (array == null)
            return;

        int indexStart = 0;
        int indexEnd = array.length - 1;
        while (indexStart < indexEnd) {
            while (indexStart < indexEnd && (array[indexStart] & 0x01) != 0)
                indexStart++;
            while (indexStart < indexEnd && (array[indexEnd] & 0x01) == 0)
                indexEnd--;
            if (indexStart < indexEnd) {
                int tmp = array[indexStart];
                array[indexStart] = array[indexEnd];
                array[indexEnd] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        reorderOddEven(array);
        System.out.println(Arrays.toString(array));
        short s = 16;
    }


}
