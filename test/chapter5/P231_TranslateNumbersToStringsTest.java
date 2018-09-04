package chapter5;

import org.junit.Assert;
import org.junit.Test;

public class P231_TranslateNumbersToStringsTest {

    @Test
    public void translate() {
        int target = 12258;
        Assert.assertEquals(5, P231_TranslateNumbersToStrings.translate(target));
    }

    @Test
    public void translate2() {
        int target = 12258;
        Assert.assertEquals(5, P231_TranslateNumbersToStrings.translate2(target));

    }
}