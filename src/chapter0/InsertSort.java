package chapter0;

/**
 * 插入排序是在左边形成有序的子序列
 * 在比较的过程。通过相邻交换的方式，不断的将左边的子序列变成有序的序列。
 * 为什么交换相邻的就可以了？
 * 因为相邻的之前的子序列已经是有序的了。
 * <p>
 * <p>
 * 选择排序也是这样的思想。
 * 不同的是。
 * 选择排序，不会交换相邻的元素。
 * 而是找出最小的元素。然后最后和无序序列中的第一个元素进行交换。
 */
public class InsertSort {

    /**
     * 直接插入排序
     */
    public static void directInsertSort(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) {
            return;
        }
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            int current = arr[i];
            //和前面的有序序列进行对比。如果小于则交换
            directSort(arr, i, current);
        }
    }

    private static void directSort(int[] arr, int i, int current) {
        int end = i - 1;
        while (end >= 0) {
            if (arr[end] > current) {
                arr[end + 1] = arr[end];
                arr[end] = current;
                end--;
            } else {
                break;
            }
        }
    }

    public static void binaryInsertSort(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) {
            return;
        }
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            int current = arr[i];
            //和前面的有序序列进行对比。如果小于则交换
            binarySort(arr, i, current);
        }
    }

    private static void binarySort(int[] arr, int currentIndex, int current) {
        int low = 0;
        int high = currentIndex - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) >>> 1;
            int res = arr[mid] - current;
            if (res > 0) {
                high = mid - 1;
            } else if (res < 0) {
                low = mid + 1;
            } else {
                break;
            }
        }
        //找到真正的插入点
//        if (mid == currentIndex - 1 && arr[mid] > current) {
//            arr[currentIndex] = arr[currentIndex - 1];
//            arr[currentIndex - 1] = current;
//        } else {
        if (arr[mid] <= current) {
            mid++;
        }
        System.arraycopy(arr, mid, arr, mid + 1, currentIndex - mid);
        arr[mid] = current;
//        }
    }

    /**
     * 什么是希尔排序？
     * 就是变步长的插入排序
     */
    public static void shellSort(int[] arr) {
        int length = arr.length;
        //这里就是简单的定义步长为长度的一般
        int gap = length / 2;
        int j = 0;
        int temp = 0;
        //当步长大于等于1时
        while (gap >= 1) {
            //从这个步长开始遍历。因为后面会减去步长，所以其实等于从0开始遍历
            for (int i = gap; i < length; i++) {
                // 得到当前的值
                temp = arr[i];
                // 得到上一个这个步长位置上的值
                j = i - gap;

                while (j >= 0 && arr[j] > temp) {
                    //往右便宜步长个单位
                    arr[j + gap] = arr[j];
                    //index往前移动
                    j = j - gap;
                }
                //再将index移动回来
                arr[j + gap] = temp;
            }
            //不断的缩小步长
            gap = gap / 2;
        }
    }
}
