package chapter2;

import org.junit.Assert;
import org.junit.Test;

public class P68_QueueWithTwoStacksTest {

    @Test
    public void testQueue() {
        P68_QueueWithTwoStacks.Queue<Integer> queue = new P68_QueueWithTwoStacks.Queue<>();


        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        Assert.assertEquals(1, queue.poll().intValue());
        Assert.assertEquals(2, queue.poll().intValue());
        Assert.assertEquals(3, queue.poll().intValue());

        queue.offer(null);
        queue.offer(1);
        queue.offer(2);
        queue.poll();
        queue.offer(3);
        queue.offer(4);

        Assert.assertEquals(2, queue.poll().intValue());
        Assert.assertEquals(3, queue.poll().intValue());
        Assert.assertEquals(4, queue.poll().intValue());
        Assert.assertNull(queue.poll());


    }


    @Test
    public void testStack() {
        P68_QueueWithTwoStacks.Stack<Integer> queue = new P68_QueueWithTwoStacks.Stack<>();


        queue.push(1);
        queue.push(2);
        queue.push(3);

        Assert.assertEquals(3, queue.pop().intValue());
        Assert.assertEquals(2, queue.pop().intValue());
        Assert.assertEquals(1, queue.pop().intValue());

        queue.push(null);
        queue.push(1);
        queue.push(2);
        queue.pop();
        queue.push(3);
        queue.push(4);

        Assert.assertEquals(4, queue.pop().intValue());
        Assert.assertEquals(3, queue.pop().intValue());
        Assert.assertEquals(1, queue.pop().intValue());
        Assert.assertNull(queue.pop());
    }
}