package chapter3;

import model.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class P148_SubstructureInTreeTest {

    @Test
    public void isSubstructure() {
        TreeNode root = TreeNode.just(8);

        TreeNode node8 = root.left(8);
        root.right(7);

        node8.left(9);
        TreeNode node2 = node8.right(2);

        node2.left(4);
        node2.right(7);

        TreeNode subTree = TreeNode.just(8);
        subTree.left(9);
        subTree.right(2);


        Assert.assertTrue(P148_SubstructureInTree.isSubstructure(root, subTree));

    }

    @Test
    public void isSubstructure1() {
        TreeNode root = TreeNode.just(8);

        TreeNode node8 = root.left(8);
        root.right(7);

        node8.left(9);
        TreeNode node2 = node8.right(2);

        node2.left(4);
        node2.right(7);

        TreeNode subTree = TreeNode.just(8);
        subTree.left(9);
        subTree.right(2).left(4);


        Assert.assertTrue(P148_SubstructureInTree.isSubstructure(root, subTree));

    }
    @Test
    public void isSubstructure2() {
        TreeNode root = TreeNode.just(8);

        TreeNode node8 = root.left(8);
        node8.left(9);
        node8.right(7);

        TreeNode node2 = node8.right(2);
        node2.left(4);
        node2.right(7);

        TreeNode subTree = TreeNode.just(8);

        Assert.assertTrue(P148_SubstructureInTree.isSubstructure(root, subTree));

    }

    @Test
    public void isSubstructure3() {
        TreeNode root = TreeNode.just(8);

        TreeNode node8 = root.left(8);
        node8.left(9);
        node8.right(7);

        TreeNode node2 = node8.right(2);
        node2.left(4);
        node2.right(7);

        TreeNode subTree = TreeNode.just(8);
        subTree.left(8);
        subTree.right(3);

        Assert.assertFalse(P148_SubstructureInTree.isSubstructure(root, subTree));

    }
}