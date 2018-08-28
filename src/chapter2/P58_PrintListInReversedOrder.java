package chapter2;

import java.util.Stack;

public class P58_PrintListInReversedOrder {

    public static String printListInReversedOrder(Node head) {
        if (head == null) {
            return null;
        }
        Node temp = head;
        Stack<Node> stack = new Stack<>();
        stack.push(temp);
        while (temp.next != null) {
            temp = temp.next;
            stack.push(temp);
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            stringBuilder.append(pop.value).append(",");
        }
        return stringBuilder.toString();
    }

    public static class Node {
        int value;
        Node next;


        public Node link(int value) {
            Node n = new Node();
            n.value = value;
            this.next = n;
            return n;
        }

        public static Node just(int value) {
            Node n = new Node();
            n.value = value;
            return n;
        }
    }
}
