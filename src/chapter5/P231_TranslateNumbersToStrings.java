package chapter5;

import java.util.ArrayList;
import java.util.List;

/**
 * 把数字翻译成字符串
 * <p>
 * 给定一个数字，按照如下规则翻译成字符串：
 * 0翻译成“a”，1翻译成“b”...25翻译成“z”。
 * 一个数字有多种翻译可能，
 * 例如12258一共有5种，
 * 分别是bccfi，bwfi，bczi，mcfi，mzi。
 * 实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 */
public class P231_TranslateNumbersToStrings {

    public static int translate(int num) {
        if (num < 0) {
            return 0;
        }
        String s = String.valueOf(num);
        if (s.length() == 1) {
            return 1;
        }

        List<String> list = new ArrayList<>();
        translateString("", s, 0, list);

        return list.size();
    }

    private static void translateString(String lastValue, String str, int index, List<String> list) {
        if (index >= str.length()) {
//            System.out.println(lastValue);
            list.add(lastValue);
            return;
        }
        char c = str.charAt(index);
        int firstOffset = c - '0';
        String firstValue = lastValue + (char) (firstOffset + 'a');
        translateString(firstValue, str, index + 1, list);

        if (firstOffset < 3 && index + 1 < str.length() && (str.charAt(index + 1) - '0') < 6) {
            int secondOffset = str.charAt(index + 1) - '0';
            int totalOffset = firstOffset * 10 + secondOffset;
            String secodeValue = lastValue + (char) (totalOffset + 'a');
            translateString(secodeValue, str, index + 2, list);
        }
    }

    /**
     *
     * 自下而上，动态规划，从最小的问题开始 ：
     * f(r)表示以r为开始（r最小取0）到最右端所组成的数字能够翻译成字符串的种数。对于长度为n的数字，f(n)=0,f(n-1)=1,求f(0)。
     * 递推公式为 f(r-2) = f(r-1)+g(r-2,r-1)*f(r)；
     * 其中，如果r-2，r-1能够翻译成字符，则g(r-2,r-1)=1，否则为0。
     * 因此，对于12258：
     * f(5) = 0
     * f(4) = 1
     * f(3) = f(4)+0 = 1
     * f(2) = f(3)+f(4) = 2
     * f(1) = f(2)+f(3) = 3
     * f(0) = f(1)+f(2) = 5
     *
     */
    public static int translate2(int num) {
        if (num < 0) {
            return 0;
        }
        String str = String.valueOf(num);
        if (str.length() == 1) {
            return 1;
        }
        int startIndex = str.length() - 2;
        int fn_2 = 0;
        int fn_1 = 1;
        int temp=0;
        int g = 0;
        while (startIndex >= 0) {
            char c = str.charAt(startIndex);
            int firstOffset = c - '0';
            if (firstOffset < 3 && startIndex + 1 < str.length() && (str.charAt(startIndex + 1) - '0') < 6) {
                g = 1;
            } else {
                g = 0;
            }
            temp = fn_1;
            fn_1 = fn_1 + g * fn_2;
            fn_2 = temp;
            startIndex--;
        }
        return fn_1;
    }

}
