package chapter7;

/**
 * 构建乘积数组
 * <p>
 * 给定数组A[0,1...n-1]，求B[0,1...n-1]，要求B[i] = A[0]*A[1]...A[i-1]*A[i+1]...A[n-1]，不能使用除法。
 */
public class P313_ConstructArray {
    //最暴力的求解方式
    public static int[] constructArray(int[] arr) {
        int[] result = new int[arr.length];

        for (int i = 0; i < result.length; i++) {
            if (i == 0) {
                result[i] = arr[1];
                for (int j = 2; j < result.length; j++) {
                    result[i] = result[i] * arr[i];
                }
            } else {
                result[i] = arr[0];
                for (int j = 1; j < result.length; j++) {
                    if (j != i) {
                        result[i] = result[i] * arr[i];
                    }
                }
            }

        }
        return result;
    }

    /**
     * 设
     * C[i] = A[0]*A[1]...A[i-1] => C[i]=C[i-1]A[i-1]
     * D[i] = A[i+1]*...A[n-1]   => D[i]=D[i-1]A[i+1]
     * <p>
     * ==> B[i]=C[i]*D[i]
     */
    public static int[] constructArray0(int[] arr) {
        int[] result = new int[arr.length];

        result[0] = 1;
        //先求C
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] * arr[i - 1];
        }

        //求B B[i]=C[i]*D[i]
        int tempD = 1;
        for (int i = result.length - 2; i > 0; i++) {
            tempD = tempD * arr[i + 1];
            result[i] = result[i] * tempD;
        }

        return result;
    }
}
