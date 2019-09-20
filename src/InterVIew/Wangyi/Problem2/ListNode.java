package InterVIew.Wangyi.Problem2;

/**
 * 定义LinkNode类
 */
class ListNode {
    int val;    //该节点值

    ListNode next = null; //该节点指向下一个节点的指针

    /**
     * @see 无参构造
     */
    ListNode() {

    }

    /**
     * @param val
     * @see 带参构造
     */
    ListNode(int val) {     //带参构造函数
        this.val = val;
    }

    /**
     * @param listNode
     * @see 打印链表
     */
    public static void printListNode(ListNode listNode) {
        if (listNode == null)
            return;
        System.out.print(listNode.val);
        printListNode(listNode.next);
    }

}