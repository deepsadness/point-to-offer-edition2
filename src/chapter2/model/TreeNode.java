package chapter2.model;

import java.util.Objects;

public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode left(int value) {
        TreeNode n = new TreeNode();
        n.value = value;
        this.left = n;
        return n;
    }

    public TreeNode right(int value) {
        TreeNode n = new TreeNode();
        n.value = value;
        this.right = n;
        return n;
    }

    public void both(int leftValue, int rightValue) {
        TreeNode left = new TreeNode();
        left.value = leftValue;
        TreeNode right = new TreeNode();
        right.value = rightValue;
        this.left = left;
        this.right = right;
    }

    public static TreeNode just(int value) {
        TreeNode n = new TreeNode();
        n.value = value;
        return n;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return value == treeNode.value &&
                Objects.equals(left, treeNode.left) &&
                Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {

        return Objects.hash(value, left, right);
    }
}
