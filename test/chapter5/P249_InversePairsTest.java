package chapter5;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class P249_InversePairsTest {

    @Test
    public void mergeSort() {
        int[] target = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] targetCopy = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        P249_InversePairs.mergeSort(target);
        System.out.println(Arrays.toString(target));
        Arrays.sort(targetCopy);
        Assert.assertTrue(Arrays.equals(target, targetCopy));
    }

    @Test
    public void getInversePairs() {
        int[] a
                = {7, 5, 6, 4,3,2};
        int inversePairs = P249_InversePairs.getInversePairs(a);
        System.out.println(inversePairs);
    }
}