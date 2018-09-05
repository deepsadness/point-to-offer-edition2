package chapter6;

/**
 * 0~n中缺失的数字
 * <p>
 * 一个长度为n的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0~n之内。
 * 在范围0~n内的n个数字有且只有一个数字不在该数组中，请找出。
 */
public class P266_GetMissingNumber {
    public static int getMissingNumber(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int target = -1;

        while (low >= 0 && low <= high && high < arr.length) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] == mid) { //往后继续找
                low = mid + 1;
            } else { //不等，往前找.找到第一个不等的
                if (mid == low || arr[mid - 1] == mid - 1) {
                    //就是他了
                    target = mid;
                    break;
                } else {
                    high = mid - 1;
                }
            }
        }
        return target == -1 ? arr.length : target;
    }

    public static int getMissingNumber2(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int target = -1;

        while (low >= 0 && low <= high && high < arr.length) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] == mid) { //往后继续找
                low = mid + 1;
            } else { //不等，往前找.找到第一个不等的
                high = mid - 1;
            }
        }
        return low;
    }
}
