package chapter5;

/**
 * 连续子数组的最大和
 * <p>
 * 输入一个整形数组，
 * 数组里有正数也有负数。
 * 数组中一个或连续多个整数组成一个子数组。
 * 求所有子数组的和的最大值，要求时间复杂度为o(n)。
 */
public class P218_GreatestSumOfSubArrays {

    //暴力求解的方式 时间复杂度为O(n2)
    public static int getGreatestSumOfArr(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int startIndex = 0;
        int greatest = arr[0];


        while (startIndex < arr.length - 1) {
            int tempGreatest = arr[startIndex];
            int nextIndex = startIndex + 1;
            while (nextIndex < arr.length) {
                tempGreatest += arr[nextIndex];
                if (greatest < tempGreatest) {
                    greatest = tempGreatest;
                }
                nextIndex++;
            }
            startIndex++;
        }
        return greatest;
    }

    //思路2：观察到 加上当前数的和，小于当前数时，就可以抛弃，从当前数开始了
    public static int getGreatestSumOfArr2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) return arr[0];

        int tempGreatest = arr[0];
        int greatest = tempGreatest;
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            tempGreatest = tempGreatest + temp;
            if (tempGreatest < arr[i]) {
                tempGreatest = arr[i];
            } else if (greatest < tempGreatest) {
                greatest = tempGreatest;
            }
        }
        return greatest;
    }

    /**
     * 思路3
     * 动态规划的思想。需要先总结出表达式
     * <p>
     * max(f(i-1))
     * <p>
     * f(i)= data[i] ==>  i==0 || f(i-1)<=0
     * f(i-1)  ==>  i!=0 || f(i-1)>0
     */
    public static int getGreatestSumOfArr3(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) return arr[0];
        return getGreatestSumDynamic(arr, 0, 0, 0);
    }

    private static int getGreatestSumDynamic(int[] arr, int startIndex, int sum, int greatest) {
        if (startIndex >= arr.length) {
            return greatest;
        }
        if (startIndex == 0 || sum <= 0) {
            sum = arr[startIndex];
            int great = greatest > sum ? greatest : sum;
            return getGreatestSumDynamic(arr, startIndex + 1, sum, great);
        } else {
            sum += arr[startIndex];
            int great = greatest > sum ? greatest : sum;
            return getGreatestSumDynamic(arr, startIndex + 1, sum, great);
        }
    }
}
