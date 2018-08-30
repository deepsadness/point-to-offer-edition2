package chapter4;

import model.TreeNode;

/**
 * 对称的二叉树
 * 判断一棵二叉树是不是对称的。如果某二叉树与它的镜像一样，称它是对称的。
 */
public class P159_SymmetricalBinaryTree {
    public static boolean isSymmetric(TreeNode node) {
        if (node == null) {
            return false;
        }

        TreeNode right = node.right;
        TreeNode left = node.left;

        return right == null && left == null || right != null && left != null && right.value == left.value && equalsLeftAndRight(right, left);
    }

    private static boolean equalsLeftAndRight(TreeNode rightHead, TreeNode leftHead) {
        //相对镜像的是一组
        TreeNode rightRight = rightHead.right;
        TreeNode leftLeft = leftHead.left;

        TreeNode rightLeft = rightHead.left;
        TreeNode leftRight = leftHead.right;

        //全部为空，也是对的
        if (rightRight == null && leftRight == null && rightLeft == null && leftLeft == null) {
            return true;
        }else if (rightRight != null && leftLeft != null &&rightLeft != null && leftRight != null && rightRight.value == leftLeft.value &&rightLeft.value == leftRight.value ) {
            return equalsLeftAndRight(rightRight, leftLeft) && equalsLeftAndRight(rightLeft, leftRight);
        }else if (rightRight != null && leftLeft != null && rightLeft == null && leftRight == null && rightRight.value == leftLeft.value){
            return equalsLeftAndRight(rightRight, leftLeft);
        }else if (rightLeft != null && leftRight != null && rightRight == null && leftLeft == null && rightLeft.value == leftRight.value){
            return equalsLeftAndRight(rightLeft, leftRight);
        }else {
            return false;
        }
    }
}
