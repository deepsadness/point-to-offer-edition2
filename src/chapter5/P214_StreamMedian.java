package chapter5;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据流中的中位数
 * <p>
 * 得到一个数据流中的中位数。
 * <p>
 * 解题思路：
 * <p>
 * 此题的关键在于“数据流”，即数字不是一次性给出，解题的关键在于重新写一个结构记录历史数据。下面给出三种思路，分别借助于链表、堆、二叉搜索树完成。
 * <p>
 * 思路1：
 * 使用未排序的链表存储数据，使用快排的分区函数求中位数；也可以在插入时进行排序，这样中位数的获取会很容易，但插入费时。
 * 思路2：
 * 使用堆存储，两个堆能够完成最大堆-最小堆这样的简单分区，两个堆的数字个数相同或最大堆数字个数比最小堆数字个数大1，
 * 中位数为两个堆堆顶的均值或者最大堆的堆顶。
 * 思路3：
 * 使用二叉搜索树存储，每个树节点添加一个表征子树节点数目的字段用于找到中位数。
 */
public class P214_StreamMedian {
    interface Stream {
        void addNum(double number);

        double findMedian();
    }

    public static class HeapStream implements Stream {
        //要有一个大堆和小堆
        List<Double> bigHeap = new ArrayList<>();
        List<Double> smallHeap = new ArrayList<>();
        int bufSize = 10;
        int count = 0;

        @Override
        public void addNum(double number) {
            count++;
            if ((count & 1) == 1) {   //如果是奇数，则放在大堆
                double target = number;
                if (smallHeap.size() > 0 && smallHeap.get(0) < number) {
                    target = smallHeap.get(0);
                    smallHeap.set(0, number);
                    minifyHeap(smallHeap, 0, smallHeap.size());
                }
                bigHeap.add(target);
                maxifyHeap(bigHeap, 0, bigHeap.size());
            } else {
                double target = number;
                if (bigHeap.size() > 0 && bigHeap.get(0) > number) {
                    target = bigHeap.get(0);
                    bigHeap.set(0, number);
                    maxifyHeap(bigHeap, 0, bigHeap.size());
                }
                smallHeap.add(target);
                minifyHeap(smallHeap, 0, smallHeap.size());
            }
        }

        private void minifyHeap(List<Double> smallHeap, int low, int length) {
            int root = low;
            int left = 2 * root + 1;
            int high = length;
            double rootValue = smallHeap.get(root);
            while (left < high) {
                if (left + 1 < high && smallHeap.get(left + 1) < smallHeap.get(left)) {
                    left++;
                }

                if (smallHeap.get(left) < rootValue) {
                    smallHeap.set(root, smallHeap.get(left));
                    root = left;
                    left = 2 * root + 1;
                } else {
                    break;
                }
            }
            smallHeap.set(root, rootValue);
        }

        private void maxifyHeap(List<Double> bigHeap, int low, int length) {
            int root = low;
            int left = 2 * root + 1;
            int high = length;
            double rootValue = bigHeap.get(root);
            while (left < high) {
                if (left + 1 < high && bigHeap.get(left + 1) > bigHeap.get(left)) {
                    left++;
                }

                if (bigHeap.get(left) > rootValue) {
                    bigHeap.set(root, bigHeap.get(left));
                    root = left;
                    left = 2 * root + 1;
                } else {
                    break;
                }
            }
            bigHeap.set(root, rootValue);
        }

        @Override
        public double findMedian() {
            if (count == 0) {
                return 0;
            } else {
                if ((count & 1) == 1) {
                    return bigHeap.get(0);
                } else {
                    return (bigHeap.get(0) + smallHeap.get(0)) / 2;
                }
            }
        }
    }

}
