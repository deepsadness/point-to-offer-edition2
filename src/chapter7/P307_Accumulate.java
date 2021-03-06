package chapter7;

/**
 * 求1+2+...+n
 * <p>
 * 求1+2+...+n，要求不能使用乘除法，for，while，if，else，switch，case等关键词及条件判断语句？：。
 * <p>
 * 不能用循环，那么可以使用递归调用求和。但又不能使用if，结束条件如何生效？可以使用如下形式替代if语句
 */
public class P307_Accumulate {
    public static int accumulate(int n) {
        int t = 0;
        boolean b = (n > 0) && ((t = n + accumulate(n - 1)) > 0);
        return t;
    }
}
