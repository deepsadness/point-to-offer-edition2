package chapter2;

import org.junit.Assert;
import org.junit.Test;

/**
 * 因为覆盖的用例：
 * 1. 功能测试（3，5，10）
 * 2. 边界测试 (0,1,2)
 * 3. 性能测试 (输入较大的数组。40.50，100)
 */
public class P74_FibonacciTest {

    @Test
    public void testRecursive() {
        //这个时候，就会发生堆栈溢出
        int actual = P74_Fibonacci.fibonacciRecursive(2000);
        Assert.assertEquals(1392522469, actual);
    }

    @Test
    public void testIterative() {
        Assert.assertEquals(1392522469,P74_Fibonacci.fibonacciIterative(2000));
    }


}