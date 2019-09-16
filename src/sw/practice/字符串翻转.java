package sw.practice;

import java.util.Scanner;
import java.util.Stack;

/*
题目描述
写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。例如：
输入描述:
输入N个字符

输出描述:
输出该字符串反转后的字符串

示例1
输入
复制
abcd
输出
复制
dcba
 */
public class 字符串翻转 {
    public static StringBuilder solution(String string) {
        Stack<Character> stack = new Stack<>(); //利用栈结构的LIFO特性来使传入的字符串倒序
        for (int i = 0; i < string.length(); i++) {
            stack.push(string.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (stack.empty() != true) {
            sb.append(stack.pop());
        }
        return sb;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(solution(str));
    }
}
