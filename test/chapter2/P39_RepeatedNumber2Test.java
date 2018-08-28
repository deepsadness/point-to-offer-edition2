package chapter2;

import org.junit.Assert;
import org.junit.Test;

public class P39_RepeatedNumber2Test {
    @Test
    public void test() {
        int[] normal = {4, 3, 3, 2, 1};
        Assert.assertEquals(3, P39_RepeatedNumber2.solution1(normal));
        Assert.assertEquals(3, P39_RepeatedNumber2.solution2(normal));
        Assert.assertEquals(3, P39_RepeatedNumber2.solution3(normal));
        Assert.assertEquals(3, P39_RepeatedNumber2.solution4(normal));
        Assert.assertEquals(3, P39_RepeatedNumber2.solution5(normal));
    }
}