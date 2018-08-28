package chapter2.model;

import java.util.Objects;

public class ParentTreeNode {
    public int value;
    public ParentTreeNode left;
    public ParentTreeNode right;
    public ParentTreeNode parent;

    @Override
    public String toString() {
        return "ParentTreeNode{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParentTreeNode that = (ParentTreeNode) o;
        return value == that.value &&
                Objects.equals(left, that.left) &&
                Objects.equals(right, that.right) &&
                Objects.equals(parent, that.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, left, right, parent);
    }

    public ParentTreeNode left(int value) {
        ParentTreeNode node = new ParentTreeNode();
        node.value = value;
        node.parent = this;
        left = node;
        return node;
    }

    public ParentTreeNode right(int value) {
        ParentTreeNode node = new ParentTreeNode();
        node.value = value;
        node.parent = this;
        right = node;
        return node;
    }

    public static ParentTreeNode just(int value) {
        ParentTreeNode node = new ParentTreeNode();
        node.value = value;
        return node;
    }
}
