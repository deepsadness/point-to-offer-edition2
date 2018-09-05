package chapter6;

/**
 * 数组中数值和下标相等的元素
 * <p>
 * 假设一个单调递增的数组里的每个元素都是整数且是唯一的。
 * 编写一个程序，找出数组中任意一个数值等于其下标的元素。例如，输入{-3,-1,1,3,5}，输出3。
 */
public class P267_IntegerIdenticalToIndex {
    public static int findIndexEqualInteger(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] == mid) {
                return mid;
            } else if (arr[mid] < mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
