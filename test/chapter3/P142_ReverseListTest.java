package chapter3;

import model.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class P142_ReverseListTest {

    @Test
    public void reverseList() {
        ListNode root = ListNode.just(1);
        root.next(2).next(3).next(4).next(5);

        ListNode rev = ListNode.just(5);
        rev.next(4).next(3).next(2).next(1);

        root = P142_ReverseList.reverseList2(root);

        Assert.assertEquals(rev.toString(), root.toString());

    }
}