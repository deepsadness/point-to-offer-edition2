package chapter3;

import model.ListNode;

/**
 * 合并两个排序的链表
 * 输入两个递增排序的链表，要求合并后保持递增。
 */
public class P145_MergeSortedLists {
    public static ListNode merge(ListNode r1, ListNode r2) {
        if (r1 == null && r2 == null) {
            return null;
        }

        if (r1 == null) {
            return r2;
        }

        if (r2 == null) {
            return r1;
        }

        ListNode merge = null;
        ListNode temp = null;
        ListNode left = r1;
        ListNode right = r2;

        while (left != null && right != null) {
            if (left.value > right.value) {
                if (merge == null) {
                    merge = right;
                    temp = merge;
                } else {
                    temp.next = right;
                    temp = temp.next;
                }
                right = right.next;
            } else {
                if (merge == null) {
                    merge = left;
                    temp = merge;
                } else {
                    temp.next = left;
                    temp = temp.next;
                }
                left = left.next;
            }
        }

        while (left != null) {
            temp.next = left;
            temp = temp.next;
            left = left.next;
        }
        while (right != null) {
            temp.next = right;
            temp = temp.next;
            right = right.next;
        }
        return merge;
    }

    public static ListNode merge2(ListNode r1, ListNode r2) {
        if (r1 == null && r2 == null) {
            return null;
        }

        if (r1 == null) {
            return r2;
        }

        if (r2 == null) {
            return r1;
        }
        ListNode merge;
        if (r1.value > r2.value) {
            merge = r2;
            return mergeRecursive(r1, r2.next, merge,merge);
        } else {
            merge = r1;
            return mergeRecursive(r1.next, r2, merge,merge);
        }
    }

    private static ListNode mergeRecursive(ListNode r1, ListNode r2, ListNode merge, ListNode listNode) {
        if (r1 == null && r2 == null) {
            return listNode;
        }

        if (r1 == null) {
            merge.next = r2;
            return mergeRecursive(null, r2.next, merge.next, listNode);
        }

        if (r2 == null) {
            merge.next = r1;
            return mergeRecursive(r1.next, null, merge.next, listNode);
        }

        if (r1.value > r2.value) {
            merge.next  = r2;
            return mergeRecursive(r1, r2.next, merge.next, listNode);
        } else {
            merge.next  = r1;
            return mergeRecursive(r1.next, r2, merge.next, listNode);
        }
    }
}
