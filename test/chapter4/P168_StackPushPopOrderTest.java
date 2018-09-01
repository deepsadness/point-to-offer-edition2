package chapter4;

import org.junit.Assert;
import org.junit.Test;

public class P168_StackPushPopOrderTest {

    @Test
    public void isPopOrder() {
        int[] pushOrder = {1, 2, 3, 4, 5};
        int[] popOrderRight = {4, 5, 3, 2, 1};
        Assert.assertTrue(P168_StackPushPopOrder.isPopOrder(pushOrder, popOrderRight));
        Assert.assertTrue(P168_StackPushPopOrder.isPopOrderRecursive(pushOrder, popOrderRight));
        Assert.assertTrue(P168_StackPushPopOrder.isPopOrderWithStack(pushOrder, popOrderRight));
        Assert.assertTrue(P168_StackPushPopOrder.isPopOrderWithStackRecursive(pushOrder, popOrderRight));
    }

    @Test
    public void isPopOrder1() {
        int[] pushOrder = {1, 2, 3, 4, 5};
        int[] popOrderWrong = {4, 3, 5, 1, 2};
        Assert.assertFalse(P168_StackPushPopOrder.isPopOrder(pushOrder, popOrderWrong));
        Assert.assertFalse(P168_StackPushPopOrder.isPopOrderRecursive(pushOrder, popOrderWrong));
        Assert.assertFalse(P168_StackPushPopOrder.isPopOrderWithStack(pushOrder, popOrderWrong));
        Assert.assertFalse(P168_StackPushPopOrder.isPopOrderWithStackRecursive(pushOrder, popOrderWrong));
    }

    @Test
    public void isPopOrder2() {
        int[] pushOrder = {1, 2, 3, 4, 5};
        int[] popOrderRight = {1, 2, 3, 4, 5};
        Assert.assertTrue(P168_StackPushPopOrder.isPopOrder(pushOrder, popOrderRight));
        Assert.assertTrue(P168_StackPushPopOrder.isPopOrderRecursive(pushOrder, popOrderRight));
        Assert.assertTrue(P168_StackPushPopOrder.isPopOrderWithStack(pushOrder, popOrderRight));
        Assert.assertTrue(P168_StackPushPopOrder.isPopOrderWithStackRecursive(pushOrder, popOrderRight));
    }

    @Test
    public void isPopOrder3() {
        int[] pushOrder = {1};
        int[] popOrderRight = {1};
        Assert.assertTrue(P168_StackPushPopOrder.isPopOrder(pushOrder, popOrderRight));
        Assert.assertTrue(P168_StackPushPopOrder.isPopOrderRecursive(pushOrder, popOrderRight));
        Assert.assertTrue(P168_StackPushPopOrder.isPopOrderWithStack(pushOrder, popOrderRight));
        Assert.assertTrue(P168_StackPushPopOrder.isPopOrderWithStackRecursive(pushOrder, popOrderRight));
    }

    @Test
    public void isPopOrder4() {
        int[] pushOrder = {1, 2, 3, 4, 5};
        int[] popOrderRight = {1, 3, 4, 2, 5};
        Assert.assertTrue(P168_StackPushPopOrder.isPopOrder(pushOrder, popOrderRight));
        Assert.assertTrue(P168_StackPushPopOrder.isPopOrderRecursive(pushOrder, popOrderRight));
        Assert.assertTrue(P168_StackPushPopOrder.isPopOrderWithStack(pushOrder, popOrderRight));
        Assert.assertTrue(P168_StackPushPopOrder.isPopOrderWithStackRecursive(pushOrder, popOrderRight));
    }

    @Test
    public void isPopOrder5() {
        int[] pushOrder = {6, 1, 2, 3, 4, 5};
        int[] popOrderRight = {1, 2, 6, 5, 4,3};
        Assert.assertTrue(P168_StackPushPopOrder.isPopOrder(pushOrder, popOrderRight));
        Assert.assertTrue(P168_StackPushPopOrder.isPopOrderRecursive(pushOrder, popOrderRight));
        Assert.assertTrue(P168_StackPushPopOrder.isPopOrderWithStack(pushOrder, popOrderRight));
        Assert.assertTrue(P168_StackPushPopOrder.isPopOrderWithStackRecursive(pushOrder, popOrderRight));
    }
}