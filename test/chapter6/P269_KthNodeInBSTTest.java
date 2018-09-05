package chapter6;

import model.TreeNode;
import org.junit.Test;

public class P269_KthNodeInBSTTest {

    @Test
    public void findKth() {
        TreeNode root = TreeNode.just(5);
        TreeNode node3 = root.left(3);
        TreeNode node5 = root.right(7);
        node3.left(2);
        node3.right(4);

        node5.left(6);
        node5.right(8);

        int kth = P269_KthNodeInBST.findKth(root, 3);
        System.out.println(kth);
    }
}