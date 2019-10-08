package CodingInterview;

public class 合并两个排序的链表 {
    /**
     * @see 合并两个有序的链表
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode node = new ListNode();
        if (list1.val < list2.val) {
            node.val = list1.val;
            list1 = list1.next;
        } else {
            node.val = list2.val;
            list2 = list2.next;
        }
        ListNode newHead = node;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                ListNode temp = new ListNode(list1.val);
                node.next = temp;
                node = node.next;
                list1 = list1.next;
            } else {
                ListNode temp = new ListNode(list2.val);
                node.next = temp;
                node = node.next;
                list2 = list2.next;
            }
        }
        if (list1 != null)
            node.next = list1;
        if (list2 != null)
            node.next = list2;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p1 = new ListNode(2);
        head.next = p1;
        ListNode p2 = new ListNode(3);
        p1.next = p2;

        ListNode head2 = new ListNode(1);
        ListNode p11 = new ListNode(2);
        head2.next = p11;
        ListNode p21 = new ListNode(3);
        p11.next = p21;

        Merge(head, head2);

    }
}
