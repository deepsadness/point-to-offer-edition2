package chapter2;

import model.TreeNode;

/**
 * 重建二叉树
 * 题目要求：
 * 根据二叉树的前序遍历和中序遍历，重建该二叉树。
 */
public class P62_recreateBinaryTree {

    public static TreeNode recreateBinaryTree(int[] preOrder, int[] midOrder) {
        //前序遍历的第一个点，就是root
        if (preOrder == null || preOrder.length == 0) {
            return null;
        }
        TreeNode root = buildTreeNode(0, 0, midOrder.length - 1, preOrder, midOrder);
        return root;
    }

    private static TreeNode buildTreeNode(int preIndex, int midStart, int midEnd, int[] preOrder, int[] midOrder) {
        if (midStart > midEnd || preIndex >= preOrder.length) {
            return null;
        }
        TreeNode root;
        int rootValue = preOrder[preIndex];
        root = TreeNode.just(rootValue);

        int rootIndex = -1;
        for (int i = midStart; i <= midEnd; i++) {
            if (midOrder[i] == rootValue) {
                rootIndex = i;
            }
        }
        if (rootIndex == -1) {
            return null;
        }

        if (rootIndex == midStart) {  //无左节点
            root.left = null;
        } else {
            preIndex = preIndex + 1;
            root.left = buildTreeNode(preIndex, midStart, rootIndex - 1, preOrder, midOrder);
        }
        if (rootIndex == midEnd) {  //无右结点
            root.right = null;
        } else {
            preIndex = preIndex + (rootIndex - midStart);
            root.right = buildTreeNode(preIndex,rootIndex + 1, midEnd, preOrder, midOrder);
        }

        return root;
    }
    
}
