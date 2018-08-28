package chapter2;

/**
 * 机器人的运动范围
 * 题目要求：
 * 地上有一个m行n列的方格，一个机器人从坐标(0,0)的各自开始移动，
 * 它每次可以向上下左右移动一格，但不能进入横纵坐标数位之和大于k的格子。
 * <p>
 * 例如，当k等于18时，机器人能进入(35,37)，因为3+5+3+7=18；
 * 但却不能进入(35,38)，因为3+5+3+8=19>18。
 * 请问该机器人能够到达多少个格子。
 */
public class P92_RobotMove {

    public static int moveCount(int threshold, int rowLen, int colLen) {

        boolean[][] visibile = new boolean[rowLen][colLen];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                visibile[i][j] = false;
            }
        }
        return moving(threshold, rowLen, colLen, 0, 0, visibile);
    }

    private static int moving(int threshold, int totalRow, int totalColumn, int curRow, int curColumn, boolean[][] visibile) {
        int count = 0;
        if (canGetIn(curRow, curColumn, totalRow, totalColumn, threshold, visibile)) {
            visibile[curRow][curColumn] = true;
            count = 1
                    + moving(threshold, totalRow, totalColumn, curRow + 1, curColumn, visibile)
                    + moving(threshold, totalRow, totalColumn, curRow, curColumn + 1, visibile)
                    + moving(threshold, totalRow, totalColumn, curRow - 1, curColumn, visibile)
                    + moving(threshold, totalRow, totalColumn, curRow, curColumn - 1, visibile)
            ;
        }
        return count;
    }

    private static boolean canGetIn(int curRow, int curColumn, int totalRow, int totalColumn, int threshold, boolean[][] visibile) {
        return curRow >= 0 && curColumn >= 0 && curRow < totalRow && curColumn < totalColumn && getSum(curRow, curColumn) <= threshold && !visibile[curRow][curColumn];
    }

    private static int getSum(int rowLen, int colLen) {
        int sum = 0;
        while (rowLen / 10 > 0) {
            sum += rowLen % 10;
            rowLen = rowLen / 10;
        }
        sum += rowLen % 10;

        while (colLen / 10 > 0) {
            sum += colLen % 10;
            colLen = colLen / 10;
        }
        sum += colLen % 10;

        return sum;
    }
}
