package model;

import com.sun.istack.internal.Nullable;

public class ListNode {
    @Nullable
    public ListNode next;
    public int value;

    private ListNode() {
    }

    public static ListNode just(int value) {
        ListNode listNode = new ListNode();
        listNode.value = value;
        return listNode;
    }

    public ListNode next(int value) {
        ListNode listNode = new ListNode();
        listNode.value = value;
        this.next = listNode;
        return listNode;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "next=" + (next == null ? "{null}" : next.toString()) +
                ", value=" + value +
                '}';
    }
}
