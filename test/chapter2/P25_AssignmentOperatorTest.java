package chapter2;

import org.junit.Assert;

public class P25_AssignmentOperatorTest {

    @org.junit.Test
    public void testAssignNull() {
        P25_AssignmentOperator.AOClass aoClass = new P25_AssignmentOperator.AOClass(1);
        P25_AssignmentOperator.AOClass assign = aoClass.assign(null);
        Assert.assertEquals(aoClass, assign);
    }

    @org.junit.Test
    public void testAssignNormal() {
        P25_AssignmentOperator.AOClass aoClass = new P25_AssignmentOperator.AOClass(1);
        P25_AssignmentOperator.AOClass aoClass2 = new P25_AssignmentOperator.AOClass(2);
        P25_AssignmentOperator.AOClass assignNewOne = aoClass.assign(aoClass2);
        Assert.assertTrue(assignNewOne == aoClass);
        Assert.assertEquals(2,assignNewOne.key);
    }

    @org.junit.Test
    public void testAssignEqual() {
        P25_AssignmentOperator.AOClass aoClass = new P25_AssignmentOperator.AOClass(1);
        P25_AssignmentOperator.AOClass assign = aoClass.assign(aoClass);
        Assert.assertEquals(aoClass, assign);
    }
}