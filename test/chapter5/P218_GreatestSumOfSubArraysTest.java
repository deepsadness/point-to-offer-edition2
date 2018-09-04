package chapter5;

import org.junit.Assert;
import org.junit.Test;

public class P218_GreatestSumOfSubArraysTest {

    @Test
    public void getGreatestSumOfArr() {
        int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
        int greatestSumOfArr = P218_GreatestSumOfSubArrays.getGreatestSumOfArr(arr);
        Assert.assertEquals(18, greatestSumOfArr);
    }

    @Test
    public void getGreatestSumOfArr2() {
        int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
        int greatestSumOfArr = P218_GreatestSumOfSubArrays.getGreatestSumOfArr2(arr);
        Assert.assertEquals(18, greatestSumOfArr);
    }

    @Test
    public void getGreatestSumOfArr3() {
        int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
        int greatestSumOfArr = P218_GreatestSumOfSubArrays.getGreatestSumOfArr3(arr);
        Assert.assertEquals(18, greatestSumOfArr);
    }
}