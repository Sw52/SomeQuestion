package Kdxf.Problem2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int binarySearch(int[] array, int target, int indexStart, int indexEnd) {
        if (indexStart > indexEnd)
            return -1;
        int mid = (indexStart + indexEnd) / 2;
        if (array[mid] == target)
            return mid+1;
        if (array[mid] > target)
            return binarySearch(array, target, indexStart, mid - 1);
        if (array[mid] < target)
            return binarySearch(array, target, mid + 1, indexEnd);

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {11,13,15,17,19,21};
        System.out.println(binarySearch(arr,19,0,arr.length-1));
    }
}
