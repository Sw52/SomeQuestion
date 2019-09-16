package CodingInterview;


public class 二叉树的镜像 {

    /**
     * @see 操作给定的二叉树，将其变换为源二叉树的镜像。
     * @param root
     */
    public static void Mirror(TreeNode root) {
        if (root == null) //合法性判断
            return;
        TreeNode tmp = root.left;   //交换根节点的左右子树
        root.left = root.right;
        root.right = tmp;
        Mirror(root.left);  //递归修改左子树
        Mirror(root.right); //递归修改右子树
    }


    public static void main(String[] args) {

        /*  构建二叉树
                  1
                 / \
                2   5
               / \ / \
              3  4 6  7
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        二叉树的打印 printBinary = new 二叉树的打印();
        //层序
        printBinary.printBinaryTreeByLayer(root);
        System.out.println();

        Mirror(root);

        //层序
        printBinary.printBinaryTreeByLayer(root);
        System.out.println();
    }
}
