package chapter3;

import org.junit.Assert;
import org.junit.Test;

public class P110_PowTest {

    @Test
    public void powBaseZero() {
        Assert.assertEquals(Math.pow(0, 12), P110_Pow.pow(0, 12), 0.000001);
        Assert.assertEquals(Math.pow(0, 12), P110_Pow.powEffiective(0, 12), 0.000001);
    }

    @Test
    public void powExponentZero() {
        Assert.assertEquals(Math.pow(1, 0), P110_Pow.pow(1, 0), 0.000001);
        Assert.assertEquals(Math.pow(1, 0), P110_Pow.powEffiective(1, 0), 0.000001);
    }

    @Test
    public void powPositive() {
        Assert.assertEquals(Math.pow(4.5, 12), P110_Pow.pow(4.5, 12), 0.000001);
        Assert.assertEquals(Math.pow(4.5, 12), P110_Pow.powEffiective(4.5, 12), 0.000001);
    }

    @Test
    public void powNegative() {
        Assert.assertEquals(Math.pow(6, -12), P110_Pow.pow(6, -12), 0.000001);
        Assert.assertEquals(Math.pow(6, -12), P110_Pow.powEffiective(6, -12), 0.000001);
    }

    @Test
    public void pow() {
        Assert.assertEquals(Math.pow(-60.5, 4), P110_Pow.pow(-60.5, 4), 0.000001);
        Assert.assertEquals(Math.pow(-60.5, 4), P110_Pow.powEffiective(-60.5, 4), 0.000001);
    }
}