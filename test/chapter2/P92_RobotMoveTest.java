package chapter2;

import org.junit.Assert;
import org.junit.Test;

public class P92_RobotMoveTest {

    @Test
    public void moveCount() {
        Assert.assertEquals(36, P92_RobotMove.moveCount(9, 2, 20));
    }
}