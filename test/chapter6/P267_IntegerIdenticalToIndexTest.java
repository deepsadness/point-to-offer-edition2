package chapter6;

import org.junit.Test;

public class P267_IntegerIdenticalToIndexTest {

    @Test
    public void findIndexEqualInteger() {
        System.out.println(P267_IntegerIdenticalToIndex.findIndexEqualInteger(new int[]{-3,-1,1,3,5})); //3
        System.out.println(P267_IntegerIdenticalToIndex.findIndexEqualInteger(new int[]{0,1,2,3,4}));   //0~4
        System.out.println(P267_IntegerIdenticalToIndex.findIndexEqualInteger(new int[]{4,5,6,7,8}));   //-1
    }
}