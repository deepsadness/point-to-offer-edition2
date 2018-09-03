package chapter0;

import org.junit.Test;

import java.util.Arrays;

public class SwapSortTest {

    @Test
    public void bubleSort() {
//        int[] target = {49, 38, 65, 97, 76, 13, 27, 49};
        int[] target = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(Arrays.toString(target));
        SwapSort.bubleSort(target);
        System.out.println(Arrays.toString(target));

    }

    @Test
    public void bubleSort2() {
//        int[] target = {49, 38, 65, 97, 76, 13, 27, 49};
        int[] target = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(Arrays.toString(target));
        SwapSort.bubleSort2(target);
        System.out.println(Arrays.toString(target));

    }

    @Test
    public void quickSort() {
//        int[] target = {49, 38, 65, 97, 76, 13, 27, 49};
        int[] target = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(Arrays.toString(target));
        SwapSort.quickSort(target);
        System.out.println(Arrays.toString(target));

    }

    @Test
    public void quickSortRecursive() {
//        int[] target = {49, 38, 65, 97, 76, 13, 27, 49};
        int[] target = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(Arrays.toString(target));
        SwapSort.quickSortRecursive(target, 0, target.length - 1);
        System.out.println(Arrays.toString(target));

    }

    @Test
    public void quickSort3() {
//        int[] target = {49, 38, 65, 97, 76, 13, 27, 49};
        int[] target = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(Arrays.toString(target));
        SwapSort.quickSort3(target);
        System.out.println(Arrays.toString(target));

    }
}