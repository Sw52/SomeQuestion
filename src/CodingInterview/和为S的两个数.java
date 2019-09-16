package CodingInterview;

import java.util.ArrayList;
import java.util.HashMap;

public class 和为S的两个数 {
    /**
     * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
     * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
     * @param array
     * @param sum
     * @return
     */
    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            hashMap.put(array[i], array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            if (hashMap.containsKey(sum - array[i])) {
                arrayList.add(array[i]);
                arrayList.add(hashMap.get(sum - array[i]));
            }
        }
        ArrayList<Integer> result = new ArrayList<>(2);
        if (arrayList.size() < 2)
            return result;
        int j = 0;
        int k = 0;
        j = arrayList.get(0);
        k = arrayList.get(1);
        int temp = j * k;
        result.add(Math.min(j, k));
        result.add(Math.max(j, k));
        for (int i = 2; i < arrayList.size(); i += 2) {
            j = arrayList.get(i);
            k = arrayList.get(i + 1);
            if (j * k < temp) {
                temp = j * k;
                result.add(Math.min(arrayList.get(i), arrayList.get(i + 1)));
                result.add(Math.max(arrayList.get(i), arrayList.get(i + 1)));
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9,10};
        System.out.println(FindNumbersWithSum(arr,10));
    }
}
