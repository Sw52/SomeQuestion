package InterVIew.Kdxf.Problem1;

import java.util.Scanner;
import java.util.Stack;


public class Main {
    /**
     * @param str1
     * @param str2 思路：
     *             用字符串存储大数，然后从后往前遍历，模拟加法。
     * @see 大数加法
     */
    public static String add(String str1, String str2) {
        Stack<Integer> stack = new Stack<>();
        int endOfStr1 = str1.length() - 1;
        int endOfStr2 = str2.length() - 1;
        int temp = 0;
        while (endOfStr1 >= 0 && endOfStr2 >= 0) {
            if (temp + str1.charAt(endOfStr1) - 48 + str2.charAt(endOfStr2) - 48 < 10) {
                stack.push(temp + str1.charAt(endOfStr1) - 48 + str2.charAt(endOfStr2) - 48);
                temp = 0;
            } else {
                stack.push(temp + str1.charAt(endOfStr1) - 48 + str2.charAt(endOfStr2) - 48 - 10);
                temp = 1;
            }
            endOfStr1--;
            endOfStr2--;
        }
        while (endOfStr1 >= 0) {
            if (temp + str1.charAt(endOfStr1) - 48 < 10) {
                stack.push(temp + str1.charAt(endOfStr1) - 48);
                temp = 0;
            } else {
                stack.push(temp + str1.charAt(endOfStr1) - 48 - 10);
                temp = 1;
            }
            endOfStr1--;
        }
        while (endOfStr2 >= 0) {
            if (temp + str2.charAt(endOfStr2) - 48 < 10) {
                stack.push(temp + str2.charAt(endOfStr2) - 48);
                temp = 0;
            } else {
                stack.push(temp + str2.charAt(endOfStr2) - 48 - 10);
                temp = 1;
            }
            endOfStr2--;
        }
        if (temp == 1)    //处理最后可能进位的情况
            stack.push(1);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        String res = String.valueOf(sb);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(add(str1, str2));
    }
}
