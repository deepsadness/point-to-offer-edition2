package chapter6;

import org.junit.Test;

public class P292_QueueWithMaxTest {
    @Test
    public void test(){
        P292_QueueWithMax.QueueMax queueMax = new P292_QueueWithMax.QueueMax();
        queueMax.pushBack(3);
        System.out.println(queueMax.max());
        queueMax.pushBack(5);
        System.out.println(queueMax.max());
        queueMax.pushBack(1);
        System.out.println(queueMax.max());
        System.out.println("开始出队后，调用max");
        System.out.println(queueMax.max());
        queueMax.popFront();
        System.out.println(queueMax.max());
        queueMax.popFront();
        System.out.println(queueMax.max());
        queueMax.popFront();
        System.out.println(queueMax.max());
    }
}