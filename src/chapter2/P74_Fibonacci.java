package chapter2;

/**
 * 斐波那契数列
 * 题目要求：
 * <p>
 * 求斐波那契数列的第n项的值。f(0)=0, f(1)=1, f(n)=f(n-1)+f(n-2) n>1
 * <p>
 * 青蛙跳台阶：
 * 一只青蛙一次可以跳上1个台阶，也可以跳上2个台阶。求该青蛙跳上n个体台阶有多少中跳法。
 * <p>
 * 第一次跳1个台阶。就剩下 f(n-1)次跳法的数量
 * 第一次跳2个台阶，就剩下 f(n-2)次跳法的数量
 * <p>
 * 所以 总体跳n个台阶，就是 f(n)=f(n-1)+f(n-2).其实就是斐波纳数列
 */
public class P74_Fibonacci {

    /**
     * 递归的方式.
     * <p>
     * 这种方式效率很低，因为没有利用已经计算过的数字！！
     */
    public static int fibonacciRecursive(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    /**
     * 遍历的方式。
     * <p>
     * 利用了之前计算过的结果。时间复杂度下降
     */
    public static int fibonacciIterative(int n) {
        if (n < 0) {
            return 0;
        }

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int templast2 = 0;
        int templast = 1;
        int temp = 0;
        for (int i = 2; i <= n; i++) {
            temp = templast2 + templast;
            templast2 = templast;
            templast = temp;
        }
        return templast;
    }


    /**
     * 下面还有2总求解的方式
     */

    // 借助如下数学公式解决问题。矩阵乘法部分，可用递归解决，时间复杂度o(logn)
    // [ f(n)  f(n-1) ] = [ 1  1 ] ^ n-1   (当n>2)
    // [f(n-1) f(n-2) ]   [ 1  0 ]
    // 证明:
    // [ f(n)  f(n-1) ] = [ f(n-1)+f(n-2)  f(n-1)] = [ f(n-1)  f(n-2)] * [1 1]
    // [f(n-1) f(n-2) ]   [ f(n-2)+f(n-3)  f(n-2)]   [ f(n-2)  f(n-3)]   [1 0]
    // 得到如上递推式，所以
    // [ f(n)  f(n-1) ] = [ f(2)  f(1)] * [1 1]^n-2 = [1 1]^n-1
    // [f(n-1) f(n-2) ]   [ f(1)  f(0)]   [1 0]       [1 0]
    public static int fibonacci3(int n) {
        int[][] start = {{1, 1}, {1, 0}};
        return matrixPow(start, n - 1)[0][0];
    }

    public static int[][] matrixPow(int[][] start, int n) {
        if ((n & 1) == 0) {
            int[][] temp = matrixPow(start, n >> 1);
            return matrixMultiply(temp, temp);
        } else if (n == 1) {
            return start;
        } else {
            return matrixMultiply(start, matrixPow(start, n - 1));
        }
    }

    public static int[][] matrixMultiply(int[][] x, int[][] y) {
        int[][] result = new int[x.length][y[0].length];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < x[0].length; k++) {
                    sum += x[i][k] * y[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }

    // 使用通项公式完成，时间复杂度o(1)
    // f(n) = (1/√5)*{[(1+√5)/2]^n - [(1-√5)/2]^n}
    // 推导过程可参考https://wenku.baidu.com/view/57333fe36bd97f192379e936.html
    public static int fibonacci4(int n) {
        double gen5 = Math.sqrt(5);
        return (int) ((1 / gen5) * (Math.pow((1 + gen5) / 2, n) - Math.pow((1 - gen5) / 2, n)));
    }


}
