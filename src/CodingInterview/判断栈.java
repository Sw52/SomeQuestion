package CodingInterview;

import java.util.Stack;

/*
问题描述：
输入两个整数序列，第一个序列表示栈的压入顺序，
请判断第二个序列是否可能为该栈的弹出顺序。
假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class 判断栈 {
    /**
     * @param pushA
     * @param popA
     * @return 思路：先把pushA依次入栈，每当有新元素入栈，则比较是否和popA的序列对应，
     * 如果对应则把该元素pop掉，最后如果stack中还有其他元素的话，说明不是对应的序列。
     * @see 判断以pushA入栈，能否得到popA序列
     */
    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        if (popA.length == 0 || popA.length == 0 || popA.length != pushA.length)
            return false;
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {4, 3, 5, 1, 2};
        System.out.println(IsPopOrder(arr1, arr2));
    }
}
