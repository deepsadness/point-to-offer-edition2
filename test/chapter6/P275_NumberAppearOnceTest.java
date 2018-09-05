package chapter6;

import org.junit.Test;

import java.util.Arrays;

public class P275_NumberAppearOnceTest {

    @Test
    public void findFirst1Bit() {
        System.out.println(P275_NumberAppearOnce.findFirst1Bit(0));
        System.out.println(P275_NumberAppearOnce.findFirst1Bit(1));
        System.out.println(P275_NumberAppearOnce.findFirst1Bit(2));
        System.out.println(P275_NumberAppearOnce.findFirst1Bit(4));
        System.out.println(P275_NumberAppearOnce.findFirst1Bit(6));
    }

    @Test
    public void onceNumber() {
        int[] arr = {2, 4, 3, 6, 3, 2, 5, 5};
        System.out.println(Arrays.toString(P275_NumberAppearOnce.onceNumber(arr)));
    }
}