package chapter3;

import model.ListNode;

/**
 * 链表中环的入口节点
 * 假设一个链表中包含环，请找出入口节点。若没有环则返回null。
 */
public class P139_findRingStart {
    //这是遍历的思想
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

    /**
     * 观察可以发现。同样可以遍历链表。然后一起移动。如果有回环，就会遇到
     */
    public static ListNode findRingStart2(ListNode root) {
        //得到相遇的节点。如果能够相遇，则说明一定有ring
        ListNode meetNode = getMeetNode(root);
        if (meetNode == null) {
            return null;
        }
        int count = 1;
        ListNode node1 = meetNode;
        //再相遇的点和起始点，再一次一起出发。再次相遇时，就是ring的入口
        while (node1.next != null && node1.next != meetNode) {
            count++;
            node1 = node1.next;
        }

        node1 = root;
        for (int i = 0; i < count; i++) {
            node1 = node1.next;
        }

        ListNode node2 = root;
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;

    }

    private static ListNode getMeetNode(ListNode root) {
        if (root == null || root.next == null) {
            return null;
        }
        ListNode slow = root.next;
        ListNode fast = slow.next;

        while (fast != null && slow != null) {
            if (fast == slow) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return null;
    }
}
