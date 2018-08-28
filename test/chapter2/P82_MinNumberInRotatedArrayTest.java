package chapter2;

import org.junit.Assert;
import org.junit.Test;

public class P82_MinNumberInRotatedArrayTest {

    @Test
    public void findMin() {
        int[] arr = {3, 4, 5, 1, 2};
        int[] arr2 = {1, 0, 1, 1, 1};
        int[] arr3 = {1,1,1,0,1};
        Assert.assertEquals(1, P82_MinNumberInRotatedArray.findMin(arr));
        Assert.assertEquals(0, P82_MinNumberInRotatedArray.findMin(arr2));
        Assert.assertEquals(0, P82_MinNumberInRotatedArray.findMin(arr3));
    }

    @Test
    public void findMinNull() {
        int[] arr = null;
        int[] arr2 = {};
        int[] arr3 = {1};
        Assert.assertEquals(-1, P82_MinNumberInRotatedArray.findMin(arr));
        Assert.assertEquals(-1, P82_MinNumberInRotatedArray.findMin(arr2));
        Assert.assertEquals(1, P82_MinNumberInRotatedArray.findMin(arr3));
    }
}