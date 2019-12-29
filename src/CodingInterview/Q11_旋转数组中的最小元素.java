package CodingInterview;

public class Q11_旋转数组中的最小元素 {

    /**
     * 顺序查找函数
     *
     * @param array
     * @return
     */
    public static int findInorder(int[] array) {
        int result = array[0];
        for (int i = 0; i < array.length; ++i) {
            result = Math.min(array[i], result);
        }
        return result;
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

        if (array == null)  //输入非法
            return -1;
        int indexLeft = 0;                 //左边界
        int indexRight = array.length - 1;  //右边界
        int indexMid = indexLeft;
        while (array[indexLeft] >= array[indexRight]) {    //判断该序列是否真的满足旋转序列（如果真的旋转，则队首元素一定大于队尾元素）
            if (indexRight - indexLeft == 1) { //找到边界，即左指针指向序列最大值，而右指针指向序列最小值
                indexMid = indexRight;
                break;
            }
            indexMid = (indexLeft + indexRight) / 2;
            if (array[indexLeft] == array[indexRight] && array[indexMid] == array[indexRight]) { //数组有重复数字，二分方法已经不再适用，采用查找法
                return findInorder(array);
            }
            if (array[indexMid] >= array[indexLeft]) {          //中间值大于左边界值
                indexLeft = indexMid;                           //更新左边界
            } else if (array[indexMid] <= array[indexRight]) {  //中间值小于右边界
                indexRight = indexMid;                          //更新右边界
            }
        }
        return array[indexMid];
    }

    public static void main(String[] args) {
        int[] array1 = {3, 4, 5, 1, 2};
        int[] array2 = {1, 2, 3, 4, 5};
        int[] array3 = {1, 0, 1, 1, 1};
        int[] array4 = {1, 1, 1, 0, 1};

        Q11_旋转数组中的最小元素 q11_minNumberInRotatedArray = new Q11_旋转数组中的最小元素();
        //顺序查找
        System.out.println(findInorder(array1));
        System.out.println(findInorder(array2));
        System.out.println(findInorder(array3));
        System.out.println(findInorder(array4));
        //二分查找
        System.out.println(q11_minNumberInRotatedArray.minNumberInRotateArray(array1));
        System.out.println(q11_minNumberInRotatedArray.minNumberInRotateArray(array2));
        System.out.println(q11_minNumberInRotatedArray.minNumberInRotateArray(array3));
        System.out.println(q11_minNumberInRotatedArray.minNumberInRotateArray(array4));

    }


}
