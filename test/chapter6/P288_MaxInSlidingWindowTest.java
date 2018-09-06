package chapter6;

import org.junit.Test;

import java.util.Arrays;

public class P288_MaxInSlidingWindowTest {


    @Test
    public void maxInSlidingWindow1() {
        int[] arr = {2, 3, 4, 2, 6, 2, 5, 1};
        int slidingWindowCount = 3;
        int[] ints = P288_MaxInSlidingWindow.maxInSlidingWindow(arr, slidingWindowCount);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void maxInSlidingWindow2() {
        int[] arr = {2, 3, 4, 2, 6, 2, 5, 1};
        int slidingWindowCount = 3;
        int[] ints = P288_MaxInSlidingWindow.maxInSlidingWindow2(arr, slidingWindowCount);
        System.out.println(Arrays.toString(ints));
    }
}