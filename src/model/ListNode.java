package model;

import com.sun.istack.internal.Nullable;

import java.util.Objects;

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

    public static ListNode just(ListNode old) {
        ListNode listNode = new ListNode();
        listNode.value = old.value;
        return listNode;
    }

    public ListNode next(int value) {
        ListNode listNode = new ListNode();
        listNode.value = value;
        this.next = listNode;
        return listNode;
    }

    public ListNode next(ListNode old) {
        ListNode listNode = new ListNode();
        listNode.value = old.value;
        this.next = listNode;
        return listNode;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode node = (ListNode) o;
        return value == node.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
