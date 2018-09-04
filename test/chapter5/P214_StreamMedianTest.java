package chapter5;

import org.junit.Test;

public class P214_StreamMedianTest {

    @Test
    public void test1() {
        P214_StreamMedian.HeapStream heapStream = new P214_StreamMedian.HeapStream();
        heapStream.addNum(2);
        heapStream.addNum(1);
        System.out.println(heapStream.findMedian());


        heapStream.addNum(4);
        heapStream.addNum(5);
        heapStream.addNum(6);
        System.out.println(heapStream.findMedian());
    }


}