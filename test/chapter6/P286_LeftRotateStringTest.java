package chapter6;

import org.junit.Assert;
import org.junit.Test;

public class P286_LeftRotateStringTest {

    @Test
    public void leftRotate() {
        String str = "abcdefg";
        String s = P286_LeftRotateString.leftRotate(str, 2);
        Assert.assertEquals("cdefgab",s);
    }
}