package chapter3;

import org.junit.Assert;
import org.junit.Test;

public class P114_Print1ToMaxOfNDigitsTest {
    @Test
    public void justTest() {
        Assert.assertEquals("123", P114_Print1ToMaxOfNDigits.DigitNumber.just("123").toString());
        Assert.assertEquals("1", P114_Print1ToMaxOfNDigits.DigitNumber.just("1").toString());
        Assert.assertEquals(null, P114_Print1ToMaxOfNDigits.DigitNumber.just(""));
        Assert.assertEquals(null, P114_Print1ToMaxOfNDigits.DigitNumber.just(null));
        Assert.assertEquals(null, P114_Print1ToMaxOfNDigits.DigitNumber.just("1 A3"));
    }

    @Test
    public void minTest() {
        Assert.assertEquals("1", P114_Print1ToMaxOfNDigits.DigitNumber.min().toString());
    }

    @Test
    public void maxTest() {
        Assert.assertEquals("9", P114_Print1ToMaxOfNDigits.DigitNumber.max(1).toString());
        Assert.assertEquals("99", P114_Print1ToMaxOfNDigits.DigitNumber.max(2).toString());
        Assert.assertEquals("999", P114_Print1ToMaxOfNDigits.DigitNumber.max(3).toString());
        Assert.assertEquals(null, P114_Print1ToMaxOfNDigits.DigitNumber.max(0));
    }

    @Test
    public void increment() {
        Assert.assertEquals("9", P114_Print1ToMaxOfNDigits.DigitNumber.just("8").increase().toString());
        Assert.assertEquals("10", P114_Print1ToMaxOfNDigits.DigitNumber.just("9").increase().toString());
        Assert.assertEquals("100", P114_Print1ToMaxOfNDigits.DigitNumber.just("99").increase().toString());
        Assert.assertEquals("20", P114_Print1ToMaxOfNDigits.DigitNumber.just("19").increase().toString());
        Assert.assertEquals("26", P114_Print1ToMaxOfNDigits.DigitNumber.just("25").increase().toString());
    }

    @Test
    public void printMaxOfNDigitsIllegal() {
        Assert.assertEquals("", P114_Print1ToMaxOfNDigits.printMaxOfNDigits(0));
        Assert.assertEquals("", P114_Print1ToMaxOfNDigits.printMaxOfNDigits(-1));
    }

    @Test
    public void printMaxOfNDigits() {
        Assert.assertEquals(buildMaxString(9), P114_Print1ToMaxOfNDigits.printMaxOfNDigits(1));
        Assert.assertEquals(buildMaxString(99), P114_Print1ToMaxOfNDigits.printMaxOfNDigits(2));

    }

    private String buildMaxString(int max) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= max; i++) {
            stringBuilder.append(i + "").append(",");
        }
        return stringBuilder.toString();
    }

    @Test
    public void printMaxOfNDigits2() {
//        P114_Print1ToMaxOfNDigits.printMaxOfNDigits2(1);
        String s = P114_Print1ToMaxOfNDigits.printMaxOfNDigits2(3);
        System.out.println(s);
    }

}