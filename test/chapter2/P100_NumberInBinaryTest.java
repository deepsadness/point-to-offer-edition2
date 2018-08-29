package chapter2;

import org.junit.Assert;
import org.junit.Test;

public class P100_NumberInBinaryTest {

    @Test
    public void getBinarySumUnsignedRight() {
        Assert.assertEquals(2, P100_NumberInBinary.getBinarySumUnsignedRight(3));
        Assert.assertEquals(31, P100_NumberInBinary.getBinarySumUnsignedRight(-3));
    }

    @Test
    public void getBinarySumLeftFlag() {
        Assert.assertEquals(2, P100_NumberInBinary.getBinarySumLeftFlag(3));
        Assert.assertEquals(31, P100_NumberInBinary.getBinarySumLeftFlag(-3));
    }
}