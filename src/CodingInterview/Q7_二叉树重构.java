package CodingInterview;


public class Q7_二叉树重构 {


    /**
     * @param preOrder
     * @param inOrder
     * @return
     * @see 由先序和中序重建二叉树
     */
    public static TreeNode reConstructBinaryTree(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null)
            return null;
        return reConstructBinaryTreeCore(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    /**
     * @param preOrder
     * @param startPre
     * @param endPre
     * @param inOrder
     * @param startIn
     * @param endIn
     * @return
     * @see 由先序和中序重建二叉树
     */
    private static TreeNode reConstructBinaryTreeCore(int[] preOrder, int startPre, int endPre, int[] inOrder, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn)
            return null;
        TreeNode root = new TreeNode(preOrder[startPre]); //先序的第一个元素就是根节点
        for (int i = startIn; i <= endIn; i++)
            if (inOrder[i] == preOrder[startPre]) {       //找到根节点在中序的位置
                root.left = reConstructBinaryTreeCore(preOrder, startPre + 1, startPre + i - startIn, inOrder, startIn, i - 1); //递归确定左子树
                root.right = reConstructBinaryTreeCore(preOrder, i - startIn + startPre + 1, endPre, inOrder, i + 1, endIn);    //递归确定右子树
                break;
            }
        return root;
    }


    /**
     * 测试函数
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] pre = {1, 2, 3, 4, 5, 6, 7};
        int[] in = {3, 2, 4, 1, 6, 5, 7};

        TreeNode treeNode = reConstructBinaryTree(pre, in);
        二叉树的打印 printBinary = new 二叉树的打印();
        //先序
        System.out.print("先序：　");
        printBinary.printBinaryTreePreOrder(treeNode);
        System.out.println();
        //中序
        System.out.print("中序：　");
        printBinary.printBinaryTreeInOrder(treeNode);
        System.out.println();
        //后序
        System.out.print("后序：　");
        printBinary.printBinaryTreeByPostOrder(treeNode);
        System.out.println();
    }
}
