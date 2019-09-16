package sw.practice;

public class 求二叉树的高度 {
    /**
     * @param root
     * @return
     * @see 求二叉树的高度
     */
    public static int solution(TreeNode root) {
        if (root == null)
            return 0;
        int left = solution(root.left);     //左子树的高度
        int right = solution(root.right);   //右子树的高度
        return Math.max(left + 1, right + 1);    //左子树和右子树中较大的那个加1（根节点）就是这棵树的高度
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

        System.out.println(solution(treeNode));

    }
}
