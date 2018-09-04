package chapter5;

import org.junit.Assert;
import org.junit.Test;

public class P227_SortArrayForMinNumberTest {

    @Test
    public void sortForMinNumber() {
        int arr[] = {3, 32, 321};
        String s = P227_SortArrayForMinNumber.sortForMinNumber(arr);
        Assert.assertEquals("321323", s);
    }
}