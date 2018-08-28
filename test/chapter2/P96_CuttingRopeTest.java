package chapter2;

import org.junit.Assert;
import org.junit.Test;

public class P96_CuttingRopeTest {

    @Test
    public void cutTest() {
        Assert.assertEquals(1, P96_CuttingRope.cut(2));
        Assert.assertEquals(2, P96_CuttingRope.cut(3));
        Assert.assertEquals(4, P96_CuttingRope.cut(4));
        Assert.assertEquals(6, P96_CuttingRope.cut(5));
        Assert.assertEquals(9, P96_CuttingRope.cut(6));
        Assert.assertEquals(12, P96_CuttingRope.cut(7));
        Assert.assertEquals(18, P96_CuttingRope.cut(8));
        Assert.assertEquals(27, P96_CuttingRope.cut(9));
    }
}