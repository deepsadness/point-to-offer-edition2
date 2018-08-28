package chapter2;

/**
 * 剪绳子
 * 题目要求：
 * 给你一根长度为n的绳子，请把绳子剪成m段，记每段绳子长度为k[0],k[1]...k[m-1],求k[0]k[1]...k[m-1]的最大值。已知绳子长度n为整数，m>1(至少要剪一刀，不能不剪)，k[0],k[1]...k[m-1]均要求为整数。
 * 例如，绳子长度为8时，把它剪成3-3-2，得到最大乘积18；绳子长度为3时，把它剪成2-1，得到最大乘积2。
 * <p>
 * 定义为求解f(n)的问题 f(n)=max(f(n-i)*f(i))
 */
public class P96_CuttingRope {
    public static int cut(int n) {
        if (n < 2) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;

        //将之前的结果缓存下来
        int temp[] = new int[n + 1];
        temp[0] = 0;
        temp[1] = 1;
        temp[2] = 2;
        temp[3] = 3;

        //绳子的长度
        for (int i = 4; i <= n; i++) {
            //切割一段的长度
            int max = 0;

            for (int j = 1; j <= i / 2; j++) {
                int tempResult = temp[j] * temp[i - j];
                if (max < tempResult) {
                    max = tempResult;
                }
            }
            temp[i] = max;
        }

        return temp[n];

    }
}
