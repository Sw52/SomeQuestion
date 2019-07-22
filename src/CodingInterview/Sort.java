package CodingInterview;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

import java.util.Arrays;

/*
一些经典的排序算法
+----------------------------------------------------------------------------+
排序算法    平均时间复杂度     最好情况    最坏情况    空间复杂度   排序方式    稳定性
+----------------------------------------------------------------------------+
冒泡排序    O(n2)           O(n)        O(n2)     O(1)       In-Place   稳定
选择排序    O(n2)           O(n2)       O(n2)     O(1)       In-Place   不稳定
插入排序    O(n2)           O(n)        O(n2)     O(1)       In-Place   稳定
希尔排序    O(nlogn)        O(nlog2n)   O(nlog2n) O(1)       In-Place   不稳定
归并排序    O(nlogn)        O(nlogn)    O(nlogn)  O(n)       Out-Place  稳定
快速排序    O(nlogn)        O(nlogn)    O(n2)     O(logn)    In-Place   不稳定
堆排序      O(nlogn)        O(nlogn)    O(nlogn)  O(1)       In-Place   不稳定
计数排序    O(n+k)          O(n+k)      O(n+k)    O(k)       Out-Place  稳定
桶排序      O(n+k)          O(n+k)      O(n2)     O(n+k)     Out-Place  稳定
基数排序    O(nxk)          O(nxk)      O(nxk)    O(n+k)     Out-Place  稳定
+----------------------------------------------------------------------------+

 */
public class Sort {


    /**
     * @see 冒泡排序
     * 性能分析：
     *  时间复杂度：  平均时间复杂度：O(n2) 最好情况：O(n) 最坏情况：O(n2)
     *  空间复杂度：  O(1)
     *  稳定性：    稳定
     *  排序方式：   In-Place
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[]array){
        for(int i = 1;i<array.length;i++){
            for(int j =0;j<array.length-i;j++){
                if(array[j]>array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
        return array;
    }

    /**
     * @see 选择排序
     *  时间复杂度：  平均时间复杂度：O(n2) 最好情况：O(n2) 最坏情况：O(n2)
     *  空间复杂度：  O(1)
     *  稳定性：    不稳定
     *  排序方式：   In-Place
     * @param array
     * @return
     */
    public static int[] selectionSort(int[]array){
        for(int i=0;i<array.length-1;i++){
            int indexMin = i;
            for(int j = i+1;j<array.length;j++){
                if(array[j]<array[indexMin]){
                    indexMin = j;
                }
            }
            if(indexMin!=i){
                int tmp = array[i];
                array[i] = array[indexMin];
                array[indexMin] = tmp;
            }
        }
        return array;
    }

    /**
     * 测试函数
     * @param args
     */
    public static void main(String[] args) {

        int[] array = {1,5,2,3,8,6};
        System.out.println(Arrays.toString(bubbleSort(array)));
        System.out.println(Arrays.toString(selectionSort(array)));

    }
}
