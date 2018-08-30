package chapter4;

import model.TreeNode;

/**
 * 二叉树的镜像
 * 求一棵二叉树的镜像。
 */
public class P151_MirrorOfBinaryTree {
    public static TreeNode mirror(TreeNode old) {
        if (old == null) {
            return null;
        }

        TreeNode temp = old;
        TreeNode right = old.right;
        TreeNode left = old.left;

        if (right != null) {
            temp.left = mirror(right);
        }
        if (left != null) {
            temp.right = mirror(left);
        }

        return temp;
    }
}
