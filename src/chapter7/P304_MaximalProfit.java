package chapter7;

/**
 * 求买卖股票一次能获得的最大利润。
 * <p>
 * 例如，输入{9，11，8，5，7，12，16，14}，5的时候买入，16的时候卖出，则能获得最大利润11。
 */
public class P304_MaximalProfit {
    public static void getMax(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        if (arr.length == 2 && arr[1] > arr[0]) {
            System.out.println(arr[0] + "的时候买入，" + arr[1] + "的时候卖出，则能获得最大利润" + (arr[1] - arr[0]));
            return;
        }
        int last = arr[0];
        int diff = 0;
        int maxDiff = 0;
        int bestBuy = arr[0];
        int bestSell = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int profit = arr[i] - last;
            if (profit < 0 || profit < diff) {
                if (maxDiff < diff) {
                    maxDiff = diff;
                    bestBuy = last;
                    if (i - 1 > 0) {
                        bestSell = arr[i - 1];
                    }
                }
                last = arr[i];

                diff = 0;
            } else {
                diff = profit;
            }
        }


        System.out.println(bestBuy + "的时候买入，" + bestSell + "的时候卖出，则能获得最大利润" + maxDiff);
    }
}
