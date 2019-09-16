package sw.practice;

public class TopK问题 {
    /*
    问题描述：
    输入一个无序数组，输出数组中前K大数字或第K大数字
     */

    /**
     * @param array
     * @param k
     * @return
     * @see 查找数组中前K大个数
     * 思路：采用堆排序输出前K大个数
     */
    public int[] topK(int[] array, int k) {
        int len = array.length;
        buildMaxHeap(array, len);    //创建原始大顶堆
        for (int i = array.length - 1; i > array.length - k - 1; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            len--;
            heapify(array, 0, len);
            System.out.println(array[len]);

        }
        return array;
    }

    /**
     * 构建一颗da顶堆
     *
     * @param array
     */
    private void buildMaxHeap(int[] array, int len) {
        //从最后一个非叶子节点开始调整，第一个非叶子节点为array[Math.floor(len / 2)]
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(array, i, len); //维护大顶堆
        }
    }

    /**
     * @param array
     * @param i
     * @see 维护大顶堆
     */
    private void heapify(int[] array, int i, int len) {
        int left = i * 2 + 1;   //左儿子节点
        int right = i * 2 + 2;  //右儿子节点
        int largest = i;
        if (left < len && array[left] > array[largest]) {   //如果左儿子节点大于父节点
            largest = left;
        }
        if (right < len && array[right] > array[largest]) { //如果右儿子节点大于父节点
            largest = right;
        }
        if (largest != i) {     //如果儿子节点大于父节点，则把其中较大的儿子与父节点进行交换
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array, largest, len);
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 2, 4, 2, 1, 9, 8, 6};
        int[] arr = {1, 5, 3, 7, 9, 4, 5, 3, 2, 1, 5, 3, 4, 5};


        TopK问题 topK = new TopK问题();

        topK.topK(array, 3);
//        System.out.println(Arrays.toString(array));
//        System.out.println(Arrays.toString(topK.topK(array)));
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(topK.topK(arr)));
    }

}
