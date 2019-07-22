package CodingInterview;

public class Q15_NumberOf1InBinary {

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
            //输入负数时有误
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOf1(5));
        System.out.println(numberOf1(-2147483648));
        Byte b = Byte.valueOf(Integer.toBinaryString(-2147483648).substring(0,2));
        System.out.println(b);
        int x = (int)b;
        System.out.println(x);

    }
}
