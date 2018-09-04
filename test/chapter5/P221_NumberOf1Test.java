package chapter5;

import org.junit.Assert;
import org.junit.Test;

public class P221_NumberOf1Test {

    @Test
    public void getNumber1Times() {
        Assert.assertEquals(5, P221_NumberOf1.getNumber1Times(12));
        Assert.assertEquals(55, P221_NumberOf1.getNumber1Times(121));
        Assert.assertEquals(259, P221_NumberOf1.getNumber1Times(789));

    }

    @Test
    public void isContainsNumber1Times() {
        int a1 = 1;
        int a2 = 10;
        int a3 = 11;
        int a4 = 221;
        int a5 = 313;
        Assert.assertEquals(1, P221_NumberOf1.isContainsNumber1Times(a1));
        Assert.assertEquals(1, P221_NumberOf1.isContainsNumber1Times(a2));
        Assert.assertEquals(2, P221_NumberOf1.isContainsNumber1Times(a3));
        Assert.assertEquals(1, P221_NumberOf1.isContainsNumber1Times(a4));
        Assert.assertEquals(1, P221_NumberOf1.isContainsNumber1Times(a5));
    }

    @Test
    public void numberOf1Between1AndN() {
        Assert.assertEquals(5, P221_NumberOf1.numberOf1Between1AndN(12));
        Assert.assertEquals(55, P221_NumberOf1.numberOf1Between1AndN(121));
        Assert.assertEquals(259, P221_NumberOf1.numberOf1Between1AndN(789));

    }
}