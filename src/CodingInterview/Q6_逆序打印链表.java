package CodingInterview;

import java.util.ArrayList;


public class Q6_逆序打印链表 {




    /**
     * @param listNode
     * @return
     * @author sw
     * @see 问题描述：
     * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
     * 注意：是否循序修改数据
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        if (listNode == null)
            return new ArrayList<>();
        ListNode head = listNode;
        ListNode cur = listNode.next;

        while (cur != null) {
            ListNode temp = cur.next;   //指向临时区，为了后面的指针交换
            cur.next = head;    //指针反向，将从前往后的指针方向变为从后往前
            head = cur; //交换指针，使head指向下一个节点
            cur = temp;
        }
        //此时listNode的next还指向第二个node，所以要让listNode.next=null,防止循环
        listNode.next = null;
        ArrayList<Integer> res = new ArrayList<>();
        while (head != null) {
            res.add(head.val);
            head = head.next;
        }
        return res;

        /*
        下方是递归实现
         */
//        if(listNode.next!=null){
//            printListFromTailToHead(listNode.next);
//        }
//        System.out.println(listNode.val);
//        return null;
    }


    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        System.out.println(printListFromTailToHead(listNode1));

        /*
        递归实现
         */
        //        printListFromTailToHead(listNode1);
    }

}




