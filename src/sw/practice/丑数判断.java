package sw.practice;

public class 丑数判断 {
    /**
     * @see 判断丑数
     * 丑数：只能被2、3和5整除的正整数数，1是第一个丑数
     * @param n
     * @return
     */
    public static boolean isUgly(int n) {
        if (n >= 1) {
            while (n % 2 == 0) {
                n = n / 2;
            }
            while (n % 3 == 0) {
                n = n / 3;
            }
            while (n % 5 == 0) {
                n = n / 5;
            }
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isUgly(1));
        System.out.println(isUgly(2));
        System.out.println(isUgly(3));
        System.out.println(isUgly(5));
        System.out.println(isUgly(15));
        System.out.println(isUgly(26));
        System.out.println(isUgly(28));
    }
}
