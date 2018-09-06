package chapter7;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 圆圈中最后剩下的数字
 * <p>
 * 0，1，2...n-1这n个数字拍成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字，求剩下的最后一个数字。
 * 例如0，1，2，3，4这5个数字组成的圈，每次删除第3个数字，一次删除2，0，4，1，因此最后剩下的是3。
 */
public class P300_LastNumberInCircle {
    //那么这种思路的时间复杂度为o(mn)，空间复杂度o(n)。
    public static int getLastNumber(int n, int deleteIndex) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        int[] tempCount = new int[n];

        int targetIndex = -1;
        int result = 0;
        int tempLength = n;
        while (tempLength > 1) {
            int deleteCount = deleteIndex;
            while (deleteCount > 0) {
                targetIndex++;
                if (targetIndex == n) targetIndex = 0;
                while (tempCount[targetIndex] == -1) {
                    targetIndex++;
                    if (targetIndex == n) targetIndex = 0;
                }
                deleteCount--;
            }
            tempCount[targetIndex] = -1;
            tempLength--;
        }

        for (int i = 0; i < tempCount.length; i++) {
            if (tempCount[i] != -1) {
                return i;
            }
        }
        return -1;
    }

    public static int getLastNumber2(int n, int deleteIndex) {
        int[] arr = new int[n];

        Queue<Integer> queue
                = new LinkedList<>();

        Queue<Integer> queue2
                = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            queue.offer(i);
        }

        int length = n;
        int curentQ = 0;
        while (length > 1) {
            for (int i = 0; i < deleteIndex; i++) {
                if (curentQ == 0) {
                    if (queue.isEmpty()) {
                        curentQ = 1;
                        i--;
                    } else {
                        Integer poll = queue.poll();
                        if (i != deleteIndex - 1) {
                            queue2.offer(poll);
                        }
                    }
                } else {
                    if (queue2.isEmpty()) {
                        curentQ = 0;
                        i--;
                    } else {
                        Integer poll = queue2.poll();
                        if (i != deleteIndex - 1) {
                            queue.offer(poll);
                        }
                    }
                }
            }
            length--;
        }

        if (!queue.isEmpty()) {
            return queue.poll();
        } else {
            return queue2.poll();
        }
    }


    //????
    public static int getLastNumber3(int n, int deleteIndex) {
        if (n < 1 || deleteIndex < 1) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + deleteIndex) % i;
        }
        return last;
    }
}
