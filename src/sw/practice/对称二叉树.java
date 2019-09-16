package sw.practice;

/*
给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/symmetric-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 对称二叉树 {
    /**
     * @param root
     * @return 思路：
     * 一颗对称的二叉树满足：
     * 左右儿子相等，左子树和右子树对称
     * 而要满足左子树和右子树对称则需要满足以下：
     * 左儿子等于右儿子，且右子树的左子树等于左子树的右子树且右子树的右子树等于左子树的左子树
     * @see 判断一颗二叉树是不是对称二叉树
     */
    public static boolean solution(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    public static boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        return (left.val == right.val)    //左右儿子是否想等
                && isMirror(left.right, right.left)   //左儿子的右子树和右儿子的左子树是否对称
                && isMirror(left.left, right.right);  //左儿子的左子树和右儿子的右子树是否对称
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(22);
        root.left = p1;
        root.right = p2;
        System.out.println(solution(root));
    }
}
