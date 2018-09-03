package chapter4;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉搜索树与双向链表
 * <p>
 * 一个二叉树如果想成为二叉查找树需要满足以下条件：
 * (1)若任意节点的左子树不空，则左子树上所有结点的值均小于或等于它的根结点的值；
 * (2)若任意节点的右子树不为空，则右子树上所有节点的值均大于或等于根节点的值；
 * (3)任意节点的左、右子树也分别为二叉查找树。
 * <p>
 * 输入一颗二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 不能创建任何新的节点，只能调整树中节点指针的指向。
 * <p>
 * == 中序遍历？
 */
public class P191_ConvertBinarySearchTree {
    //使用中序遍历+队列。 使用队列的方案，提高了空间复杂度。
    public static TreeNode convertWithQueue(TreeNode root) {
        if (root == null || (root.right == null && root.left == null)) {
            return root;
        }
        TreeNode head = null;
        Queue<TreeNode> queue = new LinkedList<>();
        //中旬遍历
        travel(root, queue);

        TreeNode preTemp = null;

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            TreeNode after = queue.peek();
            if (head == null) {
                head = cur;
            }
            cur.left = preTemp;
            cur.right = after;
            preTemp = cur;
        }
        if (preTemp != null) {
            preTemp.right = null;
        }

        return head;
    }

    private static void travel(TreeNode node, Queue<TreeNode> queue) {
        if (node == null) {
            return;
        }
        travel(node.left, queue);
        visit(node, queue);
        travel(node.right, queue);
    }

    private static void visit(TreeNode node, Queue<TreeNode> queue) {
        queue.offer(node);
    }


    //使用中序遍历+队列。
    public static TreeNode convert(TreeNode root) {
        if (root == null || (root.right == null && root.left == null)) {
            return root;
        }
        return midTravelConvert(root);
    }

    /**
     * 如果只有一个高为2的子树时
     * 1. 子树为完全二叉树时，就可以用中序遍历来处理这个子树。
     * 2. 本身就时有序的，需要将子节点指回父节点
     * <p>
     * 其他情况就继续递归
     */
    private static TreeNode midTravelConvert(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode head = needMidTravel(root);
        //遍历得到头部
        while (head.left != null) {
            head = head.left;
        }
        return head;
    }

    private static TreeNode needMidTravel(TreeNode root) {
        if (root == null) {
            return root;
        }
        //终止条件
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null && right != null && left.left == null && left.right == null && right.left == null && right.right == null) {
            //这个就需要中序遍历
            left.right = root;
            right.left = root;
            return root;
        }
        //如果
        if (left != null && right == null && left.left == null && left.right == null) {
            left.right = root;
            return root;
        }

        if (right != null && left == null && right.left == null && right.right == null) {
            right.left = root;
            return root;
        }

        TreeNode tf = needMidTravel(left);
        if (tf != null && tf.right != null) {
            root.left = tf.right;
            tf.right.right = root;
        } else {
            root.left = null;
        }
        TreeNode tR = needMidTravel(right);
        if (tR != null && tR.left != null) {
            root.right = tR.left;
            tR.left.left = root;
        } else {
            root.right = null;
        }
        //其他情况，要继续遍历
        return root;
    }

    private static TreeNode midTravelConvertRight(TreeNode right) {

        return null;
    }

    /**
     * 1. 如果有左右子树，就需要切断
     */
    public static TreeNode covert2(TreeNode root) {


        return null;
    }
}
