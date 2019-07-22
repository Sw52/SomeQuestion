package CodingInterview;

public class Q11_MinNumberInRotatedArray {

    /**
     * 顺序查找函数
     *
     * @param array
     * @return
     */
    public static int findInorder(int[] array) {
        int result = array[0];
        for (int i = 0; i < array.length; ++i) {
            if (result > array[i])
                result = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array1 = {3, 4, 5, 1, 2};
        int[] array2 = {1, 2, 3, 4, 5};
        int[] array3 = {1, 0, 1, 1, 1};
        int[] array4 = {1, 1, 1, 0, 1};

        Q11_MinNumberInRotatedArray q11_minNumberInRotatedArray = new Q11_MinNumberInRotatedArray();

        System.out.println(q11_minNumberInRotatedArray.minNumberInRotateArray(array1));
        System.out.println(q11_minNumberInRotatedArray.minNumberInRotateArray(array2));
        System.out.println(q11_minNumberInRotatedArray.minNumberInRotateArray(array3));
        System.out.println(q11_minNumberInRotatedArray.minNumberInRotateArray(array4));

    }

    /**
     * 问题描述：
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0
     *
     * @param array
     * @return 分析：该数组可能出现三种情况：
     * 1、确实发生了旋转，并且数组数字不重复：则array[0]>array[array.length-1]
     * 2、没有发生旋转，，并且数组数字不重复：旋转的个数为零，此时array[0] 即为最小数
     * 3、数组有重复数字，array[index1]==array[index2]&&array[indexMid]==array[index2]，此时只能用顺序遍历来查找最小值
     */

    public int minNumberInRotateArray(int[] array) {

        if (array == null)
            return 0;

        int index1 = 0;
        int index2 = array.length - 1;
        int indexMid = index1;
        while (array[index1] >= array[index2]) {
            if (index2 - index1 == 1) { //找到边界
                indexMid = index2;
                break;
            }
            indexMid = (index1 + index2) / 2;
            if (array[index1] == array[index2] && array[indexMid] == array[index2]) { //数组有重复数字
                return findInorder(array);
            }
            if (array[indexMid] >= array[index1]) {
                index1 = indexMid;
            } else if (array[indexMid] <= array[index2]) {
                index2 = indexMid;
            }
        }
        return array[indexMid];
    }
}
