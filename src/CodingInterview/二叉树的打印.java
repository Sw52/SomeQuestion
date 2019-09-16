package CodingInterview;

import java.util.ArrayList;
import java.util.LinkedList;

public class 二叉树的打印 {

    /**
     * @param treeNode
     * @author SwYoung
     * @see 二叉树的先序打印
     */
    public void printBinaryTreePreOrder(TreeNode treeNode) {
        if (treeNode == null)
            return;
        System.out.print(" " + treeNode.val + " ");   //先打印当前节点值
        if (treeNode.left != null)
            printBinaryTreePreOrder(treeNode.left);     //递归打印左子树
        if (treeNode.right != null)
            printBinaryTreePreOrder(treeNode.right);    //递归打印右子树
    }

    /**
     * @param treeNode
     * @author SwYoung
     * @see 二叉树的中序打印
     */
    public void printBinaryTreeInOrder(TreeNode treeNode) {
        if (treeNode == null)
            return;
        if (treeNode.left == null && treeNode.right == null) {  //到达叶子节点
            System.out.print(" " + treeNode.val + " ");
            return;
        }
        if (treeNode.left != null)                      //递归打印左子树
            printBinaryTreeInOrder(treeNode.left);
        System.out.print(" " + treeNode.val + " ");   //打印当前节点值
        if (treeNode.right != null)
            printBinaryTreeInOrder(treeNode.right);     //递归打印右子树
    }

    /**
     * @param treeNode
     * @author SwYoung
     * @see 二叉树的后序打印
     */
    public void printBinaryTreeByPostOrder(TreeNode treeNode) {
        if (treeNode == null)
            return;
        if (treeNode.left == null && treeNode.right == null) {  //到达叶子节点
            System.out.print(" " + treeNode.val + " ");
            return;
        }
        if (treeNode.left != null)                      //递归打印左子树
            printBinaryTreeByPostOrder(treeNode.left);
        if (treeNode.right != null)
            printBinaryTreeByPostOrder(treeNode.right); //递归打印右子树
        System.out.print(" " + treeNode.val + " ");   //打印当前节点值
    }

    /**
     * @param treeNode
     * @author SwYoung
     * @see 二叉树的层序打印
     */
    public void printBinaryTreeByLayer(TreeNode treeNode) {
        if (treeNode == null)//当输入为空的时候返回空列表
            return;
        LinkedList<Integer> linkedList = new LinkedList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(treeNode);           //向队列中加入根节点
        while (!list.isEmpty()) {
            TreeNode top = list.poll(); //从队列中抛出一个节点
            linkedList.add(top.val);    //加入到结果集
            if (top.left != null)
                list.offer(top.left);   //如果这个节点有左儿子，则把左儿子加入到队列中
            if (top.right != null)
                list.offer(top.right);  //如果这个节点有右儿子，则把左儿子加入到队列中
        }
        for (int i : linkedList
        ) {
            System.out.print(" " + i + " ");
        }
    }

    /**
     * @param root
     * @return 思路：用一个队列来依次记录树的各个节点
     * @see 二叉树的层序遍历
     */
    public static ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null)               //当输入为空的时候返回空列表
            return arrayList;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(root);               //向队列中加入根节点
        while (!list.isEmpty()) {
            TreeNode top = list.poll(); //从队列中抛出一个节点
            arrayList.add(top.val);     //加入到结果集
            if (top.left != null)       //如果这个节点有左儿子，则把左儿子加入到队列中
                list.offer(top.left);
            if (top.right != null)
                list.offer(top.right);  //如果这个节点有右儿子，则把左儿子加入到队列中
        }
        return arrayList;
    }


    public static void main(String[] args) {

        /*  构建二叉树
                  1
                 / \
                2   5
               / \ / \
              3  4 6  7
         */
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);

        二叉树的打印 printBinary = new 二叉树的打印();
        //先序
        printBinary.printBinaryTreePreOrder(treeNode);
        System.out.println();
        //中序
        printBinary.printBinaryTreeInOrder(treeNode);
        System.out.println();
        //后序
        printBinary.printBinaryTreeByPostOrder(treeNode);
        System.out.println();
        //层序
        printBinary.printBinaryTreeByLayer(treeNode);
        System.out.println();

    }
}
