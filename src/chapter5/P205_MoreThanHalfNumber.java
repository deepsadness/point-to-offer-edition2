package chapter5;

import java.util.Arrays;

/**
 * 数组中出现次数超过一半的数字
 * <p>
 * 找出数组中出现次数超过数组长度一半的数字。如输入{1,2,3,2,2,2,5,4,2}，则输出2。
 */
public class P205_MoreThanHalfNumber {
    public static void findMoreThanHalfNumber(int[] arr) {
        if (arr == null || arr.length < 3) {
            return;
        }
        //排序，中位数
        quickSortRecursive(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start > end) {
            return;
        }

        int base = arr[end];
        int left = start;
        int right = end - 1;

        if (left < right) {
            while (left < right && arr[left] < base) {
                left++;
            }
            while (right > left && arr[right] > base) {
                right--;
            }
            int temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
        }

        if (arr[left] > arr[right]) {
            int temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
        } else {
            left++;
        }
        quickSort(arr, start, left - 1);
        quickSort(arr, left + 1, end);
    }

    private static void quickSortRecursive(int[] arr, int start, int end) {
        if (start > end) {
            return;
        }

        int mid = arr[end];
        int left = start;
        int right = end - 1;

        while (left < right) {
            while (arr[left] < mid && left < right) {
                left++;
            }
            while (arr[right] > mid && right > left) {
                right--;
            }
            int temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
        }

        if (arr[left] > arr[right]) {
            int temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
        } else {
            left++;
        }
        quickSortRecursive(arr, start, left - 1);
        quickSortRecursive(arr, left + 1, end);
    }

}
