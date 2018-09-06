package chapter7;

import org.junit.Test;

public class P298_ContinousCardsTest {

    @Test
    public void isSunzi0() {
        int[] sunzi = {3, 5, 4, 7, 6};
        System.out.println( P298_ContinousCards.isSunzi(sunzi));
        System.out.println( P298_ContinousCards.isSunzi2(sunzi));
    }

    @Test
    public void isSunzi1() {
        int[] sunzi = {2, 3, 4, 7, 8};
        System.out.println( P298_ContinousCards.isSunzi(sunzi));
        System.out.println( P298_ContinousCards.isSunzi2(sunzi));
    }

    @Test
    public void isSunzi2() {
        int[] sunzi = {0, 3, 4, 0, 7};
        System.out.println( P298_ContinousCards.isSunzi(sunzi));
        System.out.println( P298_ContinousCards.isSunzi2(sunzi));
    }

    @Test
    public void isSunzi3() {
        int[] sunzi = {1, 3, 10, 11, 0};
        System.out.println( P298_ContinousCards.isSunzi(sunzi));
        System.out.println( P298_ContinousCards.isSunzi2(sunzi));
    }

    @Test
    public void isSunzi4() {
        int[] sunzi = {1, 0, 10, 11, 12};
        System.out.println( P298_ContinousCards.isSunzi(sunzi));
        System.out.println( P298_ContinousCards.isSunzi2(sunzi));
    }

    @Test
    public void isSunzi5() {
        int[] sunzi = {1, 13, 10, 11, 12};
        System.out.println( P298_ContinousCards.isSunzi(sunzi));
        System.out.println( P298_ContinousCards.isSunzi2(sunzi));
    }

    @Test
    public void isSunzi6() {
        int[] sunzi = {1, 13, 10, 10, 12};
        System.out.println(P298_ContinousCards.isSunzi(sunzi));
        System.out.println(P298_ContinousCards.isSunzi2(sunzi));
    }

    @Test
    public void isSunzi7() {
        int[] data1 = new int[]{4, 2, 7, 12, 1}; //false
        int[] data2 = new int[]{0, 5, 6, 12, 0}; //false
        int[] data3 = new int[]{6, 5, 8, 7, 4};  //true
        int[] data4 = new int[]{0, 5, 6, 9, 8};  //true
        int[] data5 = new int[]{0, 13, 0, 12, 0}; //true

        System.out.println(P298_ContinousCards.isSunzi(data1));
        System.out.println(P298_ContinousCards.isSunzi(data2));
        System.out.println(P298_ContinousCards.isSunzi(data3));
        System.out.println(P298_ContinousCards.isSunzi(data4));
        System.out.println(P298_ContinousCards.isSunzi(data5));

        System.out.println(P298_ContinousCards.isSunzi2(data1));
        System.out.println(P298_ContinousCards.isSunzi2(data2));
        System.out.println(P298_ContinousCards.isSunzi2(data3));
        System.out.println(P298_ContinousCards.isSunzi2(data4));
        System.out.println(P298_ContinousCards.isSunzi2(data5));
    }
}