package chapter2;

/**
 * 面试题5
 * <p>
 * 将字符串中的每个空格替换成"%20".
 */
public class P51_ReplaceSpace {

    public static String replace(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        //因为是‘ ’ to '%20' 所以要增加两个位置
        char[] chars = str.toCharArray();
        int addSpace = 0;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == ' ') {
                addSpace += 2;
            }
        }

        char[] result = new char[chars.length + addSpace];
        int curIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == ' ') {
                result[curIndex] = '%';
                curIndex++;
                result[curIndex] = '2';
                curIndex++;
                result[curIndex] = '0';
                curIndex++;
            } else {
                result[curIndex] = aChar;
                curIndex++;
            }
        }

        return String.valueOf(result);
    }
}
