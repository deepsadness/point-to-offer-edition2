package chapter7;

/**
 * 写一个函数，求两个正数之和，要求在函数体内不能使用四则运算符号。
 * <p>
 * 1. ^
 * 2. & 然后再往左移动
 * 3. == 0 时结束
 */
public class P310_AddTwoNumbers {
    public static int add(int a, int b) {
        int sum = a ^ b;
        int caryy = (a & b) << 1;
        int temp;
        while (caryy != 0) {
            temp = sum;
            sum = sum ^ caryy;
            caryy = (caryy & temp) << 1;
        }
        return sum;
    }

}
