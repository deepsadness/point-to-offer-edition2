package chapter2;

import org.junit.Assert;
import org.junit.Test;

public class P51_ReplaceSpaceTest {
    @Test
    public void testNormal() {
        String test0 = "Hello World! haha";
        String test4 = "   ";

        String replace = P51_ReplaceSpace.replace(test0);
        String replace4 = P51_ReplaceSpace.replace(test4);
        Assert.assertEquals("Hello%20World!%20haha", replace);
        Assert.assertEquals("%20%20%20", replace4);
    }


    @Test
    public void testNull() {
        String test1 = "";
        String test2 = null;

        String replace1 = P51_ReplaceSpace.replace(test1);
        String replace2 = P51_ReplaceSpace.replace(test2);
        Assert.assertEquals(test1, replace1);
        Assert.assertEquals(test2, replace2);
    }
}