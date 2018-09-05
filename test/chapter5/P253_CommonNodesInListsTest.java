package chapter5;

import model.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 1 -> 2 -> 3 -> 6 -> 7
 * 4 -> 5 ↗
 */
public class P253_CommonNodesInListsTest {

    @Test
    public void findCommonNodeMid() {
        ListNode node1 = ListNode.just(1);
        ListNode node6 = node1.next(2).next(3).next(6);
        node6.next(7);
        ListNode node2 = ListNode.just(4);
        node2.next(5).next = node6;
        ListNode commonNode1 = P253_CommonNodesInLists.findCommonNode1(node1, node2);
        Assert.assertEquals(commonNode1.value,6);
    }

    @Test
    public void findCommonNodeTail() {
        ListNode node1 = ListNode.just(1);
        ListNode node6 = node1.next(2).next(3).next(6);
        ListNode node2 = ListNode.just(4);
        node2.next(5).next = node6;
        ListNode commonNode1 = P253_CommonNodesInLists.findCommonNode1(node1, node2);
        Assert.assertEquals(commonNode1.value,6);
    }

    @Test
    public void findCommonNodeNull() {
        ListNode node1 = ListNode.just(1);
        ListNode node6 = node1.next(2).next(3).next(6);
        ListNode node2 = ListNode.just(4);
        node2.next(5).next = node6;
        ListNode commonNode1 = P253_CommonNodesInLists.findCommonNode1(node1, null);
        Assert.assertNull(commonNode1);
    }

    @Test
    public void findCommonNode2() {
        ListNode node1 = ListNode.just(1);
        ListNode node6 = node1.next(2).next(3).next(6);
        node6.next(7);
        ListNode node2 = ListNode.just(4);
        node2.next(5).next = node6;
        ListNode commonNode1 = P253_CommonNodesInLists.findCommonNode2(node1, node2);
        Assert.assertEquals(commonNode1.value,6);
    }
}