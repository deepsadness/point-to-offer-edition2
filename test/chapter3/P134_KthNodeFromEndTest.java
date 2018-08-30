package chapter3;

import model.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class P134_KthNodeFromEndTest {

    @Test
    public void getKthNodeFromEnd() {
        ListNode root = ListNode.just(1);
        root.next(2).next(3).next(4).next(5);
        ListNode kthNodeFromEnd = P134_KthNodeFromEnd.getKthNodeFromEnd(root, 1);
        ListNode kthNodeFromEnd2 = P134_KthNodeFromEnd.getKthNodeFromEnd(root, 3);
        Assert.assertEquals(5, kthNodeFromEnd.value);
        Assert.assertEquals(3, kthNodeFromEnd2.value);
    }

    @Test
    public void getKthNodeFromEndOutOfIndex() {
        ListNode root = ListNode.just(1);
        root.next(2).next(3).next(4).next(5);
        ListNode kthNodeFromEnd = P134_KthNodeFromEnd.getKthNodeFromEnd(root, 7);
        Assert.assertNull(kthNodeFromEnd);
    }

    @Test
    public void getKthNodeFromEndNull() {
        ListNode root = ListNode.just(1);
        root.next(2).next(3).next(4).next(5);
        ListNode kthNodeFromEnd = P134_KthNodeFromEnd.getKthNodeFromEnd(root, 0);
        Assert.assertNull(kthNodeFromEnd);


        ListNode rootNull = null;
        ListNode kthNodeFromEnd2= P134_KthNodeFromEnd.getKthNodeFromEnd(rootNull, 23);
        Assert.assertNull(kthNodeFromEnd2);

    }
}