package chapter7;

import org.junit.Assert;
import org.junit.Test;

public class P310_AddTwoNumbersTest {

    @Test
    public void add() {
        Assert.assertEquals(11, P310_AddTwoNumbers.add(5, 6));

    }
}