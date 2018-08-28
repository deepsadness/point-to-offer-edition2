package chapter2;

import org.junit.Assert;
import org.junit.Test;

public class P89_StringPathInMatrixTest {

    @Test
    public void hasPath() {
        char[][] data = {
                {'a', 'b', 't', 'g'},
                {'c', 'f', 'c', 's'},
                {'j', 'd', 'e', 'h'}};
        Assert.assertTrue(P89_StringPathInMatrix.hasPath(data, "bfce")); //true
        Assert.assertFalse(P89_StringPathInMatrix.hasPath(data, "abfb")); //false,访问过的位置不能再访问
    }
}