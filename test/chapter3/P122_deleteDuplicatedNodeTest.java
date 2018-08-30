package chapter3;

import model.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class P122_deleteDuplicatedNodeTest {

    @Test
    public void deleteDuplicatedNodeNo() {
        ListNode nodeStart = ListNode.just(1);
        nodeStart.next(2).next(3).next(4);
        ListNode listNode = P122_deleteDuplicatedNode.deleteDuplicatedNode(nodeStart);

        ListNode cmpNode = ListNode.just(1);
        cmpNode.next(2).next(3).next(4);

        Assert.assertEquals(cmpNode.toString(), listNode.toString());
    }

    @Test
    public void deleteDuplicatedNodeNormal() {
        ListNode nodeStart = ListNode.just(1);
        nodeStart.next(2).next(3).next(3);
        ListNode listNode = P122_deleteDuplicatedNode.deleteDuplicatedNode(nodeStart);

        ListNode cmpNode = ListNode.just(1);
        cmpNode.next(2);

        Assert.assertEquals(cmpNode.toString(), listNode.toString());
    }

    @Test
    public void deleteDuplicatedNodeHead() {
        ListNode nodeStart = ListNode.just(1);
        nodeStart.next(1).next(2).next(3);
        ListNode listNode = P122_deleteDuplicatedNode.deleteDuplicatedNode(nodeStart);

        ListNode cmpNode = ListNode.just(2);
        cmpNode.next(3);

        Assert.assertEquals(cmpNode.toString(), listNode.toString());
    }


    @Test
    public void deleteDuplicatedNodeTwice() {
        ListNode nodeStart = ListNode.just(1);
        nodeStart.next(1).next(2).next(3).next(3).next(4);
        ListNode listNode = P122_deleteDuplicatedNode.deleteDuplicatedNode(nodeStart);

        ListNode cmpNode = ListNode.just(2);
        cmpNode.next(4);

        Assert.assertEquals(cmpNode.toString(), listNode.toString());
    }

    @Test
    public void deleteDuplicatedNodeAll() {
        ListNode nodeStart = ListNode.just(1);
        nodeStart.next(1).next(1);
        ListNode listNode = P122_deleteDuplicatedNode.deleteDuplicatedNode(nodeStart);

        Assert.assertNull(listNode);
    }

    @Test
    public void deleteDuplicatedNodeNullInput() {
        ListNode listNode = P122_deleteDuplicatedNode.deleteDuplicatedNode(null);
        Assert.assertNull(listNode);
    }
}