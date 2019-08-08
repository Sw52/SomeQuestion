package CodingInterview;

public class 数列求和 {

    /**
     * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     * @param n
     * @return
     */
    public static int sum_Solution(int n) {
        int sum = n;
        boolean t = (n > 0) && (sum += sum_Solution(n-1))>0;
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(sum_Solution(100));
    }
}
