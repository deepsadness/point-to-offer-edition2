package chapter3;

/**
 * 数值的整数次方
 * 实现函数double power（double base，int exponent），求base的exponent次方。不能
 * 使用库函数，不需要考虑大数问题。
 */
public class P110_Pow {

    /**
     * 这种方案，就没有兼顾效率的问题
     */
    public static double pow(double base, int exponent) {
        if (base == 0) return 0;
        if (exponent == 0) return 1;
        double result = 1;
        if (exponent > 0) {
            int curPonent = 0;
            while (curPonent < exponent) {
                result = result * base;
                curPonent++;
            }
        } else {
            int curPonent = 0;
            while (curPonent < -exponent) {
                result = result / base;
                curPonent++;
            }
        }

        return result;
    }

    /**
     * 兼顾效率的方案，就是利用之前求解的结果。
     * an= an/2*an/2 或者 an = a(n-1)/2* a(n-1)/2 *2
     * <p>
     * 这里的两种，都屏蔽了底数为0.除数为负数的情况
     */
    public static double powEffiective(double base, int exponent) {
        if (base == 0) return 0;
        if (exponent == 0) return 1;
        double result;
        if (exponent > 0) {
            result = base;
            for (int i = 0; i < exponent >> 1; i++) {
                result = result * result;
            }
            if ((exponent & 1) != 0) {
                result = result * base;
            }
        } else {
            result = 1 / base;
            for (int i = 0; i < (-exponent) >> 1; i++) {
                result = result * result;
            }
            if ((-exponent & 1) != 0) {
                result = result / base;
            }
        }

        return result;
    }
}
