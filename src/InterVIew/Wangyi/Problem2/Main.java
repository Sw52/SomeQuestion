package InterVIew.Wangyi.Problem2;

public class Main {

    private void removeNode(ListNode listNode) {
        if (listNode == null)
            return;
        if (listNode.next == null)
            listNode = null;
        else if (listNode.next != null && listNode.next == null) {
            listNode.val = listNode.next.val;
            listNode.next = null;
        } else {
            listNode.val = listNode.next.val;
            listNode.next = listNode.next.next;
        }
    }

    public void removeDuplicates(ListNode head) {
        if (head == null)
            return;
        if (head.next == null || head.next.next == null)
            return;
        ListNode result = head;
        while (result.next.next != null) {
            if (result.next != null & result.next.next != null && result.val == result.next.val && result.val == result.next.next.val) {
                removeNode(result.next);
                if (result.next.next != null)
                    result = result.next;
            } else {
                if (result.next.next != null)
                    result = result.next;
            }
        }
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(6);
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(1);
        ListNode p3 = new ListNode(2);
        ListNode p4 = new ListNode(2);
        ListNode p5 = new ListNode(2);
        ListNode p6 = new ListNode(1);
        ListNode p7 = new ListNode(1);
        ListNode p8 = new ListNode(1);
        head.next = p1;
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = p6;
        p6.next = p7;
        p7.next = p8;
        Main ma = new Main();
        ListNode.printListNode(head);
        System.out.println();
        ma.removeDuplicates(head);
        ListNode.printListNode(head);

    }
}