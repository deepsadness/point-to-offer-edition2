package chapter2;

/**
 * 矩阵中的路径
 * <p>
 * 题目要求
 * 设计一个函数，用来判断一个矩阵中是否存在一条包含某字符串的路径。
 * （1）起点随意；
 * （2）路径的移动只能是上下左右；
 * （3）访问过的位置不能再访问。以下图矩阵为例，包含“bfce”，但是不包含“abfb”。
 */
public class P89_StringPathInMatrix {
    public static boolean hasPath(char[][] arr, String str) {
        if (str == null || str.length() == 0 || arr == null || arr.length == 0) {
            return false;
        }
        char[] chars = str.toCharArray();

        //先找到第一个点的位置
        int strIndex = 0;
        char aChar = chars[strIndex];
        int tempRow = 0;
        int tempColumn = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == aChar) {
                    tempColumn = i;
                    tempRow = j;
                    break;
                }
            }
        }

        //0.left 1.right 2.up 3.down
        int findDirection = -1;
        //找下一个点的位置
        strIndex++;
        while (chars.length > strIndex) {
            //分别往四个方向去找
            char nextChar = chars[strIndex];
            //如果上一次找的是向右，这次就不能往左了
            if (tempRow > 1 && arr[tempColumn][tempRow - 1] == nextChar && findDirection != 1) {
                findDirection = 0;
                tempRow--;
            } else if (tempRow < arr[tempColumn].length - 1 && arr[tempColumn][tempRow + 1] == nextChar && findDirection != 0) {
                findDirection = 1;
                tempRow++;
            } else if (tempColumn > 1 && arr[tempColumn - 1][tempRow] == nextChar && findDirection != 3) {
                findDirection = 2;
                tempColumn--;
            } else if (tempColumn < arr.length - 1 && arr[tempColumn + 1][tempRow] == nextChar && findDirection != 2) {
                findDirection = 3;
                tempColumn++;
            } else {
                break;
            }
            strIndex++;
        }

        return strIndex == chars.length;
    }
}
