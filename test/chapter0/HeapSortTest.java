package chapter0;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Cry on 2018/9/4.
 */
public class HeapSortTest {
    @Test
    public void heapSort(){
        int[] target = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] targetCopy = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        SwapSort.bubleSort(target);
        Arrays.sort(targetCopy);
        Assert.assertTrue(Arrays.equals(target, targetCopy));
    }

}