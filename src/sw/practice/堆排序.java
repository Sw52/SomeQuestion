package sw.practice;

import java.util.Arrays;

public class 堆排序 {
    /*
    问题描述：
    输入一个无序数组，输出数组中前K大数字或第K大数字
     */
    public int[] heapSort(int[] array) {
        int len = array.length;
        buildMinHeap(array,len);    //创建原始小顶堆
        for (int i = array.length - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            len--;
            heapify(array,0,len);
        }
        return array;
    }

    /**
     * 构建一颗小顶堆
     *
     * @param array
     */
    private void buildMinHeap(int[] array, int len) {
        //从最后一个非叶子节点开始调整
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(array, i, len); //构建小顶堆
        }
    }

    /**
     * @param array
     * @param i
     * @see 小顶堆
     */
    private void heapify(int[] array, int i, int len) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int miniest = i;
        if (left < len && array[left] < array[miniest]) {
            miniest = left;
        }
        if (right < len && array[right] < array[miniest]) {
            miniest = right;
        }
        if (miniest != i) {
            int temp = array[i];
            array[i] = array[miniest];
            array[miniest] = temp;
            heapify(array, miniest, len);
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 2, 4, 2, 1, 9, 8, 6};
        int[] arr = {1, 5, 3, 7, 9, 4, 5, 3, 2, 1, 5, 3, 4, 5};


        堆排序 heap = new 堆排序();

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(heap.heapSort(array)));
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(heap.heapSort(arr)));
    }

}
