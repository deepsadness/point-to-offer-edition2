package chapter2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class P44_FindInPartiallySortedMatrixTest {
    @Test
    public void testNormal() {
        int[][] testnormal = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int target = 8;
        int target2 = 17;
        int target3 = 0;

        Assert.assertTrue(P44_FindInPartiallySortedMatrix.findInPartiallySortedMatrixBy(testnormal, target));
        Assert.assertFalse(P44_FindInPartiallySortedMatrix.findInPartiallySortedMatrixBy(testnormal, target2));
        Assert.assertFalse(P44_FindInPartiallySortedMatrix.findInPartiallySortedMatrixBy(testnormal, target3));
    }

    @Test
    public void testNull() {
        int[][] testLess = {
                {1, 2, 3, 4},
                {5, 6, 7},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };


        int[][] testNotIncrement = {
                {1, 2, 3, 4},
                {5, 6, 7, 13},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int[][] testLength0 = {
        };

        int[][] testNull = null;

        int target = 6;

        Assert.assertFalse(P44_FindInPartiallySortedMatrix.findInPartiallySortedMatrixBy(testLess, target));
        Assert.assertFalse(P44_FindInPartiallySortedMatrix.findInPartiallySortedMatrixBy(testNotIncrement, target));
        Assert.assertFalse(P44_FindInPartiallySortedMatrix.findInPartiallySortedMatrixBy(testLength0, target));
        Assert.assertFalse(P44_FindInPartiallySortedMatrix.findInPartiallySortedMatrixBy(testNull, target));

    }
}