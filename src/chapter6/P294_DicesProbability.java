package chapter6;

/**
 * n个骰子的点数
 * <p>
 * 把n个骰子仍在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值的出现概率。
 */
public class P294_DicesProbability {

    public static class Solution1 {
        public static void dicesProbability(int n) {
            //计算出count 为n时，可能的情况
            int all = n * 6;
            int[] ints = new int[all];
            for (int i = 1; i <= all; i++) {
                ints[i - 1] = print(i, n);
            }
            //计算一共有多少中可能性
            int total = 0;
            for (int i = 0; i < all; i++) {
                total = total + ints[i];
            }

            //输出每一种可能性的百分比
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < all; i++) {
                stringBuilder.append("sum = ").append(i + 1).append(", probability = ").append(ints[i] * 1f / total).append("\n");
            }
            System.out.println(stringBuilder.toString());
        }

        //这里理解错了。这里是输入s 和n 输出各种组合的可能性
        public static int print(int sum, int n) {
            //不行的情况
            if (n == 0 || sum > 6 * n || sum < 0) return sum;
            int[] count = {0};
            dicesProbability(sum, n, n, "", count);
            return count[0];
        }

        private static void dicesProbability(int sum, int n, int on, String str, int[] count) {
            //不行的情况
            if (n == 0 || sum > 6 * n || sum <= 0) return;
            if (n == 1) {
                if (str.length() > 0) {
                    str = str + "," + sum;
                } else {
                    str = "" + sum;
                }
                count[0]++;
            } else {
                for (int i = 1; i <= 6; i++) {
                    if (str.length() > 0 && n != on) {
                        str = str + "," + i;
                    } else {
                        str = "" + i;
                    }
                    dicesProbability(sum - i, n - 1, n, str, count);
                }
            }
        }
    }

    public static class Solution2 {
        //递归的方式。效率低
        public static void dicesProbabilityRecursive(int n) {
            int[] result = new int[n * 6];
            for (int i = 1; i <= 6; i++) {
                appendNextN(n - 1, i, result);
            }

            int count = 0;
            for (int i = 0; i < result.length; i++) {
                count += result[i];
            }
//            System.out.println(Arrays.toString(result));
            //输出每一种可能性的百分比
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < result.length; i++) {
                stringBuilder.append("sum = ").append(i + 1).append(", probability = ").append(result[i] * 1f / count).append("\n");
            }
            System.out.println(stringBuilder.toString());
        }

        private static void appendNextN(int n, int sum, int[] result) {
            if (n == 0) {
                result[sum - 1]++;
                return;
            }
            for (int i = 1; i <= 6; i++) {
                appendNextN(n - 1, i + sum, result);
            }
        }

        public static void dicesProbability(int number) {
            int[][] temp = new int[2][number * 6 + 1];
            int tempNum = 1;
            while (tempNum <= number) {
                int curColumn = (tempNum & 1) == 1 ? 1 : 0;
                int lastColumn = (tempNum & 1) == 1 ? 0 : 1;
                if (tempNum == 1) {
                    for (int i = 1; i <= 6; i++) {
                        temp[curColumn][i]++;
                    }
                } else {
                    int lastNumber = tempNum - 1;
                    for (int i = lastNumber; i <= lastNumber * 6; i++) {
                        //取出上一次的值
                        //这次的值，只可能有6个
                        //当前点对应的上一次的只
                        int lastValue= temp[lastColumn][i];
                        //将新的值，往上一次的值上加
                        for (int j = 1; j <= 6; j++) {
                            //上一次有可能的值。和这一次的值。
                            int curValue = i + j;
                            //上一次的值边上构成上面的次数，所以每次增加的次数，都是上一次的次数
                            temp[curColumn][curValue] = temp[curColumn][curValue] + lastValue;
                        }
                    }
                    //将当前的数组清空.上一次的可能涉及的位置清空
                    for (int i = lastNumber; i <= lastNumber * 6; i++) {
                        temp[lastColumn][i] = 0;
                    }
                }
                tempNum++;
            }

            int resultColumn = (number & 1) == 1 ? 1 : 0;
            int[] targetArr = temp[resultColumn];
            int total = 0;
//            System.out.println(Arrays.toString(targetArr));
            for (int i = 1; i <= number * 6; i++) {
                total += targetArr[i];
            }

            //输出每一种可能性的百分比
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 1; i < targetArr.length; i++) {
                stringBuilder.append("sum = ").append(i).append(", probability = ").append(targetArr[i] * 1f / total).append("\n");
            }
            System.out.println(stringBuilder.toString());
        }
    }

}
