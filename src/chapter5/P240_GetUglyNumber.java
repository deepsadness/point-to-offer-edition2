package chapter5;

/**
 * 丑数
 * <p>
 * 我们把只包含因子2,3,5的数成为丑数。
 * 求按照从小到大的顺序第1500个丑数。
 * <p>
 * 1作为第一个丑数。
 */
public class P240_GetUglyNumber {
    //暴力求解法
    public static int getUglyNumber(int order) {
        if (order == 0) return 0;
        if (order == 1) return 1;
        int count = 1;
        int index = 1;
        while (count < order) {
            index++;
            if (isUglyNumber(index)) {
                count++;
            }
        }
        return index;
    }

    private static boolean isUglyNumber(int num) {
        while (num % 2 == 0) {
            num = num / 2;
        }
        while (num % 3 == 0) {
            num = num / 3;
        }
        while (num % 5 == 0) {
            num = num / 5;
        }
        return num == 1;
    }

    /**
     * 利用丑数的特性
     * <p>
     * 1.用前面的数字乘以2，5，3得到
     * 2.乘过相同数字的数字就不用再乘过啦
     */
    public static int getUglyNumber2(int order) {
        if (order == 1) return 1;

        int[] uglyList = new int[order];
        uglyList[0] = 1;
        int index = 0;
        int m2 = 0;
        int m3 = 0;
        int m5 = 0;

        while (index < order - 1) {
            index++;
            int u2 = uglyList[m2] * 2;
            int u3 = uglyList[m3] * 3;
            int u5 = uglyList[m5] * 5;
            uglyList[index] = min(u2, u3, u5);
            if (uglyList[index] == u2) {
                //用过，下次就不会再重复这个数字了
                m2++;
            }
            //这样如果有重复的情况，也会直接++过去
            if (uglyList[index] == u3) {
                m3++;
            }
            if (uglyList[index] == u5) {
                m5++;
            }
        }
        return uglyList[order - 1];
    }

    public static int min(int x, int y, int z) {
        int temp = x < y ? x : y;
        return temp < z ? temp : z;
    }

}
