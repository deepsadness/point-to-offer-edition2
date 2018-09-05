package chapter6;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class P275_NumberAppearOnceTest {

    @Test
    public void findFirst1Bit() {
        Assert.assertEquals(-1, P275_NumberAppearOnce.findFirst1Bit(0));
        Assert.assertEquals(0, P275_NumberAppearOnce.findFirst1Bit(1));
        Assert.assertEquals(1, P275_NumberAppearOnce.findFirst1Bit(2));
        Assert.assertEquals(2, P275_NumberAppearOnce.findFirst1Bit(4));
        Assert.assertEquals(1, P275_NumberAppearOnce.findFirst1Bit(6));
    }

    @Test
    public void onceNumber() {
        int[] arr = {2, 4, 3, 6, 3, 2, 5, 5};
        Assert.assertEquals("[6, 4]",Arrays.toString(P275_NumberAppearOnce.onceNumber(arr)));
    }
}