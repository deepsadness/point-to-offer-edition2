package chapter4;

import org.junit.Assert;
import org.junit.Test;

public class P179_SequenceOfBSTTest {

    @Test
    public void verifySquenceOfBST() {
        int[] test1 = {5, 7, 6, 9, 11, 10, 8};
//        Assert.assertTrue(P179_SequenceOfBST.verifySquenceOfBST(test1));
        Assert.assertTrue(P179_SequenceOfBST.verifySquenceOfBST2(test1));
    }

    @Test
    public void verifySquenceOfBST2() {
        int[] test1 = {5, 7, 6, 8};
//        Assert.assertTrue(P179_SequenceOfBST.verifySquenceOfBST(test1));
        Assert.assertTrue(P179_SequenceOfBST.verifySquenceOfBST2(test1));
    }

    @Test
    public void verifySquenceOfBSTWrong() {
        int[] test1 = {7, 4, 6, 5};
//        Assert.assertFalse(P179_SequenceOfBST.verifySquenceOfBST(test1));
        Assert.assertFalse(P179_SequenceOfBST.verifySquenceOfBST2(test1));
    }
}