package CodingInterview;


public class Q7_二叉树重构 {

    /**
     * ---------------------------------------------------------------------------------------------------------------------
     * <p>
     * 二叉树重构代码有问题，！！！！！！！！
     * <p>
     * --------------------------------------------------------------------------------------------------------------------
     *
     * @param pre
     * @param pre_start
     * @param pre_end
     * @param in
     * @param in_start
     * @param in_end
     * @return
     */
    public static TreeNode constructCore(int[] pre, int pre_start, int pre_end, int[] in, int in_start, int in_end) {
        int rootValue = pre[0];
        TreeNode root = new TreeNode(rootValue);
        root.left = root.right = null;

        if (pre_start == pre_end) {
            if (in_start == in_end) {
                return root;
            } else
                System.out.println("输入有误");
        }
        int root_Inorder = in_start;
        while (root_Inorder <= in_end && in[root_Inorder] != rootValue) {
            ++root_Inorder;
        }
        if (root_Inorder == in_end && in[root_Inorder] != rootValue) {
            System.out.println("输入有误");
        }

        int leftLength = root_Inorder - in_start;
        int leftPreorderEnd = pre_start + leftLength;
        if (leftLength > 0) {
            root.left = constructCore(pre, pre_start + 1, pre_start + leftLength, in, in_start, in_end + leftLength - 1);
        }
        if (leftLength < pre_end - pre_start) {
            root.right = constructCore(pre, leftPreorderEnd + 1, pre_end, in, in_start + 1, in_end);
        }
        return root;

    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        if (pre == null || in == null)
            return null;

        return constructCore(pre, 0, 7, in, 0, 7);
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 3, 4, 5, 6, 7};
        int[] in = {3, 2, 4, 1, 6, 5, 7};
        System.out.println(reConstructBinaryTree(pre, in));
    }
}
