package chapter3;

/**
 * 调整数组顺序使奇数位于偶数前面
 * <p>
 * 实现一个函数来调整数组中的数字，使得所有奇数位于数组的前半部分，偶数位于后半部分。
 */
public class P129_ReorderArray {
    public static void reorder0(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int oddIndex = 0;
        int evenIndex = 0;
        int[] odd = new int[arr.length];
        int[] even = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            if ((value & 1) == 1) { //odd
                odd[oddIndex] = value;
                oddIndex++;
            } else {
                even[evenIndex] = value;
                evenIndex++;
            }
        }

        for (int i = 0; i < oddIndex; i++) {
            arr[i] = odd[i];
        }
        for (int i = 0; i < evenIndex; i++) {
            arr[oddIndex + i] = even[i];
        }
    }

    public static void reorder1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int oddIndex = 0;
        int[] odd = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            if ((value & 1) == 1) { //odd
                odd[oddIndex] = i;
                oddIndex++;
            }
        }

        int temp = 0;
        for (int i = 0; i < oddIndex; i++) {
            int oddIndexC = odd[i];
            if (oddIndexC != i) { //和当前的坐标相比，不同就需要交换
                temp = arr[i];
                arr[i] = arr[oddIndexC];
                arr[oddIndexC] = temp;
            }
        }

    }

    public static void reorder2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            while (start < arr.length && isaBoolean(arr[start])) {
                start++;
            }
            while (end >= 0 && !isaBoolean(arr[start])) {
                end--;
            }

            if (start < end) {  //交换
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
        }
    }

    public static void reorder3(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            while (start < arr.length && isaBoolean2(arr[start])) {
                start++;
            }
            while (end >= 0 && !isaBoolean2(arr[end])) {
                end--;
            }

            if (start < end) {  //交换
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
        }
    }

    private static boolean isaBoolean(int i) {
        return (i & 1) == 1;
    }

    private static boolean isaBoolean2(int i) {
        return i < 0;
    }

    private static boolean isaBoolean3(int i) {
        return i % 3 == 0;
    }
}
