package chapter6;

/**
 * 数组中只出现一次的两个数字
 * <p>
 * 一个整数数组里除了两个数字出现一次，其他数字都出现两次。
 * 请找出这两个数字。要求时间复杂度为o(n)，空间复杂度为o(1)。
 */
public class P275_NumberAppearOnce {

    /**
     * 思路。
     * 1.如果能分组的话，就可以轻松清除出想要的结果。根据位数进行消除
     */
    public static int[] onceNumber(int[] arr) {
        if (arr == null || arr.length < 2) {
            return null;
        }

        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            //取异或，重复出现会消除
            temp = temp ^ arr[i];
        }
        int[] results = {0, 0};
        //找出第一个为1的位数
        int bitOffset = findFirst1Bit(temp);
        if (bitOffset == -1) {
            return results;
        }

        for (int i = 0; i < arr.length; i++) {
            if (bitOffsetIsOk(arr[i], bitOffset)) {
                results[0] = results[0] ^ arr[i];
            } else {
                results[1] = results[1] ^ arr[i];
            }
        }
        return results;
    }

    private static boolean bitOffsetIsOk(int temp, int bitOffset) {
        temp = temp >>> bitOffset;
        return (temp & 1) == 1;
    }

    public static int findFirst1Bit(int temp) {
        if (temp == 0) {
            return -1;
        }
        int count = 0;
        while ((temp & 1) != 1 && temp != 0) {
            count++;
            temp = temp >>> 1;
        }
        return count;
    }
}
