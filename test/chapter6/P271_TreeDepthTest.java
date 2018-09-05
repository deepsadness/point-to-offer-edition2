package chapter6;

import model.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class P271_TreeDepthTest {
    TreeNode root;

    @Before
    public void init() {
        root = TreeNode.just(1);
        root.left = TreeNode.just(2);
        root.left.left = TreeNode.just(4);
        root.left.right = TreeNode.just(5);
        root.left.right.left = TreeNode.just(7);
        root.right = TreeNode.just(3);
        root.right.right = TreeNode.just(6);
    }

    @Test
    public void getTreeDepth() {
        Assert.assertEquals(4,P271_TreeDepth.getTreeDepth(root));

    }

    @Test
    public void getTreeDepth2() {
        Assert.assertEquals(4,P271_TreeDepth.getTreeDepth2(root));
    }
}