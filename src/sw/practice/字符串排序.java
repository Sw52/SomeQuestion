package sw.practice;

import java.util.Arrays;

public class 字符串排序 {
    /**
     * @param strings
     * @return
     * @see 对字符串进行排序
     */
    public static String[] stringSort(String[] strings) {
        return stringSort(strings, 0, strings.length - 1);
    }

    /**
     * 对字符串进行排序，采用快速排序
     *
     * @param strings
     * @param indexLeft
     * @param indexRight
     * @return
     */
    public static String[] stringSort(String[] strings, int indexLeft, int indexRight) {
        if (strings == null)  //判断输入合法性
            return null;
        if (indexLeft >= indexRight)    //递归边界（基线条件）
            return null;
        int left = indexLeft;   //设置左指针
        int right = indexRight - 1; //设置右指针(最右端为哨兵，哨兵的左边一个为右指针起始处)
        String key = strings[indexRight];    //设置哨兵（采用排序子序列的最右边一个元素为哨兵）

        while (left <= right) {  //循环判断
            while (strings[left].charAt(0) <= key.charAt(0) && left <= right)  //在前半部分中查找比哨兵大的数并定位
                left++;
            while (strings[right].charAt(0) >= key.charAt(0) && left <= right) //在后半部分中查找比哨兵小的数并定位
                right--;
            if (left < right) { //将刚刚定位到的左边部分比哨兵大的那个数和右半部分比哨兵小的那个数进行交换
                String temp = strings[left];
                strings[left] = strings[right];
                strings[right] = temp;
            }
        }
        //将哨兵和指针相遇点的数据进行交换
        strings[indexRight] = strings[left];
        strings[left] = key;

        //递归查找个子部分
        stringSort(strings, indexLeft, left - 1);
        stringSort(strings, left + 1, indexRight);
        return strings;
    }

    public static void main(String[] args) {
        String[] strings = {"abc", "fb", "zvb", "fgd", "gff", "dd", "kkk"};
        System.out.println(Arrays.toString(strings));
        System.out.println(Arrays.toString(stringSort(strings)));
    }
}
