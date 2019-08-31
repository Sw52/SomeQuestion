package CodingInterview;

public class 二叉树的打印 {

    /**
     * @param treeNode
     * @author SwYoung
     * @see 二叉树的先序打印
     */
    public void printBinaryTreePreOrder(TreeNode treeNode) {
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


    }


}
