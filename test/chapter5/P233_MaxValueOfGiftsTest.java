package chapter5;

import org.junit.Assert;
import org.junit.Test;

public class P233_MaxValueOfGiftsTest {

    @Test
    public void getMaxValue() {
        int[][] arr = {
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}
        };
        int maxValue = P233_MaxValueOfGifts.getMaxValue(arr);
        Assert.assertEquals(53,maxValue);
    }
}