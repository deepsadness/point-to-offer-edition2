package chapter0;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SwapSortTest {

    @Test
    public void bubleSort() {
//        int[] target = {49, 38, 65, 97, 76, 13, 27, 49};
        int[] target = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] targetCopy = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        SwapSort.bubleSort(target);
        Arrays.sort(targetCopy);
        Assert.assertTrue(Arrays.equals(target, targetCopy));
    }

    @Test
    public void bubleSort2() {
//        int[] target = {49, 38, 65, 97, 76, 13, 27, 49};
        int[] target = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] targetCopy = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        SwapSort.bubleSort2(target);
        Arrays.sort(targetCopy);
        Assert.assertTrue(Arrays.equals(target, targetCopy));

    }

    @Test
    public void quickSort() {
        int[] target = {49, 38, 65, 97, 76, 13, 27, 49};
        int[] targetCopy = {49, 38, 65, 97, 76, 13, 27, 49};
//        int[] target = {1, 2, 3, 2, 2, 2, 5, 4, 2};
//        int[] targetCopy = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        SwapSort.quickSort(target);
        Arrays.sort(targetCopy);
        Assert.assertTrue(Arrays.equals(target, targetCopy));
    }

    @Test
    public void quickSortRecursive() {
        int[] target = {49, 38, 65, 97, 76, 13, 27, 49};
        int[] targetCopy = {49, 38, 65, 97, 76, 13, 27, 49};
//        int[] target = {1, 2, 3, 2, 2, 2, 5, 4, 2};
//        int[] targetCopy = {1, 2, 3, 2, 2, 2, 5, 4, 2};

        SwapSort.quickSortRecursive(target, 0, target.length - 1);
        Arrays.sort(targetCopy);

        Assert.assertTrue(Arrays.equals(targetCopy, target));
    }

    @Test
    public void quickSort4() {
        int[] target = {49, 38, 65, 97, 76, 13, 27, 49};
        int[] targetCopy = {49, 38, 65, 97, 76, 13, 27, 49};
//        int[] target = {1, 2, 3, 2, 2, 2, 5, 4, 2};
//        int[] targetCopy = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        SwapSort.quickSort4(target);
        Arrays.sort(targetCopy);

        Assert.assertTrue(Arrays.equals(targetCopy, target));

    }
}