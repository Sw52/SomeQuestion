package InterVIew.Xc.Problem2;

import java.util.Scanner;
import java.util.Stack;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String resolve(String expr) {
        int ex = 0;
        for (int i = 0; i < expr.length(); i++) {
            if (expr.charAt(i) == '(')
                ex++;
            if (expr.charAt(i) == ')')
                ex--;
        }
        if (ex != 0)
            return " ";
        Stack<String> stack = new Stack<>();
        boolean isFirst = false;
        for (int i = 0; i < expr.length(); i++) {
            if (isFirst == false && expr.charAt(i) == '(') {
                isFirst = true;
                continue;
            }
            if (isFirst == false && expr.charAt(i) != '(') {
                stack.push(String.valueOf(expr.charAt(i)));
            }
            if (isFirst && expr.charAt(i) != '(' && expr.charAt(i) != ')') {
                stack.push(String.valueOf(expr.charAt(i)));
            } else if (isFirst && expr.charAt(i) == '(') {
                boolean b = false;
                i++;
                int k = i;
                while (expr.charAt(i) != ')') {
                    if (expr.charAt(i) == '(') {
                        stack.push(expr.substring(k, i));
                        i++;
                        int g = i;
                        while (expr.charAt(i) != ')') {
                            i++;
                        }
                        int f = i;
                        stack.push(expr.substring(g, f));
                        b = true;
                    }
                    i++;
                }
                if (b)
                    break;
                int l = i;
                stack.push(expr.substring(k, l));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());
        return String.valueOf(sb);
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}
