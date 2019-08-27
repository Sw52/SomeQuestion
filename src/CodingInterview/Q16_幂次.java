package CodingInterview;

public class Q16_幂次 {

    /**
     * 问题描述：
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     *
     * @param base
     * @param exponent
     * @return
     */
    public double power(double base, int exponent) {
        double result = 1;
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        if (exponent > 0) {
            for (int i = 1; i <= exponent; i++) {
                result *= base;
            }
        }
        if (exponent < 0) { //幂次是负数的情况
            exponent = -exponent;
            for (int i = 1; i <= exponent; i++) {
                result *= base;
            }
            result = 1 / result;
        }
        return result;
    }


    public static void main(String[] args) {
        Q16_幂次 q16_power = new Q16_幂次();
        System.out.println(q16_power.power(2, 4));
        System.out.println(q16_power.power(2, -3));
        System.out.println(q16_power.power(-2, 2));


    }
}
