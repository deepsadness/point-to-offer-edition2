package chapter5;

import model.ListNode;
import org.junit.Test;

/**
 * 1 -> 2 -> 3 -> 6 -> 7
 * 4 -> 5 ↗
 */
public class P253_CommonNodesInListsTest {

    @Test
    public void findCommonNode1() {
        ListNode node1 = ListNode.just(1);
        ListNode node6 = node1.next(2).next(3).next(6);
        node6.next(7);
        ListNode node2 = ListNode.just(4);
        node2.next(5).next = node6;
        ListNode commonNode1 = P253_CommonNodesInLists.findCommonNode1(node1, node2);

        System.out.println(commonNode1 == null ? "NULL" : commonNode1.value);
    }

    @Test
    public void findCommonNode2() {
        ListNode node1 = ListNode.just(1);
        ListNode node6 = node1.next(2).next(3).next(6);
        node6.next(7);
        ListNode node2 = ListNode.just(4);
        node2.next(5).next = node6;
        ListNode commonNode1 = P253_CommonNodesInLists.findCommonNode2(node1, node2);
        System.out.println(commonNode1.value);
    }
}