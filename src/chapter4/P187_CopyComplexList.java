package chapter4;

import model.ComplexListNode;

import java.util.HashMap;

/**
 * 复杂链表的复制
 * <p>
 * 在复杂链表中，每个节点除了有一个next指针指向下一个节点，
 * 还有一个random指针指向链表中的任意节点或null，请完成一个能够复制复杂链表的函数
 */
public class P187_CopyComplexList {

    public static ComplexListNode copy0(ComplexListNode root) {
        if (root == null) {
            return null;
        }
        ComplexListNode head = new ComplexListNode();
        head.value = root.value;
        head.next = root.next;
        ComplexListNode temp
                = root;
        //先根据next，将链表连在一起
        while (temp.next != null) {
            ComplexListNode next = new ComplexListNode();
            ComplexListNode nextOrigin = temp.next;
            next.value = nextOrigin.value;
            temp = nextOrigin.next;
        }

        temp = root;
        ComplexListNode tempHead = head;
        while (temp != null) {
            ComplexListNode sibling = temp.sibling;
            tempHead.sibling = null;

            if (sibling != null) {
                ComplexListNode circle = root;
                while (circle != null) {
                    if (circle == sibling) {
                        tempHead.sibling = circle;
                        break;
                    }
                    circle = circle.next;
                }
            }
            temp = temp.next;
            tempHead = tempHead.next;
        }

        return head;
    }

    public static ComplexListNode copy1(ComplexListNode root) {
        if (root == null) {
            return null;
        }
        ComplexListNode head = new ComplexListNode();
        head.value = root.value;

        ComplexListNode temp = root;
        ComplexListNode tempHead = head;
        HashMap<ComplexListNode, ComplexListNode> map = new HashMap<>();
        map.put(temp, tempHead);
        while (temp.next != null) {
            ComplexListNode next = new ComplexListNode();
            tempHead.next = next;
            next.value = temp.next.value;

            map.put(temp.next, next);

            temp = temp.next;
            tempHead = tempHead.next;

            map.put(temp, tempHead);
        }
        temp = root;
        tempHead = head;

        while (temp != null) {
            if (temp.sibling != null) {
                ComplexListNode originSb = temp.sibling;
                ComplexListNode curNode = map.get(originSb);
                tempHead.sibling = curNode;
            }

            temp = temp.next;
            tempHead = tempHead.next;
        }

        return head;
    }

    /**
     * 这种解法是将 自己创建的节点，接在原来的节点后面，这样就可以轻松的找到sibling了。
     * <p>
     * 原本都是要创建两个链表，现在是先在一个链表中进行，然后再拆开
     */
    public static ComplexListNode copy2(ComplexListNode root) {
        if (root == null) {
            return null;
        }

        ComplexListNode temp = root;

        //将新创建的链接到原来的链表中
        while (temp != null) {
            ComplexListNode next = new ComplexListNode(temp.value);
            next.next = temp.next;
            temp.next = next;

            temp = next.next;
        }

        //因为直接跟在原来的链表后面，所以可以通过n1的方式拿到
        temp = root;
        while (temp != null) {
            if (temp.sibling != null) {
                temp.next.sibling = temp.sibling.next;
            }
            temp = temp.next.next;
        }

        //拆分。偶数是复制出来的
        ComplexListNode head = root.next;
        temp = root.next.next;

        ComplexListNode tempHead = head;

        while (temp != null) {
            tempHead.next = temp;

            temp = temp.next.next;
            tempHead = tempHead.next;
        }
        //最后要手动将可能的链断开
        tempHead.next=null;

        return head;
    }
}
