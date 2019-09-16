package sw.practice;

import java.util.Scanner;

/*
题目描述
写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。

输入描述:
第一行输入一个有字母和数字以及空格组成的字符串，第二行输入一个字符。

输出描述:
输出输入字符串中含有该字符的个数。

示例1
输入
复制
ABCDEF
A
输出
复制
1
 */
public class 计算字符个数 {

    /**
     * @param string
     * @param target
     * @return
     * @see 计算字符个数
     */
    public static int solution(String string, char target) {
        string = string.toUpperCase(); //将字符串都转换成大写格式
        target = Character.toUpperCase(target);//将目标字符转换成大写格式
        int res = 0;
        for (int i = 0; i < string.length(); i++) {//循环进行比对
            if (string.charAt(i) == target)
                res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String str_target = scanner.next();
        char target = str_target.charAt(0);
        System.out.println(solution(str, target));
    }
}
