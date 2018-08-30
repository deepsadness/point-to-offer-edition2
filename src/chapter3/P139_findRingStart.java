package chapter3;

import model.ListNode;

/**
 * 链表中环的入口节点
 * 假设一个链表中包含环，请找出入口节点。若没有环则返回null。
 */
public class P139_findRingStart {
    public static ListNode findRingStart(ListNode root) {
        if (root == null || root.next == null) {
            return null;
        }

        ListNode ahead = root;
        int aheadIndex = 0;

        while (ahead.next != null) {
            ahead = ahead.next;
            aheadIndex++;
            int behindIndex = 0;
            ListNode behind = root;
            while (behind != null && behindIndex < aheadIndex) {
                if (ahead != behind) {
                    behindIndex++;
                    behind = behind.next;
                } else {
                    //找到了。
                    return behind;
                }
            }
        }
        return null;
    }

}
