package chapter6;

/**
 * 滑动窗口的最大值
 * <p>
 * 给定一个数组和滑动窗口的大小，请找出所有滑动窗口的最大值。
 * 例如，输入数组{2,3,4,2,6,2,5,1}和数字3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}。
 */
public class P288_MaxInSlidingWindow {
    public static int[] maxInSlidingWindow(int[] arr, int width) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        if (width > arr.length) {
            return null;
        }
        int slidingWindowCount = arr.length - width + 1;
        int[] maxInts = new int[slidingWindowCount];
        for (int i = 0; i <= arr.length - width; i++) {
            int temp = arr[i];
            for (int j = 0; j < width; j++) {
                if (temp < arr[i + j]) {
                    temp = arr[i + j];
                }
            }
            maxInts[i] = temp;
        }

        return maxInts;
    }

    /**
     * 思路
     * 1. 窗口第一位是最大值
     * 下一个最大值，必须全量比较
     * 2. 窗口第一位不是最大值
     * 可以直接对比当前的下一个数字得到最大值。
     *
     */
    public static int[] maxInSlidingWindow2(int[] arr, int width) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        if (width > arr.length) {
            return null;
        }
        int slidingWindowCount = arr.length - width + 1;
        int[] maxInts = new int[slidingWindowCount];
        int temp = arr[0];
        int tempMaxIndex = 0;
        int nextStepStart = 0;
        for (int i = 0; i <= arr.length - width; i++) {

            for (int j = nextStepStart; j < width; j++) {
                if (temp < arr[i + j]) {
                    temp = arr[i + j];
                    tempMaxIndex = i + j;
                }
            }
            maxInts[i] = temp;

            if (tempMaxIndex == i && i + 1 <= arr.length - width) {   //如果是第一位，而且还需要遍历的话，就把它指向下一位
                temp = arr[i + 1];
                nextStepStart = 0;
            } else if (tempMaxIndex != i) { //如果不是第一位，就可以保留自己了。下一次只要比较下一个数字的大小，就可以
                nextStepStart =width - 1;
            }
        }

        return maxInts;
    }
}
