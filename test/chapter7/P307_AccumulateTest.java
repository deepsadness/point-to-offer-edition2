package chapter7;

import org.junit.Assert;
import org.junit.Test;

public class P307_AccumulateTest {

    @Test
    public void accumulate() {
        Assert.assertEquals(55, P307_Accumulate.accumulate(10));
    }
}