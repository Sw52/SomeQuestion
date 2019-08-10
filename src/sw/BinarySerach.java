package sw;

import sun.awt.X11.XButtonPeer;

public class BinarySerach {
    //注意在有递归调用的时候注意返回值的设置，如果简单的以return返回，return可能会多次执行，二修改值

    public boolean binarySearch(int[] array, int target, int indexStart, int indexEnd) {
        if (indexStart > indexEnd)
            return false;
        int mid = (indexStart + indexEnd) / 2;
        if (array[mid] == target)
            return true;
        if (array[mid] > target)
            return binarySearch(array, target, indexStart, mid - 1);
        if (array[mid] < target)
            return binarySearch(array, target, mid + 1, indexEnd);

        return false;
    }


    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        BinarySerach binarySerach = new BinarySerach();
        System.out.println(binarySerach.binarySearch(array, 5, 0, array.length - 1));
        System.out.println(binarySerach.binarySearch(array, 3, 0, array.length - 1));
        System.out.println(binarySerach.binarySearch(array, 11, 0, array.length - 1));


    }
}
