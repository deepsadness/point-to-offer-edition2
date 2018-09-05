package chapter6;

import org.junit.Test;

public class P266_GetMissingNumberTest {

    @Test
    public void getMissingNumber() {
        for (int i = 0; i < 1000000000; i++) {
            int[] arr1 = new int[]{0, 1, 2, 3, 4, 5}; //6
            int[] arr2 = new int[]{0, 1, 3, 4, 5}; //2
            int[] arr3 = new int[]{1, 2}; //0
            P266_GetMissingNumber.getMissingNumber(arr1);
            P266_GetMissingNumber.getMissingNumber(arr2);
            P266_GetMissingNumber.getMissingNumber(arr3);
        }
    }

    @Test
    public void getMissingNumber2() {
        for (int i = 0; i < 1000000000; i++) {
            int[] arr1 = new int[]{0, 1, 2, 3, 4, 5}; //6
            int[] arr2 = new int[]{0, 1, 3, 4, 5}; //2
            int[] arr3 = new int[]{1, 2}; //0
            P266_GetMissingNumber.getMissingNumber2(arr1);
            P266_GetMissingNumber.getMissingNumber2(arr2);
            P266_GetMissingNumber.getMissingNumber2(arr3);
        }
    }
}