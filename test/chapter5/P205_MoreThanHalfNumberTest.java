package chapter5;

import org.junit.Assert;
import org.junit.Test;

public class P205_MoreThanHalfNumberTest {

    @Test
    public void findMoreThanHalfNumber() {
        int[] arr
                = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int halfNumber = P205_MoreThanHalfNumber.findMoreThanHalfNumber(arr);
        Assert.assertEquals(2, halfNumber);
    }

    @Test
    public void findMoreThanHalfNumber2() {
        int[] arr
                = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int halfNumber = P205_MoreThanHalfNumber.findMoreThanHalfNumber2(arr);
        Assert.assertEquals(2, halfNumber);
    }
    @Test
    public void findMoreThanHalfNumber3() {
        int[] arr
                = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int halfNumber = P205_MoreThanHalfNumber.findMoreThanHalfNumber3(arr);
        Assert.assertEquals(2, halfNumber);
    }
}