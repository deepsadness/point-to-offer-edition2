package chapter6;

import org.junit.Test;

public class P280_TwoNumbersWithSumTest {

    @Test
    public void findNumbersWithSum() {
        int[] data = new int[]{1, 2, 4, 7, 11, 15};
        String result = P280_TwoNumbersWithSum.findNumbersWithSum(data, 15);
        System.out.println(result);
    }
}