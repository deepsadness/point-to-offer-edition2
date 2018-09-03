package chapter4;

import model.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class P191_ConvertBinarySearchTreeTest {

    @Test
    public void convert() {
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

        TreeNode head = P191_ConvertBinarySearchTree.convertWithQueue(node10);
        if (head != null) {
            String stringBuilder = getDoubleLinkTreeString(head);
            String result = "4(_,6)\t6(4,8)\t8(6,10)\t10(8,12)\t12(10,14)\t14(12,16)\t16(14,_)";
            Assert.assertEquals(result, stringBuilder);
        } else {
            Assert.assertNotNull(head);
        }
    }

    @Test
    public void convert2() {
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

        TreeNode head2 = P191_ConvertBinarySearchTree.convert(node10);

        String stringBuilder2 = getDoubleLinkTreeString(head2);
        String result = "4(_,6)\t6(4,8)\t8(6,10)\t10(8,12)\t12(10,14)\t14(12,16)\t16(14,_)";
        Assert.assertEquals(result, stringBuilder2);

    }

    private String getDoubleLinkTreeString(TreeNode head) {
        if (head == null) {
            return "";
        }
        TreeNode temp = head;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(head.value);
        while (temp.right != null) {
            stringBuilder
                    .append("(")
                    .append(temp.left != null ? temp.left.value : "_")
                    .append(",")
                    .append(temp.right.value)
                    .append(")")
                    .append("\t");
            temp = temp.right;
            stringBuilder.append(temp.value);
        }
        stringBuilder
                .append("(")
                .append(temp.left != null ? temp.left.value : "_")
                .append(",_)");
        return stringBuilder.toString();
    }
}