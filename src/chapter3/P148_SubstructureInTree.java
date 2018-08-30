package chapter3;

import model.TreeNode;

/**
 * 树的子结构
 * <p>
 * 输入两棵二叉树A和B，判断B是不是A的子结构。
 */
public class P148_SubstructureInTree {

    public static boolean isSubstructure(TreeNode tree, TreeNode subTree) {
        if (tree == null || subTree == null) {
            return false;
        }
        int temp = subTree.value;
        //对其进行遍历
        if (tree.value != temp) {   //如果当前的节点不相等
            //就像左节点和右节点接着往里面传
            return isSubstructure(tree.left, subTree) || isSubstructure(tree.right, subTree);
        } else { //相同
            //如果没有子树时，相同
            if (subTree.left == null && subTree.right == null) {
                return true;
            } else if (subTree.left != null && subTree.right != null) {
                return (isSubstructure(tree.left, subTree.left) && isSubstructure(tree.right, subTree.right)) ||
                        //虽然相等了。但是还是可以继续接着往下找有没有子树
                        isSubstructure(tree.left, subTree) ||
                        isSubstructure(tree.right, subTree)
                        ;
            } else if (subTree.left != null) {
                return isSubstructure(tree.left, subTree.left)||
                        //虽然相等了。但是还是可以继续接着往下找有没有子树
                        isSubstructure(tree.left, subTree) ||
                        isSubstructure(tree.right, subTree);
            } else {
                return isSubstructure(tree.right, subTree.right)||
                        //虽然相等了。但是还是可以继续接着往下找有没有子树
                        isSubstructure(tree.left, subTree) ||
                        isSubstructure(tree.right, subTree);
            }
        }
    }

}
