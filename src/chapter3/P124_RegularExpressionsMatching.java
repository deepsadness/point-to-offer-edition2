package chapter3;

/**
 * 正则表达式匹配
 * <p>
 * 实现正则表达式中.和*的功能。
 * 表示任意一个字符，*表示他前面的字符的任意次（含0次）。
 * 比如aaa与a.a和ab*ac*a匹配，但与aa.a和ab*a不匹配。
 */
public class P124_RegularExpressionsMatching {

    /**
     * 迭代的思想。
     *
     * 这里考虑的转义字符
     *
     * 每一个循环来进行判断。需要注意的是 需要有弹性的可能(之前已经匹配到了，但是没有往后走)
     * 迭代的方法的思想，看起来没有递归的清晰!!!!
     */
    public static boolean match(String target, String match) {
        if (target == null || match == null) {
            return false;
        }
        int matchLength = match.length();
        int targetLength = target.length();
        if (targetLength == 0 && matchLength == 0) {
            return true;
        }

        int index = 0;
        int matchIndex = 0;
        char[] targetChars = target.toCharArray();
        char[] matchChars = match.toCharArray();

        //检查match 不能两个*直接相连
        for (int i = 0; i < matchLength - 1; i++) {
            char matchChar = matchChars[i];
            if (matchChar == '*' && matchChar == matchChars[i + 1]) {
                throw new RuntimeException("SyntaxException: near index " + i + ",  * is error");
            }
        }

        //不够可以补。
        int flexibleIndex = 0;
        boolean lastIndexHasEqual = false;
        while (index < targetLength && matchIndex < matchLength) {
            char targetValue = targetChars[index];
            char matchChar = matchChars[matchIndex];

            //考虑转义字符.转义\\变成数组内，只有\
            if ((targetValue == '*' && (matchChar == '\\' && (matchIndex++ < matchLength && matchChars[matchIndex] == '*')))
                    || (targetValue == '.' && (matchChar == '\\' && (matchIndex++ < matchLength && matchChars[matchIndex] == '.')))
                    || targetValue == matchChar || matchChar == '.'
                    ) {

                if (matchIndex + 1 < matchLength && matchChars[matchIndex + 1] == '*') {
                    //移动2位
                    lastIndexHasEqual = true;
                    matchIndex += 2;
                    flexibleIndex++;
                } else {
                    lastIndexHasEqual = false;
                    //移动1位
                    index++;
                    matchIndex++;
                }

            } else if (matchIndex + 1 < matchLength && matchChars[matchIndex + 1] == '*') { //如果不相等。而且后面有* 就可以忽略.index不能++
                matchIndex += 2;
            } else {
                if (lastIndexHasEqual) {
                    lastIndexHasEqual = false;
                    index++;
                } else {
                    return false;
                }
            }
        }

        return index + flexibleIndex >= targetLength && matchIndex == matchLength;
    }

    /**
     * 递归的方式来思考。
     *
     * 递归的方式，就是想一个问题转成若干个小问题来看。
     *
     * 这里没有考虑转义字符
     *
     * 如果归于一个点来看，这个节点的情况判断后，就去找下一个点的情况（多种情况的结果并结果）。
     */
    public static boolean matchRecursive(String str, String pattern) {
        if (str == null || pattern == null) {
            return false;
        }

        int strIndex = 0;
        int patternIndex = 0;
        int sLength = str.length();
        int pLength = pattern.length();
        return matchRecursiveCore(str, pattern, strIndex, patternIndex, sLength, pLength);
    }
//"ab*a"
    private static boolean matchRecursiveCore(String str, String pattern, int strIndex, int patternIndex, int sLength, int pLength) {

        //完全匹配完的情况
        if (sLength == strIndex && patternIndex == pLength) {
            return true;
        }

        //模式串匹配完，原始串没有的时候
        if (strIndex != sLength && patternIndex == pLength) {
            return false;
        }

        //原始串结束，模式串还没结束
        if (strIndex == sLength) {
            //判断设下的，是不是*的组合
            if (patternIndex + 1 < pLength && pattern.charAt(patternIndex + 1) == '*') {
                return matchRecursiveCore(str, pattern, strIndex, patternIndex + 2, sLength, pLength);
            } else {
                return false;
            }
        }
        char sChar = str.charAt(strIndex);
        char pChar = pattern.charAt(patternIndex);

        //如果是p最后一个，下一个不是*。这个时候，不需要根据后面来判断。
        if (patternIndex == pLength - 1 || pattern.charAt(patternIndex + 1) != '*') {
            if (sChar == pChar || pChar == '.') {
                return matchRecursiveCore(str, pattern, strIndex + 1, patternIndex + 1, sLength, pLength);
            } else {
                return false;
            }
        } else {
            //需要判断后一位
            if (pChar == '.' || sChar == pChar) {
                return
                        //如果出现了情况3，需要考虑的情况
                        matchRecursiveCore(str, pattern, strIndex + 1, patternIndex, sLength, pLength) ||
                        //一起往后走
                        matchRecursiveCore(str, pattern, strIndex + 1, patternIndex + 2, sLength, pLength) ||
                        //没有往后走，p往后
                        matchRecursiveCore(str, pattern, strIndex, patternIndex + 2, sLength, pLength);
            } else {
                return matchRecursiveCore(str, pattern, strIndex, patternIndex + 2, sLength, pLength);
            }
        }
    }
}
