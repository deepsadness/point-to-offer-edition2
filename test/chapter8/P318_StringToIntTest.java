package chapter8;

import org.junit.Assert;
import org.junit.Test;

public class P318_StringToIntTest {

    @Test
    public void strToInt1() {
        try {
            Assert.assertEquals(100, P318_StringToInt.strToInt(" 100"));
            Assert.assertEquals(-100, P318_StringToInt.strToInt("-100"));
            Assert.assertEquals(0, P318_StringToInt.strToInt(" 0 "));
            Assert.assertEquals(0, P318_StringToInt.strToInt("-0"));
            Assert.assertEquals(-50, P318_StringToInt.strToInt("-050"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void strToInt2() {
        try {
            Assert.assertEquals(2147483647, P318_StringToInt.strToInt("2147483647"));
            Assert.assertEquals(-2147483647, P318_StringToInt.strToInt("-2147483647"));
            Assert.assertEquals(2147483647, P318_StringToInt.strToInt("2147483647"));
            Assert.assertEquals(-2147483648, P318_StringToInt.strToInt("-2147483648"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void strToInt3() {
        try {
             P318_StringToInt.strToInt("2147483648");
        } catch (Exception e) {
            Assert.assertEquals("数值溢出,待转换字符串为2147483648",e.getMessage());
        }
    }

    @Test
    public void strToInt4() {
        try {
            P318_StringToInt.strToInt("-2147483649");
        } catch (Exception e) {
            Assert.assertEquals("数值溢出,待转换字符串为-2147483649",e.getMessage());
        }

    }

    @Test
    public void strToInt5() {
        try {
            P318_StringToInt.strToInt(null);
        } catch (Exception e) {
            Assert.assertEquals("待转换字符串为null或空串",e.getMessage());
        }

    }

    @Test
    public void strToInt6() {
        try {
            P318_StringToInt.strToInt("   ");   //待转换字符串为null或空串
        } catch (Exception e) {
            Assert.assertEquals("待转换字符串为null或空串",e.getMessage());
        }
    }

}