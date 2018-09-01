package chapter4;

import model.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class P176_printTreeTest {

    @Test
    public void printNormal() {
        TreeNode root = TreeNode.just(8);
        TreeNode node6 = root.left(6);
        TreeNode node10 = root.right(10);
        node6.left(5);
        node6.right(7);

        node10.left(9);
        node10.right(11);

        String s = P176_printTree.printNormal(root);
        Assert.assertEquals("8,6,5,7,10,9,11,", s);
    }

    @Test
    public void printNormal1() {
        TreeNode root = TreeNode.just(8);
        TreeNode node6 = root.left(6);
        TreeNode node10 = root.right(10);
//        node6.left(5);
        node6.right(7);

        node10.left(9);
//        node10.right(11);

        String s = P176_printTree.printNormal(root);
        Assert.assertEquals("8,6,7,10,9,", s);
    }

    @Test
    public void printUpDown() {
        TreeNode root = TreeNode.just(8);
        TreeNode node6 = root.left(6);
        TreeNode node10 = root.right(10);
        node6.left(5);
        node6.right(7);

        node10.left(9);
        node10.right(11);

        String s = P176_printTree.printUpDown(root);
        Assert.assertEquals("8,6,10,5,7,9,11,", s);
    }

    @Test
    public void printInLine() {
        TreeNode root = TreeNode.just(8);
        TreeNode node6 = root.left(6);
        TreeNode node10 = root.right(10);
        node6.left(5);
        node6.right(7);

        node10.left(9);
        node10.right(11);

        String result = "8\n" +
                "6,10\n" +
                "5,7,9,11";
        String s = P176_printTree.printInLineRecursive(root);
        Assert.assertEquals(result, s);
    }

    @Test
    public void printInLine1() {
        TreeNode root = TreeNode.just(8);
        TreeNode node6 = root.left(6);
        TreeNode node10 = root.right(10);
        node6.left(5);
        node6.right(7);

        node10.left(9);
//        node10.right(11);

        String result = "8\n" +
                "6,10\n" +
                "5,7,9";
        String s = P176_printTree.printInLineRecursive(root);
        Assert.assertEquals(result, s);
    }

    @Test
    public void printInSpeical() {
        TreeNode root = TreeNode.just(8);
        TreeNode node6 = root.left(6);
        TreeNode node10 = root.right(10);
        node6.left(5);
        node6.right(7);

        node10.left(9);
        node10.right(11);

        String result = "8\n" +
                "10,6\n" +
                "5,7,9,11";
        String s = P176_printTree.printInSpeical(root);
        Assert.assertEquals(result, s);
    }

    @Test
    public void printInSpeical1() {
        TreeNode root = TreeNode.just(8);
        TreeNode node6 = root.left(6);
        TreeNode node10 = root.right(10);
//        node6.left(5);
        node6.right(7);

        node10.left(9);
//        node10.right(11);

        String result = "8\n" +
                "10,6\n" +
                "7,9";
        String s = P176_printTree.printInSpeical(root);
        Assert.assertEquals(result, s);
    }

}