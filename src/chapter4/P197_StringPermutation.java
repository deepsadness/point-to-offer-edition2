package chapter4;

import java.util.HashSet;

/**
 * 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。如输入abc，则打印abc，acb，bac，bca，cab，cba。
 */
public class P197_StringPermutation {
    public static void printStringPermutation(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        if (str.length() == 1) {
            System.out.println(str);
        }
        HashSet<String> set = new HashSet<>();
        print(str, "",set);
        for (String s : set) {
            System.out.println(s);
        }
    }

    private static void print(String str, String result,HashSet<String> set) {
        if (str.length() == 2) {
            char c0 = str.charAt(0);
            char c1 = str.charAt(1);
            set.add("" + result + c0 + c1);
            set.add("" + c0 + c1 + result);
            set.add("" + result + c1 + c0);
            set.add("" + c1 + c0 + result);
        } else {
            char c0 = str.charAt(0);
            String result0 = result + c0;
            print(str.substring(1), result0,set);
            char cl = str.charAt(str.length() - 1);
            String result1 = result + cl;
            print(str.substring(0, str.length() - 1), result1,set);
        }

    }

}
