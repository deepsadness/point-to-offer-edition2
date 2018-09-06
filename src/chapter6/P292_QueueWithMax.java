package chapter6;

import java.util.ArrayDeque;

/**
 * 队列的最大值
 * <p>
 * 定义一个队列并实现函数max得到队列里的最大值。
 * 要求max，pushBack，popFront的时间复杂度都是o(1)。
 */
public class P292_QueueWithMax {
    public static class QueueMax {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayDeque<Integer> maxQueue = new ArrayDeque<>();

        public int max() {
            if (maxQueue.isEmpty()){
                return -1;
            }else {
                return maxQueue.peek();
            }
        }

        public void pushBack(int number) {
            int size = queue.size();
            if (size == 0) {
                maxQueue.add(number);
            } else {
                Integer max = maxQueue.peek();
                if (max >= number) {
                    maxQueue.offer(number);
                } else {
                    maxQueue.clear();
                    maxQueue.offer(number);
                }
            }
            queue.offer(number);
        }

        public int popFront() {
            Integer maxPeek = maxQueue.peek();
            if (maxPeek == queue.peek()) {
                maxQueue.poll();
            }
            return queue.poll();
        }
    }
}
