package chapter5;

/**
 * 数组中出现次数超过一半的数字
 * <p>
 * 找出数组中出现次数超过数组长度一半的数字。如输入{1,2,3,2,2,2,5,4,2}，则输出2。
 */
public class P205_MoreThanHalfNumber {
    //思路1 ：先排序，求中位数
    public static int findMoreThanHalfNumber(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }
        //排序，中位数
        quickSort(arr, 0, arr.length - 1);
        return arr[arr.length / 2];
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start > end) {
            return;
        }

        int left = start;
        int right = end;
        int base = arr[left];

        while (left < right) {
            while (right > left && arr[right] > base) {
                right--;
            }

            if (left < right) {
                arr[left] = arr[right];
                left++;
            }

            while (left < right && arr[left] < base) {
                left++;
            }

            if (left < right) {
                arr[right] = arr[left];
                right--;
            }
        }
        arr[left] = base;

        quickSort(arr, start, left - 1);
        quickSort(arr, left + 1, end);
    }

    //思路2 使用快排分区 topK
    // //转化为topK问题（此处求第k小的值），使用快排的分区函数解决，求第targetIndex+1小的数字（下标为targetIndex）
    //书中说这种方法的时间复杂度为o(n)，但没懂为什么。网上也有人说为o(nlogk)
    public static int findMoreThanHalfNumber2(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int left = 0, right = arr.length - 1;
        //获取执行分区后下标为k的数据值（即第k+1小的数字）
        int k = arr.length >>> 1;
        int index = partition(arr, left, right);
        while (index != k) {
            if (index > k)
                index = partition(arr, left, index - 1);
            else
                index = partition(arr, index + 1, right);
        }
        return arr[k];
    }

    private static int partition(int[] arr, int left, int right) {
        if (left < right) {
            int start = left;
            int end = right;
            int base = arr[start];
            while (start < end) {
                while (start < end && arr[end] > base) {
                    end--;
                }

                if (start < end) {
                    arr[end] = arr[start];
                    start++;
                }

                while (start < end && arr[start] < base) {
                    start++;
                }

                if (start < end) {
                    arr[start] = arr[end];
                    end--;
                }
            }

            arr[start] = base;

            return start;
        }
        return left;
    }

    //思路3 缓存计数
    public static int findMoreThanHalfNumber3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        int value = arr[0];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (value == arr[i]) {
                count++;
            } else {
                if (count > 0) {
                    count--;
                } else {
                    value = arr[i];
                }
            }
        }
        return value;
    }


}
