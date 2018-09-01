package chapter4;

import model.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class P182_FindPathTest {

    @Test
    public void findPath() {
        TreeNode root = TreeNode.just(10);
        root.right(12);
        TreeNode node5 = root.left(5);
        node5.left(4);
        node5.right(7);

        String result = "[10,12]\n" +
                "[10,5,7]\n";
        String path = P182_FindPath.findPath(root, 22);
        Assert.assertEquals(result, path);
    }
}