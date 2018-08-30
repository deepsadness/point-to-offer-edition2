package chapter3;

import model.ListNode;

/**
 * 链表中倒数第k个节点
 * <p>
 * 求链表中倒数第k个节点。链表的尾节点定义为倒数第1个节点。
 *
 * 这里要注意非法的情况。
 */
public class P134_KthNodeFromEnd {


    public static ListNode getKthNodeFromEnd(ListNode root, int end) {
        if (root == null || end == 0) {
            return null;
        }

        ListNode temp = root;
        //这里注意尾节点为1节点
        for (int i = 0; i < end - 1; i++) {
            temp = temp.next;
            if (temp == null) { //此时非法了。因为没有那么大的倒数值
                return null;
            }
        }
        ListNode startNode = root;

        while (temp.next != null) {
            temp = temp.next;
            startNode = startNode.next;
        }

        return startNode;
    }
}
