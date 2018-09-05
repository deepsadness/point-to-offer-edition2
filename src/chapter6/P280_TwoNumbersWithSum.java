package chapter6;

/**
 * 和为s的数字
 * <p>
 * 输入一个递增排序的数组和一个数字s，
 * 在数组中查找两个数，使它们的和为s。
 * 如果有多对和为s，输入任意一对即可。
 *
 * 解题思路：
 * 使用两个指针分别指向数组的头、尾。如果和大于s，头部指针后移，如果和小于s，尾部指针前移。
 *
 */
public class P280_TwoNumbersWithSum {
    public static String findNumbersWithSum(int[] arr, int s) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int left = 0;
        int right = arr.length - 1;

        while (left<right){
            int sum = arr[left] + arr[right];
            if (sum > s) {
                right--;
            } else if (sum < s) {
                left++;
            } else {
                return arr[left]+","+arr[right];
            }
        }

        return "";
    }
}
