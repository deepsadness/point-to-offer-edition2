package chapter0;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class InsertSortTest {

    @Test
    public void shellSort() {
        int[] target = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] targetCopy = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        InsertSort.shellSort(target);
        Arrays.sort(targetCopy);
        Assert.assertTrue(Arrays.equals(target, targetCopy));
    }
}