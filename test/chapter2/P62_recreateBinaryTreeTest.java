package chapter2;

import model.TreeNode;
import org.junit.Test;

/**
 * 1. 普通二叉树 完全二叉树
 * 2. 只有右节点的二叉树 ，只有左节点的  只有根节点的
 * 3. null
 */
public class P62_recreateBinaryTreeTest {
    @Test
    public void test() {
        int[] pre = {1, 2, 4, 5, 3};
        int[] mid = {4, 2, 5, 1, 3};

        TreeNode node = P62_recreateBinaryTree.recreateBinaryTree(pre, mid);
        System.out.println(node);
    }

    @Test
    public void testNull() {
        int[] pre = {};
        int[] mid = {};
        int[] pre2 = null;
        int[] mid2 = null;

        TreeNode node = P62_recreateBinaryTree.recreateBinaryTree(pre, mid);
        System.out.println(node);
    }
}