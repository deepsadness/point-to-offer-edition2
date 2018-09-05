package chapter6;

/**
 * 和为s的连续正数序列
 * <p>
 * 输入一个整数s，打印所有和为s的连续正数序列(至少两个)。
 * 例如，
 * 输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以打印出三个连续序列1-5,4-6,7~8。
 */
public class P282_ContinuousSequenceWithSum {
    public static String continuousSequenceWithSum(int sum) {
        if (sum < 3) {
            return "";
        }
        divide(sum);
        return "";
    }

    //直接进行分解。等分解的最左边为1时，就不能分解了
    //总结下来就是 2N>P^2  时间复杂度 O(n1/2)?
    private static void divide(int sum) {
        int divideCount = 2;
        if ((sum & 1) == 0) {
            divideCount++;
        }
        int perD = sum / divideCount;
        int halfDivider = divideCount / 2;
        int tempSum = 0;
        boolean isOffsetLeft = false;
        while (perD - halfDivider >= 1) {
            if (divideCount == 2) {
                tempSum = perD * 2 + 1;
            } else if ((divideCount & 1) == 1) { //奇数的话，只有一种可能性
                //公式  (perD - halfDivider + perD + halfDivider) * divideCount / 2; 简化如下
                tempSum = 2 * perD * divideCount / 2;
            } else { //偶数有两种
//                int tempSum1 = ((perD - halfDivider + 1) + (perD + halfDivider)) * divideCount / 2;
//                int tempSum2 = ((perD - halfDivider) + (perD + halfDivider - 1)) * divideCount / 2;
                //简化
                int tempSum1 = (perD + perD + 1) * divideCount / 2;
                int tempSum2 = (perD + perD - 1) * divideCount / 2;
                if (tempSum1 == sum) {
                    tempSum = tempSum1;
                    isOffsetLeft = false;
                } else if (tempSum2 == sum) {
                    tempSum = tempSum2;
                    isOffsetLeft = true;
                }
            }
            if (tempSum == sum) {
                printDivider(divideCount, perD, isOffsetLeft);
            }
            tempSum = 0;
            divideCount++;
            perD = sum / divideCount;
            halfDivider = divideCount / 2;
        }
    }

    private static void printDivider(int divideCount, int perD, boolean isOffsetLeft) {
        if (divideCount == 2) {
            System.out.println(perD + "," + (perD + 1) + ",");
        } else if ((divideCount & 1) == 1) {
            int half = divideCount / 2;
            StringBuilder stringBuilder = new StringBuilder(divideCount);
            for (int i = -half; i <= half; i++) {
                stringBuilder.append(perD + i).append(",");
            }
            System.out.println(stringBuilder.toString());
        } else {
            int half = divideCount / 2;
            int start = -half;
            int end = half;
            if (isOffsetLeft) {
                end--;
            } else {
                start++;
            }
            StringBuilder stringBuilder = new StringBuilder(divideCount);
            for (int i = start; i <= end; i++) {
                stringBuilder.append(perD + i).append(",");
            }
            System.out.println(stringBuilder.toString());
        }
    }

    /**
     * 与上一题类似，依旧使用两个指针small，big，值分别为1，2。
     * 如果从small加到big的和等于s，即找到了一组解，然后让big后移，继续求解。
     * 如果和小于s，big后移，
     * 如果和大于s，small前移。
     * <p>
     * 直到small大于s/2停止。
     *
     * 时间复杂度 O(n)?
     */
    public static void findContinuousSequence(int sum) {
        if (sum < 3)
            return;
        int small = 1, big = 2, middle = sum >> 1;
        int curSum = small + big;
        while (small <= middle) {
            if (curSum == sum) {
                printContinousSequence(small, big);
                big++;
                curSum += big;
            } else if (curSum < sum) {
                big++;
                curSum += big;
            } else {
                curSum -= small;
                small++;
            }
        }
    }

    public static void printContinousSequence(int small, int big) {
        for (int i = small; i <= big; i++) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
    }

}
