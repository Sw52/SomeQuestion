package sw.practice;

import java.util.Scanner;

/*
题目描述
写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）

输入描述:
输入一个十六进制的数值字符串。

输出描述:
输出该数值的十进制字符串。

示例1
输入
复制
0xA
输出
复制
10
 */
public class 进制转换 {

    /**
     * 将16进制字符串转换成10进制输出
     * @param string
     * @return
     */
    public static int solution(String string) {
        string = string.toUpperCase();//将字符串全部转换成大写格式
        int length = string.length();
        int res = 0;
        int k = 0;
        for (int i = length-1; i >=2 ; i--) {
            if (string.charAt(i) <= '9' && string.charAt(i) >= '0') {
                res += Math.pow(16,k)*(string.charAt(i)-48);
                k++;
            } else if (string.charAt(i) <= 'F' && string.charAt(i) >= 'A') {
                switch (string.charAt(i)) {
                    case 'A':
                        res += Math.pow(16,k)*(10);
                        k++;
                        break;
                    case 'B':
                        res += Math.pow(16,k)*(11);
                        k++;
                        break;
                    case 'C':
                        res += Math.pow(16,k)*(12);
                        k++;
                        break;
                    case 'D':
                        res += Math.pow(16,k)*(13);
                        k++;
                        break;
                    case 'E':
                        res += Math.pow(16,k)*(14);
                        k++;
                        break;
                    case 'F':
                        res += Math.pow(16,k)*(15);
                        k++;
                        break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            System.out.println(solution(str));
        }
    }
}
