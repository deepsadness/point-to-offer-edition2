package chapter0;

/**
 * 堆排序
 */
public class HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 1) {
            return;
        }
        //初始化堆
        int length = arr.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            maxifyHeap(arr, i, length);
        }

        //排序
        for (int i = length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxifyHeap(arr, 0, i);
        }
    }

    private static void maxifyHeap(int[] arr, int low, int length) {
        //头结点
        int head = low;
        int left = 2 * head + 1;
        int tempHead = arr[head];

        while (left < length) {
            //对比左右结点。如果右结点存在。而且右结点大；
            if (left + 1 < length && arr[left] < arr[left + 1]) {
                //使用右结点
                left++;
            }
            //如果当前的子节点比父节点还大
            if (tempHead < arr[left]) {
                //赋值给头结点
                arr[head] = arr[left];
                // 将较大的点，作为下一次的头结点，进行遍历。
                head = left;
                // 同样初始化为做节点
                left = 2 * head + 1;
            } else {
                break;
            }
        }
        arr[head] = tempHead;
    }
}
