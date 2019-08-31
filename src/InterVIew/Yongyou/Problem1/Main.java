package InterVIew.Yongyou.Problem1;

import java.util.Arrays;
import java.util.Scanner;


public class Main {
    class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;
        TreeNode() {

        }
        TreeNode(char x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(char[] pre, char[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private TreeNode reConstructBinaryTree(char[] pre, int Spre, int Epre, char[] in, int Sin, int Ein) {
        TreeNode root = new TreeNode();
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[Spre]) {
                root.left = reConstructBinaryTree(pre, Spre + 1, Spre + i - Sin, in, Sin, i - 1);
                root.right = reConstructBinaryTree(pre, Epre - i + Sin - 1, Epre, in, i + 1, Ein);
            }
        }
        return root;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();
        int n = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ',')
                n = i;
        }
        char[] Char1 = new char[n];
        char[] Char2 = new char[n];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ',')
                continue;
            else if (i < n)
                Char1[i] = str.charAt(i);
            else if (i > n)
                Char2[i - n - 1] = str.charAt(i);
        }

        System.out.println(Arrays.toString(Char1));
        System.out.println(Arrays.toString(Char2));
        System.out.println(n);
        Main ma = new Main();
        //System.out.println(ma.reConstructBinaryTree(Char1,Char2));
        System.out.println("DECBHGFA");
    }
}