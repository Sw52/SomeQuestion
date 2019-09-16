package InterVIew.XiaoMi.Problem1;


import java.util.Scanner;
import java.util.Stack;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static void solution(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ',')
                stack.push(input.charAt(i));
            else {
                boolean isF = false;
                while (true) {
                    if (stack.isEmpty())
                        break;
                    if (isF && stack.peek() == '(')
                        break;
                    if (stack.peek() == '(')
                        isF = true;
                    if (stack.peek() <= '9' && stack.peek() >= '0')
                        System.out.print(stack.pop());
                    else
                        stack.pop();
                }
                int j = i + 1;
                if (input.charAt(j) <= '9' && input.charAt(j) >= '0') {
                    if (stack.isEmpty()) {
                        stack.push(input.charAt(j));
                    }
                    System.out.print(stack.pop());
                    i++;
                }
            }
        }
    }

    /******************************结束写代码******************************/

    //测试用例
    //1(2(3,4(,5)),6(7,))
    //3245176
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        String _input;
        try {
            _input = in.nextLine();
        } catch (Exception e) {
            _input = null;
        }
        solution(_input);
    }
}
