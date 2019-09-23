package InterVIew.WeiZhongYinHang.Problem1;

import java.util.Scanner;
import java.util.Stack;
/*
末尾的数
时间限制：C/C++语言 1000MS；其他语言 3000MS
内存限制：C/C++语言 65536KB；其他语言 589824KB
题目描述：
小明想知道 n! ，最后一位不为 0 的数字，你能告诉他吗？ n! = n*(n-1)*(n-2)*....*3*2*1
输入
一个正整数n（n<=5000）

输出
 一位数答案，表示最后一位不为0的数字


样例输入
7
样例输出
4

提示
7！=5040 ，最后一位不为0的数字为4
 */
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

    /**
     * @param str1
     * @param str2
     * @return 思路：
     * 用字符串表示大数，模拟乘法
     * @see 大数乘法
     */
    public static String multiply(String str1, String str2) {
        if (str1 == null || str2 == null)  //输入有误的情况
            return "出错";
        if (str1.equals("0") || str2.equals("0"))//因子中有一个是0的情况
            return "0";
        String num1;
        String num2;
        if (str1.length() > str2.length()) {    //num1为较长的那个因子
            num1 = str1;
            num2 = str2;
        } else {
            num1 = str2;
            num2 = str1;
        }
        StringBuilder[] sb = new StringBuilder[num2.length()];//用StringBuilder存储相乘的结果
        for (int i = num2.length() - 1; i >= 0; i--) {
            sb[i] = new StringBuilder();
            int x = num2.charAt(i) - 48;
            int temp = 0;
            for (int j = 0; j < num2.length() - i - 1; j++) {
                sb[i].append("0");  //错位补0
            }
            for (int j = num1.length() - 1; j >= 0; j--) {
                int y = num1.charAt(j) - 48;
                sb[i].append((x * y + temp) % 10);
                temp = (x * y + temp) / 10;
            }
            if (temp != 0) {
                sb[i].append(temp);
            }
        }
        String sr = String.valueOf(sb[0].reverse());
        for (int i = 1; i < num2.length(); i++) {
            sr = add(sr, String.valueOf(sb[i].reverse()));
        }
        return sr;
    }

    public static String  fun(long n) {
        String result  = "1";
        for (int i = 1; i <= n; i++) {
            result = multiply(result,Integer.toString(i));
        }
        return result;
    }

    public static int solution(long n) {
        String result = fun(n);
        for (int i = result.length()-1;i>=0;i--){
            if (result.charAt(i)!='0')
                return result.charAt(i)-48;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        //System.out.println(fun(n));
        System.out.println(solution(n));
    }
}