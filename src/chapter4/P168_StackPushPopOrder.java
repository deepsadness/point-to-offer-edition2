package chapter4;

import java.util.Stack;

/**
 * 栈的压入弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 判断第二个序列是否为该栈的弹出序序列。
 * 假设压入栈的所有数字均不相等。
 * <p>
 * 例如，压入序列为(1,2,3,4,5)，序列(4,5,3,2,1)是它的弹出序列，而(4,3,5,1,2)不是。
 */
public class P168_StackPushPopOrder {
    /**
     * 通过遍历的方式。
     * 主要还是一步一步往下走
     * <p>
     * 自己通过数组来判断。
     */
    public static boolean isPopOrder(int[] pushOrder, int[] popOrder) {
        if (pushOrder == null || popOrder == null || pushOrder.length == 0 || popOrder.length == 0 || popOrder.length != pushOrder.length) {
            return false;
        }
        int popIndex = 0;
        int pushIndex = 0;
        int pushStackTopIndex = -1;
        int length = popOrder.length;
        while (popIndex < length) {
            int curPopValue = popOrder[popIndex];
            if (pushStackTopIndex == -1) { //如果没有栈顶元素，都需要遍历找一次
                int findIndex = -1;
                for (int i = pushIndex; i < pushOrder.length; i++) {
                    if (pushOrder[i] == curPopValue) {
                        findIndex = i;
                        break;
                    }
                }

                if (findIndex == -1) {  //如果没有找到
                    break;
                }

                if (findIndex != 0 && (pushIndex == 0 || pushIndex != findIndex)) {
                    pushIndex = findIndex + 1;
                    pushStackTopIndex = findIndex - 1;
                } else {
                    pushIndex++;
                }
            } else {    //第一次，先去找栈顶
                //判断栈顶是否相等
                int stackTopValue = pushOrder[pushStackTopIndex];
                if (stackTopValue == curPopValue) {
                    pushStackTopIndex--;
                } else {
                    if (pushIndex < length && pushOrder[pushIndex] == curPopValue) {
                        pushIndex++;
                    } else {
                        break;
                    }

                }
            }
            popIndex++;
        }
        return pushIndex == length && popIndex == length;
    }

    /**
     * 迭代的方式
     * <p>
     * 1. 设定好终止条件
     * 2. 开始循环每一步
     * <p>
     * 自己通过数组来判断。
     */
    public static boolean isPopOrderRecursive(int[] pushOrder, int[] popOrder) {
        if (pushOrder == null || popOrder == null || pushOrder.length == 0 || popOrder.length == 0 || popOrder.length != pushOrder.length) {
            return false;
        }
        int popIndex = 0;
        int pushIndex = 0;
        int pushStackTopIndex = -1;


        //接着往下找。
        return findNext(popIndex, pushIndex, pushStackTopIndex, popOrder, pushOrder);

    }

    private static boolean findNext(int curPopIndex, int curPushIndex, int pushStackTopIndex, int[] popOrder, int[] pushOrder) {
        //定义终止条件。 如果是空栈(??)，同时两个都遍历完结了(curPopIndex==curPushIndex==length)。就是匹配
        int length = popOrder.length;
        if (curPopIndex == curPushIndex && curPushIndex == length) {
            return true;
        } else if (curPopIndex == length) {
            return false;
        } else {
            int popValue = popOrder[curPopIndex];
            if (pushStackTopIndex == -1) {    //没有栈顶。
                //先找栈顶
                int findIndex = -1;
                for (int i = curPushIndex; i < length; i++) {
                    if (pushOrder[i] == popValue) {
                        findIndex = i;
                        break;
                    }
                }

                //找不到的话，这里快速失败
                if (findIndex == -1) {
                    return false;
                }
                //如果找到的元素不是第一个。同时 是第一次找，或在 不是下一个的情况。就说明存在栈顶元素
                if (findIndex != 0 && (curPushIndex == 0 || curPushIndex != findIndex)) {
                    curPushIndex = findIndex + 1;
                    pushStackTopIndex = findIndex - 1;
                    return findNext(curPopIndex + 1, curPushIndex, pushStackTopIndex, popOrder, pushOrder);
                } else {
                    //没有栈顶元素，继续往后一位找
                    return findNext(curPopIndex + 1, curPushIndex + 1, pushStackTopIndex, popOrder, pushOrder);
                }
            } else { //有栈顶。
                int pushStackTopValue = pushOrder[pushStackTopIndex];
                //栈顶相等的话，就移动栈顶，继续找
                if (pushStackTopValue == popValue) {
                    pushStackTopIndex--;
                    return findNext(curPopIndex + 1, curPushIndex, pushStackTopIndex, popOrder, pushOrder);
                } else if (curPushIndex < length && pushOrder[curPushIndex] == popValue) {
                    return findNext(curPopIndex + 1, curPushIndex + 1, pushStackTopIndex, popOrder, pushOrder);
                } else {
                    return false;
                }
            }
        }
    }

    //直接使用Stack来辅助.直接将数据往栈里压
    public static boolean isPopOrderWithStack(int[] pushOrder, int[] popOrder) {
        if (pushOrder == null || popOrder == null || pushOrder.length == 0 || popOrder.length == 0 || popOrder.length != pushOrder.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        int pushIndex = 0;
        int length = popOrder.length;
        while (popIndex < length) {
            int curPopValue = popOrder[popIndex];
            if (!stack.isEmpty() && stack.peek() == curPopValue) {    //第一次，先去找栈顶
                stack.pop();
                popIndex++;
            } else { //如果没有栈顶元素，都需要遍历找一次
                //则将下一个压入
                if (pushIndex < length) {
                    stack.push(pushOrder[pushIndex]);
                    pushIndex++;
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    //直接使用Stack来辅助.直接将数据往栈里压
    public static boolean isPopOrderWithStackRecursive(int[] pushOrder, int[] popOrder) {
        if (pushOrder == null || popOrder == null || pushOrder.length == 0 || popOrder.length == 0 || popOrder.length != pushOrder.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        int pushIndex = 0;
        return oderSame(popIndex, pushIndex, stack, pushOrder, popOrder);

    }

    private static boolean oderSame(int popIndex, int pushIndex, Stack<Integer> stack, int[] pushOrder, int[] popOrder) {
        int length = popOrder.length;
        if (popIndex == length) {
            return stack.isEmpty();
        } else {
            int curPopValue = popOrder[popIndex];
            if (stack.isEmpty() || stack.peek() != curPopValue) {
                if (pushIndex<length){
                    stack.push(pushOrder[pushIndex]);
                    return oderSame(popIndex, pushIndex + 1, stack, pushOrder, popOrder);
                }else {
                    return false;
                }
            } else {
                stack.pop();
                return oderSame(popIndex + 1, pushIndex, stack, pushOrder, popOrder);
            }
        }
    }

}
