package chapter5;

import model.ListNode;

import java.util.Stack;

/**
 * 两个链表的第一个公共节点
 * <p>
 * 输入两个单链表，找出它们的第一个公共节点。以下图为例，对一个公共节点为6所在的节点。
 * <p>
 * 1 -> 2 -> 3 -> 6 -> 7
 * 4 -> 5 ↗
 */
public class P253_CommonNodesInLists {
    public static ListNode findCommonNode1(ListNode node1, ListNode node2) {
        if (node1 == null || node2 == null) {
            return null;
        }


        //反转链表不行，因为会改变原来的链表，连在一起的
        Stack<ListNode> stackNode1 = new Stack<>();
        while (node1 != null) {
            stackNode1.push(node1);
            node1 = node1.next;
        }

        Stack<ListNode> stackNode2 = new Stack<>();
        while (node2 != null) {
            stackNode2.push(node2);
            node2 = node2.next;
        }
        ListNode common = null;
        while (!stackNode1.isEmpty() && !stackNode2.isEmpty() && stackNode1.peek().value == stackNode2.peek().value) {
            common = stackNode1.pop();
            stackNode2.pop();
        }
        return common;
    }

    //反向遍历
    public static ListNode findCommonNode2(ListNode node1, ListNode node2) {
        if (node1 == null || node2 == null) {
            return null;
        }

        int length1 = getLength(node1);
        int length2 = getLength(node2);
        ListNode common = null;
        if (length1 > length2) {
            int offset = length1 - length2;
            common = getListNode(node1, node2, offset);
        } else {
            int offset = length2 - length1;
            common = getListNode(node2, node1, offset);
        }
        return common;

    }

    private static ListNode getListNode(ListNode ahead, ListNode after, int offset) {
        ListNode common = null;

        while (ahead.next != null && offset > 0) {
            offset--;
            ahead = ahead.next;
        }
        //同时开始。遇到相同的，就是结束
        while (ahead != after && ahead.next != null && after.next != null) {
            ahead = ahead.next;
            after = after.next;
        }

        if (ahead == after) {
            common = ahead;
        }
        return common;
    }

    private static int getLength(ListNode node1) {
        int length = 1;
        ListNode temp = node1;
        while (temp.next != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }
}
