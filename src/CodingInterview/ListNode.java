package CodingInterview;

/**
 * 定义LinkNode类
 */
class ListNode {
    int val;    //该节点值

    CodingInterview.ListNode next = null; //该节点指向下一个节点的指针

    ListNode(int val) {     //带参构造函数
        this.val = val;
    }

    public static void printList(ListNode pHead) {
        if (pHead == null)
            return;
        else {
            System.out.println(pHead.val);
            while (pHead.next != null) {
                pHead = pHead.next;
                System.out.println(pHead.val);
            }
        }
    }
}