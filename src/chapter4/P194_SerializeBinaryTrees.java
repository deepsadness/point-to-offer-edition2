package chapter4;

import model.TreeNode;

/**
 * 序列化二叉树
 * 实现两个函数，分别用来序列化和反序列化二叉树。
 * <p>
 * 根据之前的提示，我们可以用
 * 一个前序遍历和一个中序遍历，进行序列化和反序列化.
 * <p>
 * 这样的思路有两个问题
 * 1. 不能有重复的值
 * 2. 需要完全读出来才能反序列化
 */
public class P194_SerializeBinaryTrees {

    //序列化
    public static String serialize(TreeNode node) {
        if (node == null) {
            return null;
        }

        //进行前序遍历
        String preOderResult = preOder(node);
        return preOderResult;
    }


    private static String preOder(TreeNode node) {
        if (node == null) {
            return null;
        }
        String result = "" + node.value;
        TreeNode left = node.left;
        TreeNode right = node.right;

        if (left != null) {
            result = result + "," + preOder(left);
        } else {
            result = result + ",$";
        }
        if (right != null) {
            result = result + "," + preOder(right);
        } else {
            result = result + ",$";
        }
        return result;
    }

    //反序列化
    public static TreeNode deserialize(String serialize) {
        if (serialize == null || serialize.length() == 0) {
            return null;
        }
        return deserializeInternal(new StringBuilder(serialize));
    }

    private static TreeNode deserializeInternal(StringBuilder stringBuilder) {
        if (stringBuilder.length() == 0)
            return null;
        int end = stringBuilder.indexOf(",");
        String num;
        if (end != -1) {
            num = stringBuilder.substring(0, end);
            stringBuilder.delete(0, end);
            stringBuilder.deleteCharAt(0);
        } else {
            num = stringBuilder.toString();
        }

        if (num.equals("$"))
            return null;
        TreeNode node = TreeNode.just(Integer.parseInt(num));
        node.left = deserializeInternal(stringBuilder);
        node.right = deserializeInternal(stringBuilder);
        return node;
    }


}
