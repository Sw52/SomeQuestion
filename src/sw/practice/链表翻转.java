package sw.practice;


public class 链表翻转 {
    public static ListNode reverListNode(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = reverListNode(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


}
