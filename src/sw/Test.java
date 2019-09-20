package sw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Test {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList();
        if (k > input.length)
            return list;
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        HashSet<Integer> hashSet = new HashSet();
        for (int i : array
        ) {
            hashSet.add(i);
        }
        for (int i : hashSet
        ) {
            System.out.println(i);
        }
    }

    public static void mystery(int x) {
        System.out.print(x % 10);

        if ((x / 10) != 0) {
            mystery(x / 10);
        }
        System.out.print(x % 10);
    }

    interface test {
        void hello();

        default void test() {
            System.out.println("Hello");
        }

        default void hhh() {
            System.out.println("jjjjjjjjjj");
        }

        static void hh() {
            System.out.println("gg");
        }
    }

    static class ff implements test {

        @Override
        public void hello() {
            System.out.println("World");
        }
    }


    public static void main(String[] args) {
//        int[] array = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
//        System.out.println("排序之前：");
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//        }
//        //希尔排序
//        int gap = array.length;
//        while (true) {
//            gap /= 2;   //增量每次减半
//            for (int i = 0; i < gap; i++) {
//                for (int j = i + gap; j < array.length; j += gap) {//这个循环里其实就是一个插入排序
//                    int temp = array[j];
//                    int k = j - gap;
//                    while (k >= 0 && array[k] > temp) {
//                        array[k + gap] = array[k];
//                        k -= gap;
//                    }
//                    array[k + gap] = temp;
//                }
//            }
//            if (gap == 1)
//                break;
//        }
//
//        System.out.println();
//        System.out.println("排序之后：");
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//        }

        //jdk1.8新特性，接口可以定义默认函数
        ff g = new ff();
        g.hello();
        g.hhh();
        test.hh();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(null, null);
        System.out.println(hashMap.get(null));
        hashMap.put(5, null);
        System.out.println(hashMap.get(5));

    }

}
