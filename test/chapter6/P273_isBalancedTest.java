package chapter6;

import model.TreeNode;
import org.junit.Test;

public class P273_isBalancedTest {

    @Test
    public void isBalance() {
        TreeNode root = TreeNode.just(1);
        root.left = TreeNode.just(2);
        root.left.left = TreeNode.just(4);
        root.left.right = TreeNode.just(5);
        root.left.right.left = TreeNode.just(7);
        root.right = TreeNode.just(3);
        root.right.right = TreeNode.just(6);
        System.out.println(P273_isBalanced.isBalance(root));
//        System.out.println(isBalanced2(root));
    }

    @Test
    public void isBalance21() {
        TreeNode root = TreeNode.just(1);
        root.left = TreeNode.just(2);
        root.left.left = TreeNode.just(4);
        root.left.right = TreeNode.just(5);
        root.left.right.left = TreeNode.just(7);
        root.right = TreeNode.just(3);
        root.right.right = TreeNode.just(6);
        System.out.println(P273_isBalanced.isBalanced2(root));
//        System.out.println(isBalanced2(root));
    }

    @Test
    public void isBalance2() {
        TreeNode root = TreeNode.just(1);
        root.left = TreeNode.just(2);
        root.left.left = TreeNode.just(4);
        root.left.right = TreeNode.just(5);
        root.left.right.left = TreeNode.just(7);
        root.left.right.left.left = TreeNode.just(9);
        root.right = TreeNode.just(3);
        root.right.right = TreeNode.just(6);
        System.out.println(P273_isBalanced.isBalance(root));
//        System.out.println(isBalanced2(root));
    }

    @Test
    public void isBalance22() {
        TreeNode root = TreeNode.just(1);
        root.left = TreeNode.just(2);
        root.left.left = TreeNode.just(4);
        root.left.right = TreeNode.just(5);
        root.left.right.left = TreeNode.just(7);
        root.left.right.left.left = TreeNode.just(9);
        root.right = TreeNode.just(3);
        root.right.right = TreeNode.just(6);
        System.out.println(P273_isBalanced.isBalanced2(root));
//        System.out.println(isBalanced2(root));
    }
}