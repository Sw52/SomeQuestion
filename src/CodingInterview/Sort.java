package CodingInterview;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

import java.sql.DataTruncation;
import java.util.Arrays;

/*
一些经典的排序算法
+-----------------------------------------------------------------------------------+
|排序算法	平均时间复杂度	最好情况		最坏情况	  空间复杂度	    排序方式		稳定性	|
+-----------------------------------------------------------------------------------+
|冒泡排序    O(n2)           O(n)        O(n2)     O(1)       	In-Place   	稳定		|
|选择排序    O(n2)           O(n2)       O(n2)     O(1)       	In-Place   	不稳定	|
|插入排序    O(n2)           O(n)        O(n2)     O(1)       	In-Place   	稳定		|
|希尔排序    O(nlogn)        O(nlog2n)   O(nlog2n) O(1)       	In-Place   	不稳定	|
|归并排序    O(nlogn)        O(nlogn)    O(nlogn)  O(n)       	Out-Place  	稳定		|
|快速排序    O(nlogn)        O(nlogn)    O(n2)     O(logn)    	In-Place   	不稳定	|
|堆排序      O(nlogn)        O(nlogn)    O(nlogn)  O(1)       	In-Place   	不稳定	|
|计数排序    O(n+k)          O(n+k)      O(n+k)    O(k)       	Out-Place  	稳定		|
|桶排序      O(n+k)          O(n+k)      O(n2)     O(n+k)     	Out-Place  	稳定		|
|基数排序    O(nxk)          O(nxk)      O(nxk)    O(n+k)     	Out-Place  	稳定		|
+-----------------------------------------------------------------------------------+

注：排序的稳定性
排序的稳定性,就是指,在对a关键字排序后会不会改变其他关键字的顺序。
比如排序（2，3，1（第一个），1（第二个），5，6）
不稳定的排序，可能会排出
（1（第二个），1（第一个），2，3，5，6）；
而稳定的排序则不会，在比较的关键字相同的情况下，稳定的排序会将较早出现的元素排在前面。

 */
public class Sort {


    /**
     * @param array
     * @return
     * @see 冒泡排序
     * 性能分析：
     * 时间复杂度：  平均时间复杂度：O(nlogn) 最好情况：O(nlogn) 最坏情况：O(n2)
     * 空间复杂度：  O(1)
     * 稳定性：    稳定
     * 排序方式：   In-Place
     */
    public static int[] bubbleSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }

    /**
     * @param array
     * @return
     * @see 选择排序
     * 时间复杂度：  平均时间复杂度：O(n2) 最好情况：O(n2) 最坏情况：O(n2)
     * 空间复杂度：  O(logn)
     * 稳定性：    不稳定
     * 排序方式：   In-Place
     */
    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int indexMin = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[indexMin]) {
                    indexMin = j;
                }
            }
            if (indexMin != i) {
                int tmp = array[i];
                array[i] = array[indexMin];
                array[indexMin] = tmp;
            }
        }
        return array;
    }

    /**
     * @param indexLeft
     * @param indexRight
     * @param array
     * @see 快速排序
     * 时间复杂度：  平均时间复杂度：O(n2) 最好情况：O(n2) 最坏情况：O(n2)
     * 空间复杂度：  O(1)
     * 稳定性：    不稳定
     * 排序方式：   In-Place
     */
    public static int[] quickSort(int indexLeft, int indexRight, int[] array) {
        if (array == null)  //判断输入合法性
            return null;
        if (indexLeft >= indexRight)    //递归边界
            return null;
        int left = indexLeft;   //设置左指针
        int right = indexRight; //设置优指针
        int key = array[indexRight];    //设置哨兵（采用排序子序列的最右边一个元素为哨兵）

        while (left < right) {  //循环判断
            while (array[left] <= key && left < right)  //在前半部分中查找比哨兵大的数并定位
                left++;
            while (array[right] >= key && left < right) //在后半部分中查找比哨兵小的数并定位
                right--;
            if (left < right) { //将刚刚定位到的左边部分比哨兵大的那个数和右半部分比哨兵小的那个数进行交换
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        //将哨兵和指针相遇点的数据进行交换
        array[indexRight] = array[right];
        array[right] = key;

        //递归查找个子部分
        quickSort(indexLeft, left - 1, array);
        quickSort(left + 1, indexRight, array);
        return array;
    }


    /**
     * 测试函数
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] array = {9, 5, 2, 4, 2, 1, 9, 8, 6};

        //这是测试快排，如需测试其他排序的代码，记得注释掉以下测试代码
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(quickSort(0, array.length - 1, array)));

    }
}
