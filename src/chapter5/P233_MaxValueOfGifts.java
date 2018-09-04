package chapter5;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 礼物的最大值
 * <p>
 * 在一个m*n的棋盘的每一个格都放有一个礼物，每个礼物都有一定价值（大于0）。
 * 从左上角开始拿礼物，每次向右或向下移动一格，直到右下角结束。
 * 给定一个棋盘，求拿到礼物的最大价值。例如，对于如下棋盘
 * 1    10   3    8
 * 12   2    9    6
 * 5    7    4    11
 * 3    7    16   5
 * <p>
 * 礼物的最大价值为1+12+5+7+7+16+5=53。
 */
public class P233_MaxValueOfGifts {
    public static int getMaxValue(int[][] gifts) {
        if (gifts == null || gifts.length == 0) {
            return 0;
        }
        int rowIndex = 0;
        int columnIndex = 0;
        int sum = gifts[columnIndex][rowIndex];
        return getNextValue(gifts, columnIndex, rowIndex, sum);
    }

    private static int getNextValue(int[][] gifts, int columnIndex, int rowIndex, int sum) {
        int length = gifts.length;
        if (columnIndex + 1 < length && rowIndex + 1 < length) {
            int valueDown = gifts[columnIndex + 1][rowIndex];
            int valueRight = gifts[columnIndex][rowIndex + 1];
            if (valueDown > valueRight) {
                sum = sum + valueDown;
                return getNextValue(gifts, columnIndex + 1, rowIndex, sum);
            } else if (valueDown < valueRight) {
                sum = sum + valueRight;
                return getNextValue(gifts, columnIndex, rowIndex + 1, sum);
            } else {
                sum = sum + valueDown;
                //相等的话。。。
                int nextDown = getNextValue(gifts, columnIndex + 1, rowIndex, sum);
                int nextRight = getNextValue(gifts, columnIndex, rowIndex + 1, sum);
                return nextDown > nextRight ? nextDown : nextRight;

            }
        } else if (columnIndex + 1 < length && rowIndex + 1 >= length) {
            int valueDown = gifts[columnIndex + 1][rowIndex];
            sum = sum + valueDown;
            return getNextValue(gifts, columnIndex + 1, rowIndex, sum);
        } else if (columnIndex + 1 >= length && rowIndex + 1 < length) {
            int valueRight = gifts[columnIndex][rowIndex + 1];
            sum = sum + valueRight;
            return getNextValue(gifts, columnIndex, rowIndex + 1, sum);
        } else {
            return sum;
        }
    }

    /**
     * 广度优先遍历
     *
     * 这个棋盘其实可以看成一个有向图，起点为左上角，终点为右下角，每一点仅仅指向右侧和下侧。
     * 因此我们可以从左上角开始进行广度优先遍历。
     * 此外，
     * 遍历过程中可以进行剪枝，
     * 最终移动到右下角时会仅剩下一个枝，
     * 该路径所经的点的数值之和即为所求。
     *
     */
    public static int getMaxValue2(int[][] gifts) {
        if (gifts == null || gifts.length == 0) {
            return 0;
        }
        int rowIndex = 0;
        int columnIndex = 0;
        int sum = gifts[columnIndex][rowIndex];
        return getNextValue(gifts, columnIndex, rowIndex, sum);
    }


    //方法一：动态规划 ???
    public static int getMaxVaule(int[][] data){
        if(data.length==0||data[0].length==0)
            return 0;
        int[][] dp = new int[2][data[0].length];
        int dpCurRowIndex = 0,dpPreRowIndex = 0;
        for(int row=0;row<data.length;row++){
            dpCurRowIndex = row&1;
            dpPreRowIndex = 1 - dpCurRowIndex;
            for(int col=0;col<data[0].length;col++){
                if(col==0)
                    dp[dpCurRowIndex][col] = dp[dpPreRowIndex][col]+data[row][col];
                else{
                    if(dp[dpPreRowIndex][col]>=dp[dpCurRowIndex][col-1])
                        dp[dpCurRowIndex][col] = dp[dpPreRowIndex][col]+data[row][col];
                    else
                        dp[dpCurRowIndex][col] = dp[dpCurRowIndex][col-1]+data[row][col];
                }
            }
        }
        return dp[(data.length-1)&1][data[0].length-1];
    }

    //方法二：有向图的遍历（广度优先，可再剪枝进行优化）
    public static int getMaxVaule2(int[][] data){
        if(data.length==0||data[0].length==0)
            return 0;
        int maxRowIndex = data.length-1;
        int maxColIndex = data[0].length-1;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0,0,data[0][0]));
        Node nodeCur = null;
        while (!(queue.peek().row==maxRowIndex && queue.peek().col==maxColIndex)){
            nodeCur = queue.poll();
            if(nodeCur.row!=maxRowIndex)
                queue.offer(new Node(nodeCur.row+1,nodeCur.col,nodeCur.sum+data[nodeCur.row+1][nodeCur.col]));
            if(nodeCur.col!=maxColIndex)
                queue.offer(new Node(nodeCur.row,nodeCur.col+1,nodeCur.sum+data[nodeCur.row][nodeCur.col+1]));
        }
        int maxSum = 0,temp = 0;
        while (!queue.isEmpty()){
            temp = queue.poll().sum;
            if(temp>maxSum)
                maxSum = temp;
        }
        return maxSum;
    }
    public static class Node{
        int row;
        int col;
        int sum;
        public Node(int r,int c,int s){
            row = r;col = c;sum = s;
        }
    }
}
