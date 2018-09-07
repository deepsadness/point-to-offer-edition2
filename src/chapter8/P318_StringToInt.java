package chapter8;

/**
 * 把字符串转换成整数
 * <p>
 * 1. 考虑大数问题 (最小和最大)
 * 2. 非法情况(非1234567890)
 * 3. 正负数 （0-最小就会溢出）
 * 4. 空格 null
 * 5. 前面的0
 */
public class P318_StringToInt {
    public static int strToInt(String str) throws Exception {
        if (str == null || str.length() == 0) {
            throw new Exception("待转换字符串为null或空串");
        }

        //先将头尾的空格去掉
        int length = str.length();
        int start = 0;
        int end = length - 1;

        while (start < length) {
            if (str.charAt(start) == ' ') {
                start++;
            } else {
                break;
            }
        }

        while (start < end) {
            if (str.charAt(end) == ' ') {
                end--;
            } else {
                break;
            }
        }
        if (end < start) {
            throw new Exception("待转换字符串为null或空串");
        } else if (end == start) {
            return str.charAt(end) - '0';
        }
        //得到过滤后的字符串
        String target = str.substring(start, end + 1);

        //先过滤前面的+-
        int index = 0;
        boolean isPositive = true;
        while (index < target.length()) {
            char c = str.charAt(index);
            if (c == '-') {
                isPositive = false;
            } else if (c == '+') {
                isPositive = true;
            } else {
                break;
            }
            index++;
        }

        int result = 0;
        int temp = 1;
        //开始遍历数字
        for (int i = target.length() - 1; i >= index; i--) {
            char c = target.charAt(i);
            int offset = c - '0';
            if (offset < 0 || offset > 9) { //已经出错了
                throw new Exception("字符串非整数,待转换字符串为" + str);
            } else {
                if (target.length() - 1 - i > 0) {
                    temp = temp * 10;
                }
                int step = offset * temp;
                //这里要注意。如果0-MINVALUE的话，数字就已经溢出了！！！
                if (!isPositive && (result == 0 || result - Integer.MIN_VALUE >= step)) {
                    result -= step;
                } else if (isPositive && Integer.MAX_VALUE - result >= step) {
                    result += step;
                } else {
                    throw new Exception("数值溢出,待转换字符串为" + str);
                }
            }
        }
        return result;
    }
}
