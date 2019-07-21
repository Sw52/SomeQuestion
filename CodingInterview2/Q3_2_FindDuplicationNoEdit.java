package CodingInterview2;

public class Q3_2_FindDuplicationNoEdit {


    /**
     * @param numbers 一个整数数
     * @param length  数组的长
     * @return 正数  - 输入有效，并且数组中存在重复的数字，返回值为重复的数字
     * 负数  - 输入无效，或者数组中没有重复的数
     * @author sw
     * @analysis 利用二分法查找重复数字
     * @thoyght 统计二分思想
     * @see 问题描述：不修改数组找出重复的数字
     * 题目：在一个长度为n+1的数组里的所有数字都在1到n的范围内，所以数组中至
     * 少有一个数字是重复的。请找出数组中任意一个重复的数字，但不能修改输入的
     * 数组。例如，如果输入长度为8的数组{2, 3, 5, 4, 3, 2, 6, 7}，那么对应的
     * 输出是重复的数字2或者3
     */
    public static int getDuplication(int[] numbers, int length) {
        if (numbers == null || length <= 0) {
            return -1;
        }

        int start = 1;
        int end = length - 1;

        while (end >= start) {

            int middle = ((end - start) >> 1) + start;
            //System.out.println(start+"  "+middle+"  "+end); //打印每一轮的边界，分析用

            /**
             * 二分的逻辑：
             *  以长度为8的数组{2,3,5,4,3,22,6,7}为例，根据题目要求这个长度
             *  为8的数组，所有数字应该都在1～7范围内，中间的数组4把这个数组分为两段
             *  一段是1~4，另一段是5~7；接下来要做的就是统计1~4这个4个数字在数组中出现的次数，
             *  它们一共出现了5次，因此这4个数字中一定有重复的数字。
             *  这种算法是典型的以时间换空间
             */
            int count = countRange(numbers, length, start, middle);

            if (end == start) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            if (count > (middle - start + 1)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    static int countRange(int[] numbers, int legth, int start, int end) {
        if (numbers == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < legth; i++) {
            if (numbers[i] >= start && numbers[i] <= end) {
                ++count;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println(getDuplication(arr, 8));
    }
}
