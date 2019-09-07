package sw;

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

/****************************************************************************************************************/

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
/****************************************************************************************************************/

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
        if (array == null)
            return null;
        for (int i = 0; i < array.length; i++) {
            int IndexMin = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[IndexMin] > array[j]) {
                    IndexMin = j;
                }
            }
            if (IndexMin != i) {
                int temp = array[IndexMin];
                array[IndexMin] = array[i];
                array[i] = temp;
            }
        }
        return array;
    }

/****************************************************************************************************************/
    /**
     * @param array
     * @return
     * @see 插入排序
     * 时间复杂度：  平均时间复杂度：O(n2) 最好情况：O(n) 最坏情况：O(n2)
     * 空间复杂度：  O(1)
     * 稳定性：    稳定
     * 排序方式：   In-Place
     */
    public static int[] insertSort(int[] array) {
        int[] arrayCopy = Arrays.copyOf(array, array.length);
        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > array[i]) {
                    arrayCopy[j + 1] = arrayCopy[j];
                    if (j == 0)
                        arrayCopy[j] = array[i];
                } else if (array[j] <= array[i]) {
                    arrayCopy[j + 1] = array[i];
                    break;
                }
            }
            array = Arrays.copyOf(arrayCopy, arrayCopy.length); //注意这里不能直接等于，直接等于会把两个数组指向同一块内存
        }
        return arrayCopy;
    }
/****************************************************************************************************************/
    /**
     * @param array
     * @return
     * @see 堆排序
     * 时间复杂度：  平均时间复杂度：O(nlogn) 最好情况：O(nlogn) 最坏情况：O(nlogn)
     * 空间复杂度：  O(1)
     * 稳定性：    不稳定
     * 排序方式：   In-Place
     */
    public static int[] heapSort(int[] array) {
        int[] arr = Arrays.copyOf(array, array.length);
        int len = arr.length;
        buildMaxHeap(arr, len);
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            len--;
            heapify(arr, 0, len);
        }
        return arr;

    }

    public static void buildMaxHeap(int[] arr, int len) {
        //构造初始堆,从第一个非叶子节点开始调整,左右孩子节点中较大的交换到父节点中
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            //排序，将最大的节点放在堆尾，然后从根节点重新调整
            heapify(arr, i, len);
        }
    }

    public static void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, largest, len);
        }
    }

/****************************************************************************************************************/

    /**
     * @param indexLeft
     * @param indexRight
     * @param array
     * @see 快速排序
     * 时间复杂度：  平均时间复杂度：O(n2) 最好情况：O(n2) 最坏情况：O(n2)
     * 时间复杂度的分析：调用栈的高度平均为O(logn)，每层需要的时间为O(n)，故整体时间为O(n)*O(logn) = O(nlogn)
     * 空间复杂度：  O(1)
     * 稳定性：    不稳定
     * 排序方式：   In-Place
     * 思想：分治法（D&C：Divide and Conquer）
     */
    public static int[] quickSort(int indexLeft, int indexRight, int[] array) {
        if (array == null)  //判断输入合法性
            return null;
        if (indexLeft >= indexRight)    //递归边界（基线条件）
            return null;
        int left = indexLeft;   //设置左指针
        int right = indexRight - 1; //设置右指针(最右端为哨兵，哨兵的左边一个为右指针起始处)
        int key = array[indexRight];    //设置哨兵（采用排序子序列的最右边一个元素为哨兵）

        while (left <= right) {  //循环判断
            while (array[left] <= key && left <= right)  //在前半部分中查找比哨兵大的数并定位
                left++;
            while (array[right] >= key && left <= right) //在后半部分中查找比哨兵小的数并定位
                right--;
            if (left < right) { //将刚刚定位到的左边部分比哨兵大的那个数和右半部分比哨兵小的那个数进行交换
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        //将哨兵和指针相遇点的数据进行交换
        array[indexRight] = array[left];
        array[left] = key;

        //递归查找个子部分
        quickSort(indexLeft, left - 1, array);
        quickSort(left + 1, indexRight, array);
        return array;
    }
/****************************************************************************************************************/

    /**
     * 测试函数
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] array = {9, 5, 2, 4, 2, 1, 9, 8, 6};
        int[] arr = {1, 5, 3, 7, 9, 4, 5, 3, 2, 1, 5, 3, 4, 5};

//        //这是测试冒泡排序，如需测试其他排序的代码，记得注释掉以下测试代码
//        System.out.println(Arrays.toString(array));
//        System.out.println(Arrays.toString(bubbleSort(array)));
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(bubbleSort(arr)));

//        //这是测试选择排序，如需测试其他排序的代码，记得注释掉以下测试代码
//        System.out.println(Arrays.toString(array));
//        System.out.println(Arrays.toString(selectionSort(array)));

////        //这是测试插入排序，如需测试其他排序的代码，记得注释掉以下测试代码
//        System.out.println(Arrays.toString(array));
//        System.out.println(Arrays.toString(insertSort(array)));
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(insertSort(arr)));

//        //这是测试插入排序，如需测试其他排序的代码，记得注释掉以下测试代码
//        System.out.println(Arrays.toString(array));
//        System.out.println(Arrays.toString(heapSort(array)));
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(heapSort(arr)));

//        //这是测试快排，如需测试其他排序的代码，记得注释掉以下测试代码
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(quickSort(0, array.length - 1, array)));
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(quickSort(0, arr.length - 1, arr)));
        int[] array2 = {0, 1, 1, 1, 2, 3, 5, 5, 5, 12, 33, 112};
        System.out.println(Arrays.toString(quickSort(0,array2.length-1,array2)));
    }
}
