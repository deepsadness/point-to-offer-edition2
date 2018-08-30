package chapter3;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class P129_ReorderArrayTest {

    @Test
    public void reorder0() {
        int[] arr0 = {1, 2, 3, 4, 5};
        int[] arr1 = {1, 3, 5, 2, 4};
        P129_ReorderArray.reorder0(arr0);
        Assert.assertTrue(Arrays.equals(arr1, arr0));
    }

    @Test
    public void reorder1() {
        int[] arr0 = {1, 2, 3, 4, 5};
        int[] arr1 = {1, 3, 5, 4, 2};
        P129_ReorderArray.reorder1(arr0);
        Assert.assertTrue(Arrays.equals(arr1, arr0));
    }

    @Test
    public void reorder2() {
        int[] arr0 = {1, 2, 3, 4, 5};
        int[] arr1 = {1, 2, 3, 4, 5};

        P129_ReorderArray.reorder2(arr0);
//        System.out.println(Arrays.toString(arr0));
        Assert.assertTrue(Arrays.equals(arr1, arr0));
    }

    @Test
    public void reorder3() {
//        int[] arr0 = {-1, -2, -3, -4, -5};
        int[] arr0 = {1, 2, 3, 4, 5};
        int[] arr1 = {1, 2, 3, 4, 5};

        P129_ReorderArray.reorder3(arr0);
        System.out.println(Arrays.toString(arr0));
//        Assert.assertTrue(Arrays.equals(arr1, arr0));
    }
}