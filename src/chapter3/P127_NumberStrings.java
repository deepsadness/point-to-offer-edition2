package chapter3;

/**
 * 表示数值的字符串
 * <p>
 * 判断一个字符串是否表示数值，
 * 如+100,5e2，-123，-1E-16都是
 * 12e，1e3.14，+-5,1.2.3,12e+5.4都不是。
 */
public class P127_NumberStrings {

    /**
     * 分析
     * 1.第一位可能是正负数。后面都没可能
     * 2.只能有一个小数点。小数点可以为第一位.可以为最后一位
     * 3.e E 不能做第一位。必须在小数后面。后面只能是整数
     * <p>
     * 将函数分成三段考虑
     * 1. 一段是在小数点之前。
     * 2. 小数点之后
     * 3.e之后
     */
    public static boolean isNumeric(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int length = str.length();
        int strIndex = 0;
        if (str.charAt(strIndex) == '-' || str.charAt(strIndex) == '+') {
            strIndex++;
        }
        if (strIndex >= length) {
            return false;
        }

        //找到是否有小数位，或者e,E
        int prefixNumberIndex = scanInteger(str, strIndex);

        //相等就没有数字
        if (strIndex == prefixNumberIndex) {
            //前面没有数字的情况，可以有小数点。不能有e
            char c = str.charAt(strIndex);
            return c == '.' && afterDot(str, length, strIndex, false);
        } else { //前面有数字
            if (prefixNumberIndex < length) {
                //前面有数字的情况，可以有小数点。不能有
                strIndex = prefixNumberIndex;
                char c = str.charAt(strIndex);
                if (c == '.') {
                    return afterDot(str, length, strIndex, true);
                } else {  //开始指数部分
                    return (c == 'e' || c == 'E') && afterE(str, length, strIndex);
                }
            } else {
                return true;
            }
        }
    }

    //如果小数点前面没有数字，则 defaultValue为false ,否则为true
    private static boolean afterDot(String str, int length, int strIndex, boolean defaultValue) {
        strIndex++;
        //小数点后面也不能添加。也能作为结尾
        if (strIndex != length) {
            int afterDotNumberIndex = scanInteger(str, strIndex);
            if (afterDotNumberIndex != strIndex) { //有数字，可以接着，看有没有e
                if (afterDotNumberIndex >= length) {    //没有了。ok
                    return true;
                } else { //开始指数部分
                    strIndex = afterDotNumberIndex;
                    char next = str.charAt(strIndex);
                    return (next == 'e' || next == 'E') && afterE(str, length, strIndex);
                }
            }
        }
        return defaultValue;
    }

    private static boolean afterE(String str, int length, int strIndex) {
        //后面只能是符合和数字了
        strIndex++;
        if (strIndex < length) {
            char c1 = str.charAt(strIndex);
            if (c1 == '+' || c1 == '-') {
                strIndex++;
            }
            if (strIndex < length) {
                int lastNumberIndex = scanInteger(str, strIndex);
                return lastNumberIndex != strIndex && lastNumberIndex == length;
            }
        }
        return false;
    }

    private static int scanInteger(String str, int strIndex) {
        int index = strIndex;
        while (index < str.length() && str.charAt(index) - '0' >= 0 && str.charAt(index) - '0' <= 9) {
            index++;
        }
        return index;
    }

}
