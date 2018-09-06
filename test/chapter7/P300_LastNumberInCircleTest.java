package chapter7;

import org.junit.Test;

public class P300_LastNumberInCircleTest {

    @Test
    public void getLastNumber() {
        int lastNumber = P300_LastNumberInCircle.getLastNumber(5, 3);
        System.out.println(lastNumber);
    }
    @Test
    public void getLastNumber2() {
        int lastNumber = P300_LastNumberInCircle.getLastNumber2(5, 3);
        System.out.println(lastNumber);
    }

    @Test
    public void getLastNumber3() {
        int lastNumber = P300_LastNumberInCircle.getLastNumber3(5, 3);
        System.out.println(lastNumber);
    }
}