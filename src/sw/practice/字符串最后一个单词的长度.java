package sw.practice;

import java.util.Scanner;

/*
题目描述
计算字符串最后一个单词的长度，单词以空格隔开。
输入描述:
一行字符串，非空，长度小于5000。

输出描述:
整数N，最后一个单词的长度。

示例1
输入
复制
hello world
输出
复制
5
 */
public class 字符串最后一个单词的长度 {

    /**
     * @param string
     * @return
     * @see 查找字符串最后一个单词的长度
     */
    public static int solution(String string) {
        int res = 0;
        for (int i = string.length() - 1; i >= 0; i--) {
            if (string.charAt(i) == ' ')
                return res;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = "";
        str = scanner.nextLine();  //采用nextline 可以获取整个一行的值,包含空格的值
        System.out.println(solution(str));
    }
}
