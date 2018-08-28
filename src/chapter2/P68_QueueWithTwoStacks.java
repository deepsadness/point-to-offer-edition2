package chapter2;

/**
 * 用两个栈实现队列
 * 题目要求：
 * 用两个栈，实现队列的从队尾插入元素offer()和从队头抛出元素poll()
 */
public class P68_QueueWithTwoStacks {

    public static class Queue<T> {
        private java.util.Stack<T> pushStack = new java.util.Stack<>();
        private java.util.Stack<T> popStack = new java.util.Stack<>();

        public void offer(T tail) {
            if (tail == null) {
                return;
            }
            pushStack.push(tail);
        }

        public T poll() {
            if (popStack.empty()) {
                //如果popStack没有东西，则进行迁移
                if (pushStack.empty()) {
                    return null;
                } else {
                    while (!pushStack.empty()) {
                        T pop = pushStack.pop();
                        popStack.push(pop);
                    }
                    return popStack.pop();
                }
            } else {
                return popStack.pop();
            }
        }

        public boolean isEmpty() {
            return pushStack.isEmpty() && popStack.isEmpty();
        }

        public int size() {
            return popStack.size() + pushStack.size();
        }
    }

    public static class Stack<T> {
        private Queue<T> queue1 = new Queue<>();
        private Queue<T> queue2 = new Queue<>();

        public void push(T t) {
            if (t == null) {
                return;
            }
            Queue<T> pushQ = null;
            if (queue1.isEmpty() && queue2.isEmpty()) {
                pushQ = queue1;
            } else {
                pushQ = queue1.isEmpty() ? queue2 : queue1;
            }
            pushQ.offer(t);

        }

        public T pop() {
            Queue<T> popQ = queue1.isEmpty() ? queue2 : queue1;
            Queue<T> pushQ = queue1.isEmpty() ? queue1 : queue2;
            if (popQ.isEmpty()) {
                return null;
            }
            while (popQ.size() != 1) {
                T poll = popQ.poll();
                pushQ.offer(poll);
            }
            return popQ.poll();
        }
    }
}
