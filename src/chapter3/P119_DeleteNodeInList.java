package chapter3;

import model.ListNode;

/**
 * 删除链表的节点
 * <p>
 * 题目要求：
 * 在o(1)时间内删除单链表的节点。
 * <p>
 * <p>
 * 对于n-1非尾节点来说，O(1)
 * 对于尾节点，O（n）
 * <p>
 * 总体的时间复杂度 ((n-1)*O(1)+O(n))/n
 */
public class P119_DeleteNodeInList {

    /**
     * 将下一个节点往前复制
     */
    public static ListNode delete(ListNode root, ListNode delete) {
        if (root == null) {
            return null;
        }
        if (delete == null) {
            return root;
        }
        if (delete.next == null) {
            if (root == delete) {
                return null;
            } else {
                ListNode temp = root;
                while (temp.next != delete) {
                    temp = temp.next;
                }
                temp.next = null;
            }
        } else {
            ListNode next = delete.next;
            ListNode realNext = next.next;
            int value = next.value;
            delete.value = value;
            delete.next = realNext;
        }
        return root;
    }
}
