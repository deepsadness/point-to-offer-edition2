package chapter6;

import model.TreeNode;

import java.util.Stack;

/**
 * 二叉树的深度
 * <p>
 * 求二叉树的深度。仅仅包含一个根节点的二叉树深度为1。
 * <p>
 * 1.递归
 * 2.层次遍历
 */
public class P271_TreeDepth {
    public static int getTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int cur = 1;
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = getTreeDepth(root.left);
        }
        if (root.right != null) {
            right = getTreeDepth(root.right);
        }
        //左子树的高度和右子树的高度的最大值
        int max = Math.max(left, right);
        return cur + max;
    }

    public static int getTreeDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);
        int count = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) {
                count++;
            }
            while (!stack1.isEmpty()) {
                TreeNode pop = stack1.pop();
                if (pop.left != null) {
                    stack2.push(pop.left);
                }
                if (pop.right != null) {
                    stack2.push(pop.right);
                }
            }
            if (!stack2.isEmpty()) {
                count++;
            }
            while (!stack2.isEmpty()) {
                TreeNode pop = stack2.pop();
                if (pop.left != null) {
                    stack1.push(pop.left);
                }
                if (pop.right != null) {
                    stack1.push(pop.right);
                }
            }
        }

        return count;
    }

}
