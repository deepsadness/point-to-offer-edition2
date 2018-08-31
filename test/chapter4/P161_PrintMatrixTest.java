package chapter4;

import org.junit.Assert;
import org.junit.Test;

public class P161_PrintMatrixTest {

    @Test
    public void println0() {
        int[][] data = {
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7},
        };

        String result = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,";
        String println = P161_PrintMatrix.println(data);
        Assert.assertEquals(result, println);
    }

    @Test
    public void println1() {
        int[][] data = {
                {1, 2, 3, 4},
                {10, 11, 12, 5},
                {9, 8, 7, 6},
        };
        String result = "1,2,3,4,5,6,7,8,9,10,11,12,";
        String println = P161_PrintMatrix.println(data);
        Assert.assertEquals(result, println);
    }

    @Test
    public void println2() {
        int[][] data = {
                {1, 2, 3},
                {10, 11, 4},
                {9, 12, 5},
                {8, 7, 6},
        };
        String result = "1,2,3,4,5,6,7,8,9,10,11,12,";
        String println = P161_PrintMatrix.println(data);
        Assert.assertEquals(result, println);
    }

    @Test
    public void println3() {
        int[][] data = {
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5},
        };
        String result = "1,2,3,4,5,6,7,8,9,";
        String println = P161_PrintMatrix.println(data);
        Assert.assertEquals(result, println);
    }

    @Test(expected = RuntimeException.class)
    public void printlnFail() {
        int[][] data = {
                {1, 2, 3},
                {8, 9, 4, 5},
                {7, 6, 5},
        };
        String result = "1,2,3,5,6,7,8,9,4";
        String println = P161_PrintMatrix.println(data);
        Assert.assertEquals(result, println);
    }
}