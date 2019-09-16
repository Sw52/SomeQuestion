package sw.practice;

import java.util.Scanner;

public class 进制转换 {
    /**
     * 将输入的十进制数M转换成N进制数
     *
     * @param M
     * @param N
     * @return
     */
    public static StringBuilder trans(int M, int N) {
        StringBuilder sb = new StringBuilder();
        char[] chars = {' ', 'A', 'B', 'C', 'D', 'E', 'F'};
        if (M >= 0) {
            while (M > 0) {
                int temp = M % N;
                if (temp > 9)
                    sb.append(chars[temp - 9]);
                else
                    sb.append(temp);
                M /= N;
            }
        } else {    //处理负数
            sb = trans(-M, N).reverse();
            sb.append('-');
        }
        return sb.reverse();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        System.out.println(trans(M, N));
    }
}
