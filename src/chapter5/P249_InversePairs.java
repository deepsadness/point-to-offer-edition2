package chapter5;

/**
 * 数组中的逆序对
 * <p>
 * 如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对总数。
 * 例如输入{7,5,6,4}，一共有5个逆序对，分别是（7,6），（7,5），（7,4），（6,4），（5,4）。
 */
public class P249_InversePairs {
    public static int getInversePairs(int[] arr) {
        int[] copy = new int[arr.length];
        int start = 0;
        int end = arr.length - 1;
        return inversePairsCore(arr, copy, start, end);
    }

    private static int inversePairsCore(int[] arr, int[] copy, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = (start + end) / 2;

        int leftCount = inversePairsCore(arr, copy, start, mid);
        int rightCount = inversePairsCore(arr, copy, mid + 1, end);

        int count = 0;
        int left = start;
        int right = mid + 1;
        int index = start;
        while (left <= mid && right <= end) {
            if (arr[left] > arr[right]) {
                copy[index++] = arr[right++];
                //left > right 就是逆序
                count += mid-left+1;
            } else {
                copy[index++] = arr[left++];
            }
        }

        while (left <= mid) {
            copy[index++] = arr[left++];
        }
        while (right <= end) {
            copy[index++] = arr[right++];
        }

        for (int i = start; i <= end; i++) {
            arr[i] = copy[i];
        }

        return leftCount + rightCount + count;
    }


    public static void mergeSort(int[] arr) {
        int[] copy = new int[arr.length];
        int start = 0;
        int end = arr.length - 1;

        mergeSort(arr, copy, start, end);
    }

    private static void mergeSort(int[] arr, int[] copy, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
//        if (mid - start > 0) {
        mergeSort(arr, copy, start, mid);
//        }
//        if (mid + 1 - end > 0) {
        mergeSort(arr, copy, mid + 1, end);
//        }
        mergeFromTwoSide(arr, copy, start, mid, end);
    }

    private static void mergeFromTwoSide(int[] arr, int[] copy, int start, int mid, int end) {
        int left = start;
        int right = mid + 1;
        int index = start;
        while (left <= mid && right <= end) {
            if (arr[left] > arr[right]) {
                copy[index++] = arr[right++];
            } else {
                copy[index++] = arr[left++];
            }
        }

        while (left <= mid) {
            copy[index++] = arr[left++];
        }
        while (right <= end) {
            copy[index++] = arr[right++];
        }

        for (int i = start; i <= end; i++) {
            arr[i] = copy[i];
        }
    }
}
