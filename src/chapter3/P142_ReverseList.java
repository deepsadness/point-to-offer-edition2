package chapter3;

import model.ListNode;

/**
 * 反转链表
 */
public class P142_ReverseList {

    public static ListNode reverseList(ListNode root) {
        if (root == null || root.next == null) {
            return root;
        }
        ListNode next = root;
        int count = 0;
        while (next.next != null) {
            next = next.next;
            count++;
        }

        ListNode tempRoot = null;
        ListNode temp = null;
        for (int i = 1; i <= count + 1; i++) {
            ListNode kthNodeFromEnd = P134_KthNodeFromEnd.getKthNodeFromEnd(root, i);
            if (tempRoot == null) {
                temp = ListNode.just(kthNodeFromEnd);
                tempRoot = temp;
            } else {
                temp.next(kthNodeFromEnd);
                temp = temp.next;
            }
        }
        return tempRoot;
    }


    public static ListNode reverseList2(ListNode root) {
        if (root == null || root.next == null) {
            return root;
        }
        ListNode rerverseHead = null;
        ListNode preTempNode = null;
        ListNode tempNode = root;
        while (tempNode != null) {
            ListNode nextNode = tempNode.next;
            if (nextNode == null) {    //说明当前节点是最后一个节点
                rerverseHead = tempNode;
            }

            //将前面的节点，给他
            tempNode.next = preTempNode;
            preTempNode = tempNode;//换成当前的节点
            tempNode = nextNode;
        }

        return rerverseHead;
    }
}
