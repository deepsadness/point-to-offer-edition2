package chapter3;

import model.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class P119_DeleteNodeInListTest {

    @Test
    public void deleteNormal() {
        ListNode tempHead = ListNode.just(1);
        tempHead.next(2).next(3).next(4);
        ListNode nodeToDelete = tempHead.next.next;
        ListNode resultNode = P119_DeleteNodeInList.delete(tempHead, nodeToDelete);

        ListNode cmpNode = ListNode.just(1);
        cmpNode.next(2).next(4);

        Assert.assertEquals(cmpNode.toString(), resultNode.toString());
    }

    @Test
    public void deleteHead() {
        ListNode tempHead = ListNode.just(1);
        tempHead.next(2).next(3).next(4);
        ListNode resultNode = P119_DeleteNodeInList.delete(tempHead, tempHead);

        ListNode cmpNode = ListNode.just(2);
        cmpNode.next(3).next(4);

        Assert.assertEquals(cmpNode.toString(), resultNode.toString());
    }

    @Test
    public void deleteTail() {
        ListNode tempHead = ListNode.just(1);
        ListNode tail = tempHead.next(2).next(3).next(4);
        ListNode resultNode = P119_DeleteNodeInList.delete(tempHead, tail);

        ListNode cmpNode = ListNode.just(1);
        cmpNode.next(2).next(3);

        Assert.assertEquals(cmpNode.toString(), resultNode.toString());
    }

    @Test
    public void deleteNull() {
        ListNode tempHead = ListNode.just(1);
        tempHead.next(2).next(3).next(4);
        ListNode resultNode = P119_DeleteNodeInList.delete(tempHead, null);

        ListNode cmp = ListNode.just(1);
        cmp.next(2).next(3).next(4);
        Assert.assertEquals(cmp.toString(), resultNode.toString());

        ListNode tempHead2 = ListNode.just(1);
        ListNode resultNode2 = P119_DeleteNodeInList.delete(tempHead2, tempHead2);
        Assert.assertNull(resultNode2);

    }
}