package chapter5;

/**
 * 最小的k个数
 * <p>
 * 找出n个整数中最小的k个数。例如输入4,5,1,6,2,7,3,8，则最小的4个数字是1,2,3,4。
 * <p>
 * <p>
 * 主要有下面几种思路：
 * 1. 排序后，取出前K O(nlgn) O(1) 修改原始数组
 * 2. 执行K次直接选择排序， O(n*k)  修改原始数组
 * 3. 堆排序 O(nlogk) O(k)  不修改原始数组
 * 4. 快排找出index<K+1的所有元素 O（n）修改原数组
 * 5. 维护一个长度为K的升序数组，用二分法更新元素 o(nlgK) o(k)
 */
public class P209_KLeastNumbers {

    /**
     * 第一种思路:直接排序.会修改原始数组
     */
    public static int[] findKLeastNumbersWithQuickSort(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return null;
        }

        //直接排序
        quickSort(arr, 0, arr.length - 1);
        //取出top K
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;

        }

        int left = start;
        int right = end;
        int base = arr[left];

        while (left < right) {
            while (left < right && arr[right] > base) {
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

    /**
     * 第二种思路，直接选择排序.修改数组
     */
    public static int[] findKLeastNumbersWithSelectSort(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return null;
        }
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            int temp = arr[i];
            int tempIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (temp > arr[j]) {
                    temp = arr[j];
                    tempIndex = j;
                }
            }
            if (tempIndex != i) {
                arr[tempIndex] = arr[i];
                arr[i] = temp;
            }
        }

        //取出top K
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }


    /**
     * 第3种思路，直接堆排
     * 不会修改原数组，适合处理海量数据
     * k个元素的最大堆调整时间复杂度为o(logk),所以总的时间复杂度为o(nlogk)
     */
    public static int[] findKLeastNumbersWithHeapSort(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return null;
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        //建立最大堆
        for (int i = (k >> 1) - 1; i >= 0; i--) {
            maxifyHeap(result, i, k);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] < result[0]) {   //还有更小的
                //把当前最大的替换掉
                result[0] = arr[i];
                //进行调整
                maxifyHeap(result, 0, k);
            }
        }

        return result;
    }

    private static void maxifyHeap(int[] arr, int low, int high) {
        int root = low;
        int left = 2 * root + 1;
        int rootValue = arr[low];
        while (left < high) {
            //如果右边大，则取右边
            if (left + 1 < high && arr[left + 1] > arr[left]) {
                left++;
            }
            if (arr[left] > rootValue) {   //如果大于头结点
                arr[root] = arr[left];
                root = left;
                left = 2 * root + 1;
            } else {
                break;
            }
        }

        arr[root] = rootValue;
    }

    /**
     * 第4种思路，快排top K。这种思路就是只成功排序前面k个
     */
    public static int[] findKLeastNumbersQuickSortTopK(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return null;
        }
        int[] result = new int[k];

        int start = 0;
        int end = arr.length - 1;

        quickFindK(arr, start, end, k);
        //取出top K
        for (int j = 0; j < k; j++) {
            result[j] = arr[j];
        }
        return result;
    }

    private static void quickFindK(int[] arr, int start, int end, int k) {
        if (start > end) {
            return;
        }
        int index = partition(arr, start, end);
        if (index == k - 1) {
            quickFindK(arr, start, index - 1, k);
        } else if (index > k - 1) {
            quickFindK(arr, start, index - 1, k);
        } else {
            quickFindK(arr, index + 1, end, k);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int left = start;
        int right = end;
        int base = arr[left];

        while (left < right) {
            while (left < right && arr[right] > base) {
                right--;
            }
            //移动的给不动的赋值
            if (left < right) {
                arr[left] = arr[right];
                left++;
            }

            while (left < right && arr[left] < base) {
                left++;
            }
            //移动的给不动的赋值
            if (left < right) {
                arr[right] = arr[left];
                right--;
            }
        }

        arr[left] = base;
        return left;
    }


    /**
     * 创建一个新数组，使用二分
     */
    public static int[] findKLeastNumbers5(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) {
            return null;
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }

        //排序
        quickSort(result, 0, k - 1);

        for (int i = k; i < arr.length; i++) {
            if (arr[i] < result[k - 1]) {
                int low = 0;
                int high = k - 1;
                int index = binarySearch(result, arr[i], low, high);
                if (index != -1 && index < k) {
                    //插入
                    for (int j = k - 1; j > index; j--) {
                        result[j] = result[j - 1];
                    }
                    result[index] = arr[i];
                }

            }
        }
        return result;
    }

    private static int binarySearch(int[] arr, int k, int low, int high) {
        if (low >= high) {
            return low;
        }
        int mid = (low + high) >> 1;
        if (arr[mid] > k) {
            high = mid - 1;
            if (high==low){
                return mid;
            }
            return binarySearch(arr, k, low, high);
        } else {
            low = mid + 1;
            return binarySearch(arr, k, low, high);
        }
    }
}
