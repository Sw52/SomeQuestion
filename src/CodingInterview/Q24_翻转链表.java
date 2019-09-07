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
     * @see 链表翻转
     */
    public static ListNode reverseList(ListNode listNode) {
        ListNode pNewHead = null;   //定义翻转后的新头结点
        ListNode pPre = null;       //定义前向节点
        while (listNode != null) {
            ListNode pNext = listNode.next; //定义后向节点
            if (pNext == null) {    //后向节点为空时，说明已经到达链表尾
                pNewHead = listNode;//给新头结点赋值
            }
            listNode.next = pPre;   //将原先的前向节点编程现在的后向节点
            pPre = listNode;        //更新前向节点，将现在的节点定义为新的前向节点
            listNode = pNext;       //更新当前节点
        }
        return pNewHead;
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

    }

}
