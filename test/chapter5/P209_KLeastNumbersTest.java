package chapter5;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class P209_KLeastNumbersTest {

    @Test
    public void findKLeastNumbers1() {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        int[] result = {1, 2, 3, 4};
        int[] kLeastNumbers1 = P209_KLeastNumbers.findKLeastNumbersWithQuickSort(arr, 4);
        Assert.assertTrue(Arrays.equals(result, kLeastNumbers1));
    }

    @Test
    public void findKLeastNumbers2() {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        int[] result = {1, 2, 3, 4};
        int[] kLeastNumbers1 = P209_KLeastNumbers.findKLeastNumbersWithSelectSort(arr, 4);

        Assert.assertTrue(Arrays.equals(result, kLeastNumbers1));
    }

    @Test
    public void findKLeastNumbers3() {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        int[] result = {1, 2, 3, 4};
//        int kLeastNumbers1 = P209_KLeastNumbers.getLeastNumbers3(arr, 4);
        int[] kLeastNumbers1 = P209_KLeastNumbers.findKLeastNumbersWithHeapSort(arr, 4);
//        System.out.println(kLeastNumbers1);
        System.out.println(Arrays.toString(kLeastNumbers1));
//        Assert.assertEquals(4, kLeastNumbers1);
    }

    @Test
    public void findKLeastNumbers4() {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        int[] result = {1, 2, 3, 4};
        int[] kLeastNumbers1 = P209_KLeastNumbers.findKLeastNumbersQuickSortTopK(arr, 4);
        Assert.assertTrue(Arrays.equals(result, kLeastNumbers1));
    }

    @Test
    public void findKLeastNumbers5() {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        int[] result = {1, 2, 3, 4};
        int[] kLeastNumbers1 = P209_KLeastNumbers.findKLeastNumbers5(arr, 4);
        Assert.assertTrue(Arrays.equals(result, kLeastNumbers1));
    }
}