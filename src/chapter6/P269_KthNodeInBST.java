package chapter6;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉搜索树的第k大节点
 * <p>
 * 找出二叉搜索树的第k大节点。
 * 例如，在下图的树里，第3大节点的值为4，输入该树的根节点，3，则输出4。
 * <p>
 * 5
 * /   \
 * 3     7
 * / \   / \
 * 2   4 6   8
 */
public class P269_KthNodeInBST {
    public static int findKth(TreeNode root, int k) {
        if (root == null || k < 1) {
            return -1;
        }

        //中序遍历
        List<TreeNode> list = new ArrayList<>();
        midOderTravel(root, k, list);
        if (list.size() >= k) {
            return list.get(k - 1).value;
        } else {
            return -1;
        }
    }

    private static void midOderTravel(TreeNode root, int k, List<TreeNode> list) {
        if (list.size() >= k) {
            return;
        }
        if (root != null) {
            midOderTravel(root.left, k, list);
            list.add(root);
            midOderTravel(root.right, k, list);
        }
    }

    public static int findKth2(TreeNode root, int k) {
        if (root == null || k < 1) {
            return -1;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        int count = 0;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                count++;
                if (count == k){
                    return temp.value;
                }
                temp = temp.right;
            }
        }
        //中序遍历
        return -1;
    }

}
