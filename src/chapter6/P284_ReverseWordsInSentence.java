package chapter6;

import java.util.Stack;

/**
 * 翻转单词顺序
 * <p>
 * 输入一个英文句子，翻转单词顺序，单词内字符不翻转，标点符号和普通字母一样处理。
 * 例如输入输入“I am a student.”，则输出“student. a am I”。
 */
public class P284_ReverseWordsInSentence {
    public static String reverse(String str) {
        if (str == null || str.length() < 2) {
            return str;
        }

        char[] chars = str.toCharArray();
        int startIndex = 0;
        int subEndIndex = 0;
        Stack<String> stack = new Stack<>();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ') {
                subEndIndex = i;
                String item = String.valueOf(chars, startIndex, subEndIndex - startIndex);
                stack.push(item);

                if (i + 1 < length) {
                    startIndex = i + 1;
                    //不可能有连续两个空格
                    i++;
                }
            }
        }
        //补上最后一个
        String item = String.valueOf(chars, startIndex, length - startIndex);
        stack.push(item);

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            String pop = stack.pop();
            stringBuilder.append(pop);
            if (!stack.isEmpty()) {
                stringBuilder.append(" ");
            }
        }

        return stringBuilder.toString();
    }

    public static String reverse2(String str) {
        if (str == null || str.length() < 2) {
            return str;
        }

        char[] chars = str.toCharArray();
        int length = chars.length;
        char[] result = new char[length];

        //局部反转
        int start = 0;
        for (int i = 0; i < length; i++) {
            if (((i == length - 1) || (chars[i] == ' '))) {
                int endIndex;
                if (i == length - 1) {
                    endIndex = length - 1;
                } else {
                    endIndex = i - 1;
                    result[i] = ' ';
                }
                if (i - start > 1) {
                    reverseSub(chars, result, start, endIndex);
                } else {
                    result[start] = chars[start];
                }

                i++;
                start = i;
            }
        }

        //整体反转
        for (int i = 0; i < length; i++) {
            chars[i] = result[length - i - 1];
        }

        return String.valueOf(chars);
    }

    private static void reverseSub(char[] chars, char[] result, int start, int endIndex) {
        for (int i = start; i <= endIndex; i++) {
            result[endIndex-i+start] = chars[i];
        }
    }
}
