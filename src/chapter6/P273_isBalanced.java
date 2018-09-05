package chapter6;

import model.TreeNode;

/**
 * 平衡二叉树
 * <p>
 * 输入二叉树的根节点，判断该树是否是平衡二叉树。
 * 如果某二叉树的任意节点的左右子树深度之差不超过1，则该树是平衡二叉树。
 */
public class P273_isBalanced {
    //求树的深度
    public static boolean isBalance(TreeNode root) {
        if (root == null) {
            return false;
        }

        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = getTreeDepth(root.left);
        }
        if (root.right != null) {
            right = getTreeDepth(root.right);
        }

        if (root.right == null && root.left == null) {
            return true;
        } else if (root.right != null && root.left == null) {
            return right <= 1 & isBalance(root.right);
        } else if (root.left != null && root.right == null) {
            return left <= 1 & isBalance(root.left);
        } else {
            return (Math.abs(left - right) <= 1) && isBalance(root.right) && isBalance(root.left);
        }
    }

    private static int getTreeDepth(TreeNode root) {
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

    //用后序遍历，并记录每个节点的深度，从而可以通过一次遍历完成整棵树的判断
    public static boolean isBalanced2(TreeNode node){
        if(node==null)
            return true;
        return isBalanced2Core(node,new int[]{0});
    }

    public static boolean isBalanced2Core(TreeNode node,int[] depth){
        if(node==null){
            depth[0] = 0;
            return true;
        }
        int[] left = new int[]{0};
        int[] right = new int[]{0};
        if(isBalanced2Core(node.left,left)&&isBalanced2Core(node.right,right)){
            int diff = left[0]-right[0];
            if(diff<=1&&diff>=-1){
                depth[0] = 1+(left[0]>right[0]?left[0]:right[0]);
                return true;
            }
            else
                return false;
        }
        return false;
    }
}
