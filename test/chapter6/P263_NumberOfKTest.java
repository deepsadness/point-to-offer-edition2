package chapter6;

import org.junit.Assert;
import org.junit.Test;

public class P263_NumberOfKTest {

    @Test
    public void findNumberTimes() {
        int[] arr = {1, 2, 3, 3, 3, 3, 4, 5};
        Assert.assertEquals(4, P263_NumberOfK.findNumberTimes(arr, 3));
        Assert.assertEquals(1, P263_NumberOfK.findNumberTimes(arr, 4));
        Assert.assertEquals(0, P263_NumberOfK.findNumberTimes(arr, 6));
    }

    @Test
    public void findNumberTimes2() {
        int[] arr = {1, 2, 3, 3, 3, 3, 4, 5};
        Assert.assertEquals(4, P263_NumberOfK.findNumberTimes2(arr, 3));
        Assert.assertEquals(1, P263_NumberOfK.findNumberTimes2(arr, 4));
        Assert.assertEquals(0, P263_NumberOfK.findNumberTimes2(arr, 6));
    }

    @Test
    public void findNumberTimes3() {
        int[] arr = {1, 2, 3, 3, 3, 3, 4, 5};
        Assert.assertEquals(4, P263_NumberOfK.findNumberTimes3(arr, 3));
        Assert.assertEquals(1, P263_NumberOfK.findNumberTimes3(arr, 4));
        Assert.assertEquals(0, P263_NumberOfK.findNumberTimes3(arr, 6));
    }
}