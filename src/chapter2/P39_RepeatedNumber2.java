package chapter2;

/**
 * 面试题3：数组中重复的数
 * <p>
 * 题目要求：
 * 在一个长度为n的数组中，所有数字的取值范围都在[0,n-1]，但不知道有几个数字重复或重复几次，找出其中任意一个重复的数字
 * <p>
 * https://www.jianshu.com/p/fb65947a2e9c
 */
public class P39_RepeatedNumber2 {
    /**
     * 暴力求解法。
     * <p>
     * 一个一个遍历。如果有相同的，则返回对应的数字。如果没有相同的，就返回-1
     * <p>
     * 因为要进行两个循环，时间复杂度为n2
     *
     * @param arr 输入数组
     * @return repeated number or -1
     */
    public static int solution1(int[] arr) {
        if (arr == null) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                int jtemp = arr[j];
                if (temp == jtemp) {
                    return jtemp;
                }
            }
        }
        return -1;
    }

    /**
     * 快排方案
     * <p>
     * 先排序，再找
     * <p>
     * 会改变原来的数组
     *
     * @param arr
     * @return
     */
    public static int solution2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }
        quickFindInternal(arr, 0, arr.length - 1);

        //在遍历寻找
        for (int i = 0; i < arr.length - 1; i++) {
            int prev = arr[i];
            if (prev == arr[i + 1]) {
                return prev;
            }
        }

        return -1;
    }

    private static void quickFindInternal(int[] arr, int left, int right) {
        if (left < right) {
            int start = left;
            int end = right - 1;
            int mid = arr[right];

            while (start < end) {
                while (start < end) {
                    if (mid > arr[start]) {
                        start++;
                    } else {
                        break;
                    }
                }

                while (start < end) {
                    if (mid < arr[end]) {
                        end--;
                    } else {
                        break;
                    }
                }
                //交换
                if (arr[start] != arr[end]) {
                    //交换
                    int temp = arr[start];
                    arr[start] = arr[end];
                    arr[end] = temp;
                }
            }


            if (arr[start] >= arr[end]) {
                //交换
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            } else {
                start++;
            }

            quickFindInternal(arr, left, start - 1);
            quickFindInternal(arr, start + 1, right);
        }
    }

    /**
     * 哈希表方案
     * <p>
     * 空间 O(n)
     *
     * @param arr
     * @return
     */
    public static int solution3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }
        int[] hashTable = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            if (hashTable[temp] == 0) {
                hashTable[temp] = 1;
            } else {
                return temp;
            }
        }
        return -1;
    }

    /**
     * 利用数字特点
     * <p>
     * 改变原始数组
     *
     * @param arr
     * @return
     */
    public static int solution4(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }

        int start = 0;
        while (start < arr.length) {
            if (arr[start] == start) {
                start++;
            } else {
                int temp = arr[start];
                if (arr[temp] == temp) {
                    return temp;
                } else {
                    arr[start] = arr[temp];
                    arr[temp] = temp;
                }
            }
        }


        return -1;
    }


    /**
     * 类似两路归并的方式。统计数字在数组中出现的次数。
     * 1-m中的数字，应该是出现 m次。m-n应该是m-n次。
     *
     * n+1 都在 1-n的方位内。
     *
     * @param arr
     * @return
     */
    public static int solution5(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }

        //最小的数字
        int start = 0;
        //最大的数字
        int end = arr.length - 1;
        int count = 0;
        while (start <= end) {
            //选取到m
            int m = (start + end) / 2;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] <= m && arr[i] >= start) {
                    count++;
                }
            }

            if (start == end) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }

            if (count > (m - start + 1))
                end = m;
            else
                start = m + 1;
        }
        return -1;
    }


}
