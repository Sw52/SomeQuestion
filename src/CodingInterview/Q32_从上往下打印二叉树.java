package CodingInterview;

import java.util.ArrayList;
import java.util.LinkedList;

public class Q32_从上往下打印二叉树 {
    /*
    问题描述：
    从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     */

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

        System.out.println(printFromTopToBottom(treeNode));

    }

}
