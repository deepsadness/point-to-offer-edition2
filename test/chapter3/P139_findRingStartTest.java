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
        ListNode ringStart2 = P139_findRingStart.findRingStart2(root);
        Assert.assertEquals(node3, ringStart);
        Assert.assertEquals(node3, ringStart2);
    }

    @Test
    public void findRingStartNo() {
        ListNode root = ListNode.just(1);
        root.next(2).next(3).next(4).next(5);

        ListNode ringStart = P139_findRingStart.findRingStart(root);
        ListNode ringStart2 = P139_findRingStart.findRingStart2(root);
        Assert.assertNull(ringStart);
        Assert.assertNull(ringStart2);
    }

    @Test
    public void findRingStartRoot() {
        ListNode root = ListNode.just(1);
        root.next = root;

        ListNode ringStart = P139_findRingStart.findRingStart(root);
        ListNode ringStart2 = P139_findRingStart.findRingStart2(root);
        Assert.assertEquals(root, ringStart);
        Assert.assertEquals(root, ringStart2);
    }

    @Test
    public void findRingStartNUll() {

        ListNode ringStart = P139_findRingStart.findRingStart(null);
        ListNode ringStart2 = P139_findRingStart.findRingStart2(null);
        Assert.assertNull(ringStart);
        Assert.assertNull(ringStart2);
    }
}