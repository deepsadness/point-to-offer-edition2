package chapter4;

import java.util.Stack;

/**
 * 包含min函数的栈
 * <p>
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。
 * 要求在该栈中，调用min，push及pop的时间复杂度都是o(1)。
 */
public class P165_StackWithMin {
    public static class StackMin<T> {
        private Stack<T> stack = new Stack<>();
        private Stack<T> min = new Stack<>();

        public T pop() {
            if (!min.isEmpty()) {
                min.pop();
            }
            if (!stack.isEmpty()) {
                return stack.pop();
            } else {
                return null;
            }
        }

        public void push(T value) {
            stack.push(value);
            if (min.isEmpty()) {
                min.push(value);
            } else {
                T peek = min.peek();

                if (peek instanceof Comparable) {
                    if (((Comparable) peek).compareTo(value) > 0) {
                        min.push(value);
                    } else {
                        min.push(peek);
                    }
                }
            }
        }

        public T min() {
            if (min.isEmpty()) {
                return null;
            }
            return min.peek();
        }
    }
}
