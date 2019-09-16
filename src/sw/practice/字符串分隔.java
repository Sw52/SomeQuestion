package sw.practice;

import java.util.Scanner;

/*
题目描述
•连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
•长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
输入描述:
连续输入字符串(输入2次,每个字符串长度小于100)

输出描述:
输出到长度为8的新字符串数组

示例1
输入
复制
abc
123456789
输出
复制
abc00000
12345678
90000000
 */
public class 字符串分隔 {

    /**
     * @param strings
     * @see 字符串分隔
     */
    public static void solution(String[] strings) {
        for (int j = 0; j < 2; j++) {
            int temp = strings[j].length() / 8; //查找当前字符串有几组长度为8的子字符串
            for (int i = 0; i < temp; i++) {
                System.out.println(strings[j].subSequence(i * 8, i * 8 + 8));
            }
            int temp2 = strings[j].length() % 8; //计算最后一组长度不满足8的子字符串的长度
            System.out.print(strings[j].subSequence(temp * 8, temp * 8 + temp2));
            if (strings[j].length() % 8 != 0) {
                for (int i = 0; i < 8 - temp2; i++) {
                    System.out.print(0);    //补零输出
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = new String[2];
        strings[0] = scanner.next();
        strings[1] = scanner.next();
        solution(strings);
    }
}
