package chapter2;


/**
 * 旋转数组的最小数字
 * <p>
 * 题目要求：
 * 把一个数组最开始的若干个元素搬到末尾称为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * <p>
 * 比如 数组 {3，4，5，1，2} 为 {1，2，3，4，5}的一个旋转，该数组的最小值为1
 */
public class P82_MinNumberInRotatedArray {

    public static int findMin(int[] arr) {

        if (arr == null || arr.length == 0) {
            return -1;
        }

        int length = arr.length;
        if (length == 1) {
            return arr[0];
        }

        int startIndex = 0;
        int endIndex = length - 1;


        while (startIndex < endIndex) {
            int start = arr[startIndex];
            int end = arr[endIndex];

            //这里要注意的是 (2+3)/2=2 ,这类问题!!
            int mid = (startIndex + endIndex) / 2;
            if (start < end && endIndex != mid) {
                endIndex = mid;
            } else if (start > end && startIndex != mid) {
                startIndex = mid;
            } else {
                //如果相等的情况下，就只能分别进位了
                endIndex--;
                startIndex++;
            }
        }
        return arr[startIndex];
    }
}
