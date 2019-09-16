package CodingInterview;
/*
题目描述
输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class 树的子结构 {
    /**
     * @see 判断一颗树是不是另一颗树的子结构
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        //当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
        if (root1 == null || root2 == null)
            return false;
        boolean result = false;
        //如果找到了对应Tree2的根节点的点
        if (root1.val == root2.val) {
            //以这个根节点为为起点判断是否包含Tree2
            result = treeEquals(root1, root2);
        }
        if (!result)//如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
            result = HasSubtree(root1.left, root2);
        if (!result)//如果找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
            result = HasSubtree(root1.right, root2);
        return result;//返回结果
    }

    /**
     * 匹配树的子结构
     * @param root1
     * @param root2
     * @return
     */
    public boolean treeEquals(TreeNode root1, TreeNode root2) {
        //如果Tree2已经遍历完了都能对应的上，返回true
        if (root2 == null)
            return true;
        //如果Tree2还没有遍历完，Tree1却遍历完了。返回false
        if (root1 == null)
            return false;
        //如果其中有一个点没有对应上，返回false
        if (root1.val != root2.val)
            return false;
        //如果根节点对应的上，那么就分别去子节点里面匹配
        return treeEquals(root1.left, root2.left) && treeEquals(root1.right, root2.right);
    }
}
