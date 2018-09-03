package chapter0;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Cry on 2018/9/4.
 */
public class MergeSortTest {
    @Test
    public void merge_sort() throws Exception {
//        int[] target = {49, 38, 65, 97, 76, 13, 27, 49};
        int[] target = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] targetCopy = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        MergeSort.merge_sort(target);
        Arrays.sort(targetCopy);
        Assert.assertTrue(Arrays.equals(target, targetCopy));
    }

}