package chapter6;

/**
 * 左旋转字符串
 * <p>
 * 实现一个函数完成字符串的左旋转功能。比如，输入abcdefg和数字2，输出为cdefgab。
 */
public class P286_LeftRotateString {
    public static String leftRotate(String str, int count) {
        if (str == null || str.length() < 2 || count == 0) {
            return str;
        }

        if (count >= str.length()) {
            return str;
        }

        return str.substring(count, str.length()) + str.substring(0, count);
    }
}
