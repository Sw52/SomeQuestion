package CodingInterview;

public class Q15_数字中1的个数{

    /**
     * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     *
     * @param n
     * @return
     */
    public static int numberOf1(int n) {

        int count = 0;
        if (n > 0) {
            while (n > 0) {
                ++count;
                n = (n - 1) & n;
            }
        }
        else if(n<0){
            //注意对负数的处理
            while (n < 0) {
                ++count;
                n = (n - 1) & n;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOf1(5));


        System.out.println(Integer.toBinaryString(-2147483648));
        System.out.println(Integer.toBinaryString(-2147483648-1));
        System.out.println(numberOf1(-2147483648));

        System.out.println(Integer.toBinaryString(-2));
        System.out.println(Integer.toBinaryString(-2-1));
        System.out.println(numberOf1(-2));


    }
}
