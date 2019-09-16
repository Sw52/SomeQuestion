package CodingInterview;

public class Q24_翻转链表 {
    /**
     * 问题描述：
     * 输入一个链表，反转链表后，输出新链表的表头。
     */
    /**
     * @param listNode
     * @return
     * @author SwYoung
     * @see 迭代方式实现链表翻转
     */
    public static ListNode reverseList(ListNode pHead) {
        if (pHead == null || pHead.next == null)    //如果头结点为空或者只有一个节点，则返回头结点
            return pHead;
        ListNode pPrev = pHead.next;    //定义一个节点指向头结点的下一个节点
        ListNode pNext = null;  //定义后向节点
        while (pPrev != null) {
            pHead.next = pNext; //让头结点指向后向节点
            pNext = pHead;      //更新厚向节点
            pHead = pPrev;      //头结点向后移
            pPrev = pPrev.next; //更新前向节点
            pHead.next = pNext; //连接头结点的下一节点
        }
        return pHead;
    }

    /**
     * @param head
     * @return
     * @see 递归实现链表翻转
     */
    public static ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = reverseListNode(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    public static void main(String[] args) {
        ListNode pHead = new ListNode(1);
        ListNode p1 = new ListNode(2);
        ListNode p2 = new ListNode(3);
        ListNode p3 = new ListNode(4);
        ListNode p4 = new ListNode(5);
        pHead.next = p1;
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;

        ListNode.printListNode(pHead);
        System.out.println();
        ListNode.printListNode(reverseList(pHead));
        //ListNode.printListNode(reverseListNode(pHead));
    }

}
