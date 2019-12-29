package CodingInterview;

import java.util.Stack;

public class Q9_栈实现队列 {
    /**
     * 问题描述：用两个栈实现队列
     * 题目：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail和
     * deleteHead，分别完成在对垒尾插入节点和队列头删除节点的功能
     * <p>
     * <p>
     * 思路： 入队列的元素全部在stack1中压入，如果需要出队列，则把stack1中的元素以此出栈并
     * 入栈到stack2中，完成操作后再从stack2出栈；
     * 之后如需出队列，只需在stack2抛出一个元素即可 ，如果stack2为空，则把stack1中的元素
     * 再次压入stack2中这样就实现了队列的功能。
     * <p>
     * <p>
     * <p>
     * 相关题目：用两个队列实现栈
     * <p>
     * 思路：队列A入队三个元素{a,b,c}；现在模拟栈的特性，要抛出栈顶的c，可以让队列A中的{a,b}
     * 分别出队，进入队列B中，然后把队列A中剩余的c给抛出；此时入栈{d}，添加到队列{a,b,d}，此时
     * 要抛出d只需将{a,b}出队并入队到A中，即可从B中出队d元素。
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack1.isEmpty() && stack2.isEmpty())
            throw new RuntimeException("Queue is empty");
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }


    public static void main(String[] args) {
        Q9_栈实现队列 q9_queueWithTwoStacks = new Q9_栈实现队列();
        q9_queueWithTwoStacks.push(1);
        q9_queueWithTwoStacks.push(2);
        q9_queueWithTwoStacks.push(3);

        System.out.println(q9_queueWithTwoStacks.pop());
    }
}
