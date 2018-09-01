package chapter4;

import model.TreeNode;

/**
 * 二叉树中和为某一值的路径
 * <p>
 * 输入一棵二叉树和一个整数(路径上所有节点的和)，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 */
public class P182_FindPath {
    public static String findPath(TreeNode node, int count) {
        if (node == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int value = node.value;
        String result = "[" + value;
        if (value != count) {
            if (node.right != null) {
                pathToNext(node.right, value, count, result, stringBuilder);
            }
            if (node.left != null) {
                pathToNext(node.left, value, count, result, stringBuilder);
            }
        } else {
            //如果相等，就直接打印了。
            return result + "]";
        }
        return stringBuilder.toString();
    }

    private static void pathToNext(TreeNode node, int temp, int count, String result, StringBuilder stringBuilder) {
        result += "," + node.value;
        temp += node.value;
        if (temp != count) {
            if (node.right != null) {
                pathToNext(node.right, temp, count, result, stringBuilder);
            }
            if (node.left != null) {
                pathToNext(node.left, temp, count, result, stringBuilder);
            }
        } else {
            //如果相等，就直接打印了。
            stringBuilder.append(result).append("]").append("\n");
        }
    }
}
