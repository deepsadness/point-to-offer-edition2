package chapter4;

import model.TreeNode;
import org.junit.Test;

public class P194_SerializeBinaryTreesTest {

    @Test
    public void serialize() {
        TreeNode node10 = TreeNode.just(10);

        TreeNode node6 = node10.left(6);
        TreeNode node14 = node10.right(14);

        node6.left(4);
        node6.right(8);

        node14.left(12);
        node14.right(16);

        //result
        TreeNode node41 = TreeNode.just(4);
        TreeNode node61 = TreeNode.just(6);
        TreeNode node81 = TreeNode.just(8);
        TreeNode node101 = TreeNode.just(10);
        TreeNode node121 = TreeNode.just(12);
        TreeNode node141 = TreeNode.just(14);
        TreeNode node161 = TreeNode.just(16);

        node41.left = null;
        node41.right = node61;

        node61.left = node41;
        node61.right = node81;

        node81.left = node61;
        node81.right = node101;

        node101.left = node81;
        node101.right = node121;

        node121.left = node101;
        node121.right = node141;

        node141.left = node121;
        node141.right = node161;

        node161.left = node141;
        node161.right = null;

        String serialize = P194_SerializeBinaryTrees.serialize(node10);
        TreeNode node = P194_SerializeBinaryTrees.deserialize(serialize);
        System.out.println(node.toString());


    }

    @Test
    public void deserialize() {
    }
}