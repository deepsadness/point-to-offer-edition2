package chapter6;

/**
 * 数字在排序数组中出现的次数
 * <p>
 * 统计一个数字在排序数组中出现的次数。
 * 例如，输入{1,2,3,3,3,3,4,5}和数字3，由于3在这个数组中出现了4次，因此输出4。
 */
public class P263_NumberOfK {
    //上面这两种因为有遍历的情况，所以时间复杂度都是 O(n)
    public static int findNumberTimes(int[] arr, int number) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int left = 0;
        int right = arr.length - 1;

        while (left <= right && arr[left] != number) {
            left++;
        }
        if (left > right) {
            return 0;
        }
        while (left <= right && arr[right] != number) {
            right--;
        }

        if (left == right) {
            return 1;
        } else if (left > right) {
            return 0;
        } else {
            return right - left + 1;
        }
    }

    public static int findNumberTimes2(int[] arr, int number) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        //二分查找法
        int low = 0;
        int high = arr.length - 1;
        int targetIndex = -1;
        while (low <= high && low >= 0) {
            int mid = (low + high) >> 1;
            if (arr[mid] == number) {
                targetIndex = mid;
                break;
            } else if (arr[mid] > number) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (targetIndex == -1) {
            return 0;
        }
        int count = 1;
        int tempIndex = targetIndex;
        while (tempIndex < arr.length) {
            tempIndex++;
            if (arr[tempIndex] == number) {
                count++;
            } else {
                break;
            }
        }
        tempIndex = targetIndex;
        while (tempIndex > 0) {
            tempIndex--;
            if (arr[tempIndex] == number) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }

    /**
     * 上面这两种因为有遍历的情况，所以时间复杂度都是 O(n).
     * 这种只用了二分查找，复杂度位O(lgn)
     */
    public static int findNumberTimes3(int[] arr, int number) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        //二分查找法
        int targetFirstIndex = getFirstK(arr, number);
        if (targetFirstIndex == -1) {
            return 0;
        }
        int targetLastIndex = getLastK(arr, number);
        return targetLastIndex - targetFirstIndex + 1;
    }

    private static int getFirstK(int[] arr, int number) {
        int low = 0;
        int high = arr.length - 1;

        int targetFirstIndex = -1;
        while (low <= high && low >= 0) {
            //使用这种方式比较好。迭代次数较少。在长度为偶数时！！！
            int mid = low + (high - low) >> 1;
//            int mid = (high + low) >> 1;
            if (arr[mid] == number) {
                if (mid == low || (arr[mid - 1] != number)) { //表示自己是第一个了
                    targetFirstIndex = mid;
                    break;
                } else {
                    //并不是第一个。往前找
                    high = mid - 1;
                }
            } else if (arr[mid] > number) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return targetFirstIndex;
    }

    private static int getLastK(int[] arr, int number) {
        int low = 0;
        int high = arr.length - 1;

        int lastIndex = -1;
        while (low <= high && low >= 0) {
            int mid = (low + high) >> 1;
            if (arr[mid] == number) {
                if (mid == high || (arr[mid + 1] != number)) { //表示已经是最后一个了
                    lastIndex = mid;
                    break;
                } else {
                    //并不是第一个。往前找
                    low = mid + 1;
                }
            } else if (arr[mid] > number) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return lastIndex;
    }
}
