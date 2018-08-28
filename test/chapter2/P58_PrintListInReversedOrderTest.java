package chapter2;

import org.junit.Assert;

public class P58_PrintListInReversedOrderTest {

    @org.junit.Test
    public void testNormal() {
        P58_PrintListInReversedOrder.Node node1 = P58_PrintListInReversedOrder.Node.just(1);
        node1.link(2).link(3).link(4).link(5).link(6);
        String result = P58_PrintListInReversedOrder.printListInReversedOrder(node1);

        Assert.assertEquals("6,5,4,3,2,1,", result);
    }

    @org.junit.Test
    public void testNull() {
        String result = P58_PrintListInReversedOrder.printListInReversedOrder(null);
        Assert.assertNull(result);
    }

    @org.junit.Test
    public void testLarge() {
        P58_PrintListInReversedOrder.Node node1 = P58_PrintListInReversedOrder.Node.just(1);
        P58_PrintListInReversedOrder.Node temp = node1;
        for (int i = 2; i < 1000000; i++) {
            temp = temp.link(i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1000000 - 1; i > 0; i--) {
            stringBuilder.append(i).append(",");
        }
        String except = stringBuilder.toString();
        String result = P58_PrintListInReversedOrder.printListInReversedOrder(node1);
        Assert.assertEquals(except, result);
    }
}