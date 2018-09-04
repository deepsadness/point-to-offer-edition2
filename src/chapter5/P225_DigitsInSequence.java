package chapter5;

/**
 * 数字序列中某一位的数字
 * <p>
 * 数字以01234567891011121314...的格式排列。
 * 在这个序列中，第5位（从0开始计）是5，第13位是1，第19位是4。
 * 求任意第n为对应的数字。
 */
public class P225_DigitsInSequence {
    public static int digitAtIndex(int index) {
        if (index < 10) {
            return index;
        }

        int length = 1;
        int sum = lengthSum(1);
        while (sum < index) {
            length++;
            sum += lengthSum(length);
        }

        //得到对应的length
        int i = sum-lengthSum(length);
        int offset = index - i;
        int curLength = length;
        int i1 = offset / curLength;
        int i2 = offset % curLength;

        int base = 1;
        for (int j = 1; j < length; j++) {
            base = base * 10;
        }
        base--;
        int finalOffset = base + i1 + (i2 > 0 ? 1 : 0);
        char c;
        if (i2 > 0) {
            c = String.valueOf(finalOffset).charAt(i2 - 1);
        } else {
            c = String.valueOf(finalOffset).charAt(length - 1);
        }

        return c - '0';
    }

    public static int lengthSum(int length) {
        int count = 9;
        for (int i = 1; i < length; i++)
            count *= 10;
        return count * length;
    }

}
