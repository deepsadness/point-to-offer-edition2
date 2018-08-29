package chapter2;

/**
 * 二进制中1的个数
 * <p>
 * 实现一个函数，输入一个int型整数，输出该数字在计算机中二进制表示形式的1的个数。
 * 例如9->1001,输出2；-3->11111111111111111111111111111101,输出31。
 */
public class P100_NumberInBinary {

    /**
     * 将数字无符号右移，直到为0。
     *
     * 因为会可能有负数，所以需要做无符号移动
     */
    public static int getBinarySumUnsignedRight(int number) {
        int count = 0;
        int calValue = number;
        System.out.println("number=" + Integer.toBinaryString(number));
        while (calValue != 0) {
            if ((calValue & 1) != 0) {
                count++;
                System.out.println("count++");
            }
            calValue = calValue >>> 1;
        }
        return count;
    }

    /**
     * 同样的，可以通过移动flag，当其移动到负数时就结束。
     */
    public static int getBinarySumLeftFlag(int number) {
        int count = 0;
        int calValue = number;
        int flag = 1;
        System.out.println("number=" + Integer.toBinaryString(number));
        while (flag != 0) {
            if ((calValue & flag) != 0) {
                count++;
                System.out.println("count++");
            }
            flag = flag << 1;
            System.out.println("flag=" + Integer.toBinaryString(flag));
        }
        return count;
    }
}
