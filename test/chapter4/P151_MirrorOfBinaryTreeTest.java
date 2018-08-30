package chapter4;

import model.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class P151_MirrorOfBinaryTreeTest {

    @Test
    public void mirror() {
        TreeNode root = TreeNode.just(8);
        TreeNode left6 = root.left(6);
        TreeNode right10 = root.right(10);
        left6.left(5);
        left6.right(7);

        right10.left(9);
        right10.right(11);

        TreeNode mirror = TreeNode.just(8);
        TreeNode left10 = mirror.left(10);
        TreeNode right6 = mirror.right(6);
        right6.left(7);
        right6.right(5);

        left10.left(11);
        left10.right(9);


        TreeNode mirror1 = P151_MirrorOfBinaryTree.mirror(root);

        Assert.assertEquals(mirror, mirror1);
    }


    @Test
    public void mirror1() {
        TreeNode root = TreeNode.just(8);
        TreeNode left6 = root.left(6);
        TreeNode right10 = root.right(10);
        left6.left(5);
        left6.right(8);

        right10.left(9);
        right10.right(11);

        TreeNode mirror = TreeNode.just(8);
        TreeNode left10 = mirror.left(10);
        TreeNode right6 = mirror.right(6);
        right6.left(7);
        right6.right(5);

        left10.left(11);
        left10.right(9);


        TreeNode mirror1 = P151_MirrorOfBinaryTree.mirror(root);

        Assert.assertNotEquals(mirror, mirror1);
    }
}