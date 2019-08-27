package InterVIew.HW.Problem1;

import java.util.Scanner;

/*
题目描述：字符串转义：
输入一个16进制的字符串，把A转换成12 34 把B转换成AB CD
其他的不变，注意输入和输出的第一个数字为该字符串16进制数字的个数。
 */
public class Main {
    public static StringBuilder solution(String string) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int i = 0;
        if (string.charAt(1) == ' ') {
            count = string.charAt(0) - 48;
            i = 0;
        } else if (string.charAt(2) == ' ') {
            count = (string.charAt(0) - 48) * 10 + string.charAt(1) - 48;
            i = 1;
        } else if (string.charAt(3) == ' ') {
            i = 2;
            count = (string.charAt(0) - 48) * 100 + (string.charAt(1) - 48) * 10 + string.charAt(2) - 48;
        }

        for (; i < string.length(); i++) {

            if (string.charAt(i) == 'A') {
                sb.append("12 34");
                count++;
            } else if (string.charAt(i) == 'B') {
                sb.append("AB CD");
                count++;
            } else if (string.charAt(i) != ' ') {
                sb.append(string.charAt(i));
            } else if (string.charAt(i) == ' ')
                sb.append(" ");
        }
        sb.deleteCharAt(0);

        System.out.print(count);    //问题所在：count需要转成16进制
        System.out.println(sb);
        return sb;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String string = sc.nextLine();
            solution(string);
        }
    }
}
