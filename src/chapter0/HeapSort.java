package chapter0;

/**
 * 堆排序
 * <p>
 * 将无序的数组调整成堆。
 * 然后不断的调整子序列。
 * <p>
 * 使用数组来表示 堆
 * <p>
 * 时间复杂度也是  O(nlog2n)
 * <p>
 * 适合数据比较多的时候来使用。
 */
public class HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 1) {
            return;
        }
        //初始化堆
        int length = arr.length;
        //1.简单的建堆。就是简单的将数组，构建成一个完全二叉树
        //将数组当作是一个树
        // [2, 53, 3, 15, 15, 10, 29, 18]
        // 等价于
        //     2
        //  53    3
        //15  15  10 29
        //18
        //因为是从0开始，所以需要-1。
        //high表示最高的层数 high = length / 2 - 1
        //从顶层往下
        for (int i = length / 2 - 1; i >= 0; i--) {
            maxifyHeap(arr, i, length);
        }

        //排序
        // 2.取出最大值，继续分别调整完全二叉树的子树
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
