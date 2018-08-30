package chapter3;

import org.junit.Assert;
import org.junit.Test;

public class P127_NumberStringsTest {
    @Test
    public void test0() {
        Assert.assertTrue(P127_NumberStrings.isNumeric("+100"));
        Assert.assertTrue(P127_NumberStrings.isNumeric("-123"));
    }

    @Test
    public void test1() {
        Assert.assertTrue(P127_NumberStrings.isNumeric("+.6"));
    }

    @Test
    public void test11() {
        Assert.assertTrue(P127_NumberStrings.isNumeric(".6"));
        Assert.assertTrue(P127_NumberStrings.isNumeric("6."));
    }

    @Test
    public void test12() {

        Assert.assertTrue(P127_NumberStrings.isNumeric("6.5"));
        Assert.assertTrue(P127_NumberStrings.isNumeric("3.1416"));
    }

    @Test
    public void test21() {
        Assert.assertTrue(P127_NumberStrings.isNumeric("5e2"));
    }

    @Test
    public void test22() {
        Assert.assertTrue(P127_NumberStrings.isNumeric("5e+2"));
    }

    @Test
    public void test23() {
        Assert.assertTrue(P127_NumberStrings.isNumeric("-5e-2"));
    }

    @Test
    public void test24() {
        Assert.assertTrue(P127_NumberStrings.isNumeric("+5e-2"));
    }

    @Test
    public void test31() {
        Assert.assertTrue(P127_NumberStrings.isNumeric("+1.2e-2"));
    }

    @Test
    public void test32() {
        Assert.assertTrue(P127_NumberStrings.isNumeric("1.2e2"));
    }

    @Test
    public void test33() {
        Assert.assertTrue(P127_NumberStrings.isNumeric("1.2e+2"));
    }

    @Test
    public void test4() {
        Assert.assertFalse(P127_NumberStrings.isNumeric("12e"));//false
    }

    @Test
    public void test5() {
        Assert.assertFalse(P127_NumberStrings.isNumeric("1a3.14"));//false
    }

    @Test
    public void test6() {
        Assert.assertFalse(P127_NumberStrings.isNumeric("1.2.3"));//false
    }

    @Test
    public void test7() {
        Assert.assertFalse(P127_NumberStrings.isNumeric("+-5"));//false
    }

    @Test
    public void test8() {
        Assert.assertFalse(P127_NumberStrings.isNumeric("12e+5.4"));//false
    }
}