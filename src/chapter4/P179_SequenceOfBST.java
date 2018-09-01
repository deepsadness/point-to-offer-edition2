package chapter4;

/**
 * 二叉搜索树的后序遍历
 * <p>
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果，假设输入数组的任意两个数都互不相同。
 * <p>
 * 1.后续遍历的最后是根节点
 * 2.数组可以分为两边。左边比根节点小，右边比根节点大。
 * 3.数组长度为2，一定能够组成BST
 */
public class P179_SequenceOfBST {
   public static boolean verifySquenceOfBST2(int[] data) {
        if (data == null || data.length == 0) {
            return false;
        }
        return verifySquenceOfBSTRecursive2(data, 0, data.length - 1);
    }

    private static boolean verifySquenceOfBSTRecursive2(int[] data, int start, int end) {
        if (start >= end - 1) {
            return true;
        }
        int root = data[end];
        int index = 0;
        //左边的节点小于root
        while (index < end) {
            if (data[index] > root) {
                break;
            }
            index++;
        }
        int midIndex = index ;
        //右边的节点大于root
        while (index < end) {
            if (data[index] < root) {
                return false;
            }
            index++;
        }
        return verifySquenceOfBSTRecursive2(data, start, midIndex - 1) && verifySquenceOfBSTRecursive2(data, midIndex, end - 1);

    }
}
