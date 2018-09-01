package chapter4;

import org.junit.Assert;
import org.junit.Test;

public class P165_StackWithMinTest {

    @Test
    public void test() {
        P165_StackWithMin.StackMin<Integer> stack = new P165_StackWithMin.StackMin<>();
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(1);
        Assert.assertEquals(1, stack.min().intValue());
        stack.pop();
        Assert.assertEquals(2, stack.min().intValue());
        stack.pop();
        Assert.assertEquals(3, stack.min().intValue());
        stack.pop();
        Assert.assertEquals(3, stack.min().intValue());
        stack.pop();
        Assert.assertNull(stack.min());

    }

}