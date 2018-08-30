package chapter4;

import model.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class P159_SymmetricalBinaryTreeTest {

    @Test
    public void isSymmetric() {
        TreeNode root = TreeNode.just(1);
        TreeNode left2 = root.left(2);
        TreeNode right2 = root.right(2);
        left2.left(5);
        right2.right(5);
        Assert.assertTrue(P159_SymmetricalBinaryTree.isSymmetric(root));

    }

    @Test
    public void isSymmetricNo1() {
        TreeNode root = TreeNode.just(1);
        TreeNode left2 = root.left(2);
        TreeNode right2 = root.right(3);
        left2.left(5);
        right2.right(5);
        Assert.assertFalse(P159_SymmetricalBinaryTree.isSymmetric(root));

    }

    @Test
    public void isSymmetricNo2() {
        TreeNode root = TreeNode.just(1);
        TreeNode left2 = root.left(2);
        TreeNode right2 = root.right(2);
        left2.left(5);
        left2.right(5);
        right2.right(5);
        Assert.assertFalse(P159_SymmetricalBinaryTree.isSymmetric(root));
    }
}