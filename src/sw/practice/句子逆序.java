package sw.practice;

import java.util.Scanner;
import java.util.Stack;

/*
题目描述
将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符

输入描述:
将一个英文语句以单词为单位逆序排放。

输出描述:
得到逆序的句子

示例1
输入
复制
I am a boy
输出
复制
boy a am I
 */
public class 句子逆序 {
    /**
     * @param string
     * @return
     * @see 英文句子单词翻转
     */
    public static String solution(String string) {
        String result;
        string = string.concat(" ");
        StringBuffer sb = new StringBuffer();
        Stack stack = new Stack();
        for (int i = string.length() - 1; i >= 0; i--) {
            while (string.charAt(i) == ' ') {
                while (stack.empty() != true) {
                    sb.append(stack.pop());
                }
                if (i == 0)
                    break;
                i--;
            }
            if (string.charAt(i) != ' ') {
                if (i != string.length() - 1 && string.charAt(i + 1) == ' ') {
                    stack.push(' ');
                }
                stack.push(string.charAt(i));
                if (i == 0) {
                    while (stack.empty() != true) {
                        sb.append(stack.pop());
                    }
                    break;
                }
            }
        }
        int sblength = sb.length();
        if (sblength != 0) {
            result = sb.substring(0, sblength - 1);
        } else {
            return "";
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println(solution(string));
    }
}
