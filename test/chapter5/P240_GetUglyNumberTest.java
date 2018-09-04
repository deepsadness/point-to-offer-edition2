package chapter5;

import org.junit.Test;

/**
 * Created by Cry on 2018/9/4.
 */
public class P240_GetUglyNumberTest {
    @Test
    public void getUglyNumber() throws Exception {
//        for (int i = 1; i < 20; i++) {
//            int uglyNumber = P240_GetUglyNumber.getUglyNumber(i);
//            System.out.println(uglyNumber);
//        }
        int uglyNumber = P240_GetUglyNumber.getUglyNumber(1500);
        System.out.println(uglyNumber);
    }


    @Test
    public void getUglyNumber2() throws Exception {
        int uglyNumber = P240_GetUglyNumber.getUglyNumber2(1500);
        System.out.println(uglyNumber);
    }
}

