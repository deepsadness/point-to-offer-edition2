package chapter4;

/**
 * 顺时针打印矩阵
 * <p>
 * 输入一个矩阵，按照从外向里以顺时针的顺序一次打印出每一个数字。
 * <p>
 * 画图来确定坐标是最准确的！！！
 */
public class P161_PrintMatrix {
    public static String println(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return "";
        }

        int height = matrix.length;
        StringBuilder stringBuilder = new StringBuilder();

        if (height == 1) { //直接打印
            leftToRight(matrix[0], stringBuilder, 0, matrix[0].length - 1);
        } else {
            int width = matrix[0].length;
            for (int i = 1; i < height; i++) {
                if (matrix[i].length != width) {
                    throw new RuntimeException("Please keep every matrix's column has same length");
                }
            }

            int maxRound;
            int minWh;
            if (width > height) {
                minWh = height;
                maxRound = minWh / 2;
            } else {
                minWh = width;
                maxRound = minWh / 2;
            }
            int curRound = 0;

            while (curRound < maxRound) {
                int leftIndex = curRound;
                int rightIndex = width - curRound - 1;
                int upIndex = curRound;
                int downIndex = height - curRound - 1;


                leftToRight(matrix[upIndex], stringBuilder, leftIndex, rightIndex);

                upToDown(matrix, stringBuilder, downIndex - 1, upIndex + 1, rightIndex);

                rightToLeft(matrix[downIndex], stringBuilder, rightIndex, leftIndex);

                downToUp(matrix, stringBuilder, downIndex - 1, upIndex + 1, leftIndex);

                curRound++;
            }

            if ((minWh & 1) == 1) {   //如果是奇数。直接打印剩下的值
                int leftIndex = maxRound;
                int rightIndex = width - maxRound - 1;
                int upIndex = maxRound;
                int downIndex = height - maxRound - 1;

                if (width > height) {
                    leftToRight(matrix[upIndex], stringBuilder, leftIndex, rightIndex);
                } else if (width < height) {
                    upToDown(matrix, stringBuilder, downIndex, upIndex, rightIndex);
                } else {
                    stringBuilder.append(matrix[maxRound][maxRound]).append(",");
                }

            }
        }
        return stringBuilder.toString();
    }

    private static void leftToRight(int[] matrix, StringBuilder stringBuilder, int left, int right) {
        //left to right
        for (int i = left; i <= right; i++) {
            stringBuilder.append(matrix[i]).append(",");
        }
    }

    private static void rightToLeft(int[] matrix, StringBuilder stringBuilder, int right, int left) {
        //right to left
        for (int i = right; i >= left; i--) {
            stringBuilder.append(matrix[i]).append(",");
        }
    }

    private static void upToDown(int[][] matrix, StringBuilder stringBuilder, int down, int up, int rowIndex) {
        //up to down
        for (int i = up; i <= down; i++) {
            stringBuilder.append(matrix[i][rowIndex]).append(",");
        }
    }


    private static void downToUp(int[][] matrix, StringBuilder stringBuilder, int down, int up, int colunmIndex) {
        //down to up
        for (int i = down; i >= up; i--) {
            stringBuilder.append(matrix[i][colunmIndex]).append(",");
        }
    }


}
