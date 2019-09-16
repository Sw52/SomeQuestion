package CodingInterview;

public class Q22_链表中倒数第k个节点 {
    /*
    题目描述：
    输入一个链表，输出该链表中倒数第k个结点
     */

    /**
     * @param head
     * @param k
     * @return 思路：
     * 这只两个指针，第一个先走K步，然后两个指针一起走，
     * 直到指针1到末尾的时候指针2指向的就是倒数第K个节点
     * @see 查询链表的倒数第K个节点
     */
    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode listNode = head;
        for (int i = 0; i < k; i++) {   //指针1先向后走K步
            if (listNode == null)
                return null;
            listNode = listNode.next;
        }
        ListNode res = head;
        while (listNode != null) {      //两个指针同时向后走，直到指针1到链表尾
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
        System.out.println(FindKthToTail(head, 7).val);
    }
}
