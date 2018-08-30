package chapter2;

import model.ParentTreeNode;

/**
 * 二叉树的下一个节点
 * <p>
 * 题目要求：
 * 给定二叉树和其中一个节点，找到中序遍历序列的下一个节点。
 * 树中的节点除了有左右孩子指针，还有一个指向父节点的指针。
 * <p>
 * 思路
 * 1. 如果有右孩子，则是由孩子的第一个左孩子。没有左孩子，就是右孩子，没有有孩子，就她
 * 2. 如果没有右孩子，是否有父节点，没有父节点，则为null
 * 3. 有父节点，就看自己是左孩子，则为父节点。如果父节点没有左孩子，则为父节点
 * 4. 自己是右孩子，如节点没有左孩子，则直接为附件点，父节点有左孩子，则将父节点输入，重复2开始的步骤
 */
public class P65_NodeUnderTree {
    public static ParentTreeNode getNextByInOrder(ParentTreeNode target) {
        if (target == null) {
            return null;
        }

        if (target.right != null) {
            return getDirectRightTreeNode(target.right);
        } else {
            return getParentTreeNode(target);
        }
    }

    private static ParentTreeNode getParentTreeNode(ParentTreeNode target) {
        if (target.parent == null) {
            return null;
        }
        ParentTreeNode parent = target.parent;
        //如果自己是做节点，或者parent没有左节点
        if (target.equals(parent.left) || parent.left == null) {
            return parent;
        } else {
            //将父节点带入计算
            return getParentTreeNode(parent);
        }
    }

    private static ParentTreeNode getDirectRightTreeNode(ParentTreeNode parent) {
        //如果左节点不为null,则找到最后一个左节点
        ParentTreeNode left = parent.left;
        if (left != null) {
            ParentTreeNode temp = left;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }

        ParentTreeNode right = parent.right;
        if (right != null) {
            //右节点不为空。则再次通过这个方法去找
            return getDirectRightTreeNode(right);
        }

        //没有子节点。就是自己
        return parent;
    }
}
