package chapter0;

public class SwapSort {
    /**
     * 冒泡排序
     * 就是每次循环，不断的对比相邻的两个数，将最小的数放到左边。
     * 这样不断的产生有序的子数列。
     */
    public static void bubleSort(int[] arr) {
        int length = arr.length;
        boolean flag = false;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                return;
            }
        }
    }

    public static void bubleSort2(int[] arr) {
        int length = arr.length;
        int flag;
        for (int i = arr.length - 1; i >= 1; i--) {
            flag = 0;
            for (int j = 1; j <= i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    flag = 1;
                }
            }
            if (flag == 0) {
                return;
            }
        }
    }


    public static void qSort(int[] arr, int head, int tail) {
        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }
        int i = head, j = tail, pivot = arr[(head + tail) / 2];
        while (i <= j) {
            while (arr[i] < pivot) {
                ++i;
            }
            while (arr[j] > pivot) {
                --j;
            }
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                ++i;
                --j;
            } else if (i == j) {
                ++i;
            }
        }
        qSort(arr, head, j);
        qSort(arr, i, tail);
    }

    public static void quickSort(int[] arr) {
        int length = arr.length;
        qSort(arr, 0, length - 1);
    }

    /**
     * 递归的方式来进行快速排序
     * <p>
     * 快速排序的过程就是从两边两个指针，不断缩进。
     * 当不满足大小条件时，就交换当前的两个指针的位置，然后继续
     * <p>
     * 通过这样的方式，找到当前大小的位置。通过不断划分子序列，使子序列有序，来完成排序。
     */
    public static void quickSortRecursive(int[] arr, int start, int end) {
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


    static class Range {
        int start, end;

        Range(int s, int end) {
            this.start = s;
            this.end = end;
        }
    }

    /**
     * 迭代方式的快速排序。
     * 如果不适用递归的话，就需要自己来管理一个栈，来完成排序。
     * 将划分的子序列，不断入栈，然后弹出，进行排序。
     * <p>
     * 当栈中，不存在元素时，就表示完成了。
     */
    public static void quickSort3(int[] arr) {
        int lenght = arr.length;
        if (lenght <= 0) {
            return;
        }

        Range[] r = new Range[lenght];
        int p = 0;
        r[p++] = new Range(0, lenght - 1);
        while (p > 0) {
            Range range = r[--p];
            if (range.start >= range.end) {
                continue;
            }

            int mid = arr[range.end];
            int left = range.start, right = range.end - 1;
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
            r[p++] = new Range(range.start, left - 1);
            r[p++] = new Range(left + 1, range.end);
        }
    }
}