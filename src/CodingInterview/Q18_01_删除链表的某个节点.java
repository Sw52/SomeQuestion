package CodingInterview;


public class Q18_01_删除链表的某个节点 {

    /**
     * 问题描述1：在O(1)时间内删除链表节点
     * 给定单向链表的头指针和一个节点指针，写一个函数删除该节点
     * <p>
     * 删除链表中的一个节点常见的有两种方法：
     * 1：找到该节点的前一个节点，将前一个节点的next指针指向待删除节点的下一个节点，然后删除待删除节点。
     * 2：从待删除节点开始，以此把之后的节点覆盖前面的一个节点。
     */

    public void deleteNode(ListNode pHead, ListNode pTodelete) {
        if (pHead == null || pTodelete == null)    //判断输入是否合法
            return;

        if (pTodelete.next != null) {   //如果待删除的不是尾节点
            pTodelete.val = pTodelete.next.val;
            pTodelete.next = pTodelete.next.next;
        } else if (pHead == pTodelete) {  //链表只有一个节点
            pHead = null;
        } else {  //链表中有多个节点，而待删除的是尾节点
            ListNode pNode = pHead;
            while (pNode.next != pTodelete) {
                pNode = pNode.next;
            }
            pNode.next = null;
        }
    }

    /**
     * 问题描述2：删除链表中的重复节点
     * 给定单向链表的头指针和一个节点指针，写一个函数删除该节点
     *
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) //判断输入合法性
            return null;

        if (pHead.next != null && pHead.val == pHead.next.val) {    //处理头结点
            pHead = pHead.next.next;
        }

        ListNode pPreNode = null;   //定义前向节点
        ListNode pNode = pHead;
        while (pNode != null) {
            ListNode pNext = pNode.next;    //指向下一个节点
            boolean needDelete = false;
            if (pNext != null && pNext.val == pNode.val) {
                needDelete = true;
            }
            if (needDelete == false) {
                pPreNode = pNode;
                pNode = pNode.next;
            } else {
                int val = pNode.val;
                ListNode pTodelete = pNode;
                while (pTodelete != null && pTodelete.val == val) {
                    pNext = pTodelete.next;
                    pTodelete = null;
                    pTodelete = pNext;
                }
                if (pPreNode == null) {
                    pHead = pNext;
                } else {
                    pPreNode.next = pNext;
                }
                pNode = pNext;
            }
        }

        return pHead;
    }

    public static void main(String[] args) {
        ListNode pHead = new ListNode(2);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(4);
        ListNode p4 = new ListNode(5);
        ListNode p5 = new ListNode(6);

        pHead.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;

        Q18_01_删除链表的某个节点 q18_01_deleteNodeInList = new Q18_01_删除链表的某个节点();
        //删除测试
        q18_01_deleteNodeInList.deleteNode(pHead, pHead);
        q18_01_deleteNodeInList.deleteNode(pHead, p5);

        //重复节点删除测试
        ListNode pf;
        pf = q18_01_deleteNodeInList.deleteDuplication(pHead);
        q18_01_deleteNodeInList.deleteDuplication(pf);
        ListNode.printListNode(pf);

    }

}
