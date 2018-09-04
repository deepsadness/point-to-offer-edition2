package chapter5;

/**
 * 最长不含重复字符的子字符串
 * <p>
 * 输入一个字符串（只包含a~z的字符），
 * 求其最长不含重复字符的子字符串的长度。
 * 例如对于arabcacfr，最长不含重复字符的子字符串为acfr，长度为4。
 * <p>
 * abcade
 */
public class P236_LongestSubstringWithoutDup {
    //暴力求解
    public static int getLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        if (str.length() == 1) return 1;
        int[] chars = new int[26];

        for (int k = 0; k < chars.length; k++) {
            chars[k] = -1;
        }

        String temp = "";
        String longest = "";
        int count = 0;
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            char c1 = str.charAt(i);
            int offset = c1 - 'a';
            if (chars[offset] == -1) {
                chars[offset] = i;
            } else {
                if (longest.length() < temp.length()) {
                    longest = temp;
                }
                if (count > max) {
                    max = count;
                }
                if (temp.length() > 0) {
                    int oldIndex = chars[offset];
                    int headOffset = temp.charAt(0) - 'a';
                    int headIndex = chars[headOffset];
                    int repeatIndex = oldIndex - headIndex;

                    for (int j = 0; j < repeatIndex; j++) {
                        chars[temp.charAt(j) - 'a'] = -1;
                    }

                    if (repeatIndex + 1 < temp.length()) {
                        temp = temp.substring(repeatIndex + 1);
                        count = count - repeatIndex - 1;
                    }
                }
                chars[offset] = i;
            }
            count++;
            temp += c1;
        }

        return longest.length();
    }

    /**
     * 利用动态规划，不在退回到最前面。而是从不重复的部分，开始
     */
    public static int getLength2(String str) {

        if (str == null || str.length() == 0) {
            return 0;
        }
        if (str.length() == 1) return 1;
        int[] chars = new int[26];

        for (int k = 0; k < chars.length; k++) {
            chars[k] = -1;
        }

        int count = 0;
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            char c1 = str.charAt(i);
            int offset = c1 - 'a';
            if (chars[offset] == -1 || i - offset > count) {
                chars[offset] = i;
            } else {
                if (count > max) {
                    max = count;
                }
                count = count - (i - offset);
                chars[offset] = i;
            }
            count++;
        }

        return max;
    }
}
