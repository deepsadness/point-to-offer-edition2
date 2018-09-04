package chapter5;

import org.junit.Assert;
import org.junit.Test;

public class P225_DigitsInSequenceTest {

    @Test
    public void digitAtIndex1() {
        Assert.assertEquals(5, P225_DigitsInSequence.digitAtIndex(5));
    }

    @Test
    public void digitAtIndex2() {
        Assert.assertEquals("10", P225_DigitsInSequence.digitAtIndex(10) + "" + P225_DigitsInSequence.digitAtIndex(11));
        Assert.assertEquals("11", P225_DigitsInSequence.digitAtIndex(12) + "" + P225_DigitsInSequence.digitAtIndex(13));
        Assert.assertEquals("12", P225_DigitsInSequence.digitAtIndex(14) + "" + P225_DigitsInSequence.digitAtIndex(15));

        Assert.assertEquals("20", P225_DigitsInSequence.digitAtIndex(30) + "" + P225_DigitsInSequence.digitAtIndex(31));

        Assert.assertEquals("94", P225_DigitsInSequence.digitAtIndex(178) + "" + P225_DigitsInSequence.digitAtIndex(179));
        Assert.assertEquals("99", P225_DigitsInSequence.digitAtIndex(188) + "" + P225_DigitsInSequence.digitAtIndex(189));


    }

    @Test
    public void digitAtIndex4() {
        // 370中的7
        Assert.assertEquals(7, P225_DigitsInSequence.digitAtIndex(1001));
    }

    @Test
    public void digitAtIndex3() {
        Assert.assertEquals("100", P225_DigitsInSequence.digitAtIndex(181) + "" + P225_DigitsInSequence.digitAtIndex(182) + P225_DigitsInSequence.digitAtIndex(183));
    }

    @Test
    public void lengthSum() {
        int d1 = P225_DigitsInSequence.lengthSum(1);
        int d2 = P225_DigitsInSequence.lengthSum(2);
        int d3 = P225_DigitsInSequence.lengthSum(3);


        Assert.assertEquals(9, d1);
        Assert.assertEquals(180, d2);
        Assert.assertEquals(2700, d3);
    }
}