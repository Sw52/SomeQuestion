package CodingInterview;


public class Q4_在有序矩阵中查找 {

    /**
     * @param target
     * @param array
     * @return
     * @author sw
     * @see 问题描述：
     * 在一个二维数组中（每个一维数组的长度相同），
     * 每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，
     * 判断数组中是否含有该整数。
     */
    public static boolean find(int target, int[][] array) {
        boolean found = false;
        int rows = array.length;    //获取二维数组行数
        int columns = array[0].length;  //获取二位数组列数

        if (array != null && rows > 0 && columns > 0) { //注意对数组进行判空
            int row = 0;
            int column = columns - 1;
            while (row < rows && column >= 0) {
                if (array[row][column] == target) {
                    found = true;
                    break;
                } else if (array[row][column] > target)
                    --column;
                else
                    ++row;
            }
        }
        return found;
    }


    public static void main(String[] args) {
        //测试数据
        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int target = 5;
        System.out.println(find(target, array));
    }

}
