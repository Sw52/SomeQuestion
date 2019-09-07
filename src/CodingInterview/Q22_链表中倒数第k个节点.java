package CodingInterview;

public class Q22_链表中倒数第k个节点 {
    /*
    题目描述：
    输入一个链表，输出该链表中倒数第k个结点
     */

    /**
     * @see
     * @param head
     * @param k
     * @return
     */
    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode listNode = head;
        for (int i = 0; i < k; i++) {
            if (listNode.next == null)
                return null;
            listNode = listNode.next;
        }
        ListNode res = head;
        while (listNode != null) {
            listNode = listNode.next;
            res = res.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p1 = new ListNode(2);
        ListNode p2 = new ListNode(3);
        ListNode p3 = new ListNode(4);
        ListNode p4 = new ListNode(5);
        ListNode p5 = new ListNode(6);
        ListNode p6 = new ListNode(7);
        head.next = p1;
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = p6;
        ListNode.printListNode(head);
        System.out.println();
        System.out.println(FindKthToTail(head,4).val);
    }
}
