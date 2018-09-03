package chapter5;

import org.junit.Test;

public class P205_MoreThanHalfNumberTest {

    @Test
    public void findMoreThanHalfNumber() {
        int[] arr
                = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        P205_MoreThanHalfNumber.findMoreThanHalfNumber(arr);
    }
}