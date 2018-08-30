package chapter3;

import model.ListNode;
import org.junit.Test;

public class P145_MergeSortedListsTest {

    @Test
    public void merge() {
        ListNode left = ListNode.just(1);
        left.next(3).next(5);


        ListNode right = ListNode.just(2);
        right.next(4).next(6);


//        ListNode merge = P145_MergeSortedLists.merge(left, right);
        ListNode merge = P145_MergeSortedLists.merge2(left, right);
        System.out.println(merge.toString());
    }
}