package InterVIew.Xc.Problem1;


import java.util.Scanner;

public class Main {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    public static ListNode partition(ListNode head, int x) {

        ListNode before_head = new ListNode(0);
        ListNode before = before_head;
        ListNode after_head = new ListNode(0);
        ListNode after = after_head;

        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        after.next = null;

        before.next = after_head.next;

        return before_head.next;
    }


    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ListNode head = null;
        ListNode node = null;
        int m = in.nextInt();
        while (in.hasNextInt()) {
            int v = in.nextInt();
            if (head == null) {
                node = new ListNode(v);
                head = node;
            } else {
                node.next = new ListNode(v);
                node = node.next;
            }
        }
        head = partition(head, m);
        if (head != null) {
            System.out.print(head.val);
            head = head.next;
            while (head != null) {
                System.out.print(",");
                System.out.print(head.val);
                head = head.next;
            }
        }
        System.out.println();
    }
}
