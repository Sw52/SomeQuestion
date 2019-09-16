package InterVIew.Bilibilli.Problem1;

import java.util.Scanner;
import java.util.Stack;

/*
英文句子单词翻转
原地翻转句子中单词的顺序，但单词内字符的书序不变。要求：空间复杂度O(1)，时间复杂度O(n)
 */
public class Main {
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
