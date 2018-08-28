package chapter2;

import java.util.Arrays;

/**
 * 面试题4：
 * 二维数组中的查找
 * <p>
 * 在一个二维数组中，
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二位数组和一个整数，判断数组中是否有该整数
 */
public class P44_FindInPartiallySortedMatrix {
    public static boolean findInPartiallySortedMatrixBy(int[][] sortedMatriex, int target) {
        //校验输入的是否是符合条件的矩阵
        if (sortedMatriex == null) {
            return false;
        }
        int length = sortedMatriex.length;
        if (checkInputMatrix(sortedMatriex, length)) return false;

        //开始找
        if (length == 1) {
            return Arrays.binarySearch(sortedMatriex[0], target) != -1;
        } else {
            //从右上角开始找。如果大于右上角，则位于最后一列中，如果小于右上角，就找到对应的列的区间
            int targetRowIndex = findTargetColumnIndex(sortedMatriex, target);
            if (targetRowIndex != -1) {
                return Arrays.binarySearch(sortedMatriex[targetRowIndex], target) != -1;
            }
        }

        return false;
    }

    private static int findTargetColumnIndex(int[][] sortedMatriex, int target) {
        int columns = sortedMatriex.length;
        int rows = sortedMatriex[0].length;
        for (int i = 0; i < columns - 1; i++) {
            if (sortedMatriex[i][rows - 1] >= target) {
                return i;
            }
        }
        return -1;
    }

    private static boolean checkInputMatrix(int[][] sortedMatriex, int length) {
        if (length == 0) {
            return true;
        } else if (length == 1) {
            //2.从左到右
            for (int i = 0; i < length; i++) {
                int[] checkRow = sortedMatriex[i];
                for (int j = 0; j < checkRow.length - 1; j++) {
                    if (checkRow[j] > checkRow[j + 1]) {
                        return true;
                    }
                }
            }
        } else {
            //1. 先检查从上到下，是否满足递增
            for (int i = 0; i < length - 1; i++) {
                int[] curColumn = sortedMatriex[i];
                int[] nextColumn = sortedMatriex[i + 1];

                //长度不满足
                if (curColumn.length != nextColumn.length) {
                    return true;
                }

                //大小不满足
                for (int j = 0; j < curColumn.length; j++) {
                    if (nextColumn[j] <= curColumn[j]) {
                        return true;
                    }
                }
            }


            //2.从左到右
            for (int i = 0; i < length; i++) {
                int[] checkRow = sortedMatriex[i];
                for (int j = 0; j < checkRow.length - 1; j++) {
                    if (checkRow[j] > checkRow[j + 1]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean find(int[][] data, int target) {
        if (data == null || data.length == 0 || data[0].length == 0) {
            return false;
        }

        int rowMax = data.length - 1;
        int colMax = data[0].length - 1;

        int rowCur = data.length - 1;
        int colCur = 0;

        while (true) {
            if (rowCur < 0 | rowCur > rowMax | colCur < 0 | colCur > colMax) {
                return false;
            }
            if (data[rowCur][colCur] == target) {
                return true;
            } else if (data[rowCur][colCur] > target) {
                rowCur--;
            } else {
                colCur++;
            }
        }
    }
}
