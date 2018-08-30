package chapter3;

import model.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class P139_findRingStartTest {

    @Test
    public void findRingStart() {
        ListNode root = ListNode.just(1);
        ListNode node3 = root.next(2).next(3);
        node3.next(4).next(5).next = node3;

        ListNode ringStart = P139_findRingStart.findRingStart(root);
        Assert.assertEquals(node3, ringStart);
    }

    @Test
    public void findRingStartNo() {
        ListNode root = ListNode.just(1);
        root.next(2).next(3).next(4).next(5);

        ListNode ringStart = P139_findRingStart.findRingStart(root);
        Assert.assertNull(ringStart);
    }

    @Test
    public void findRingStartRoot() {
        ListNode root = ListNode.just(1);
        root.next = root;

        ListNode ringStart = P139_findRingStart.findRingStart(root);
        Assert.assertEquals(root, ringStart);
    }

    @Test
    public void findRingStartNUll() {

        ListNode ringStart = P139_findRingStart.findRingStart(null);
        Assert.assertNull(ringStart);
    }
}