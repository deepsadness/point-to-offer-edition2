package chapter5;

import org.junit.Test;

/**
 * Created by Cry on 2018/9/4.
 */
public class P236_LongestSubstringWithoutDupTest {
    @Test
    public void getLength() {
        int count = P236_LongestSubstringWithoutDup.getLength("arabcacfr");
        int count2 = P236_LongestSubstringWithoutDup.getLength2("arabcacfr");
        System.out.println(count);
        System.out.println(count2);
    }

    @Test
    public void getLength2() {
        int count = P236_LongestSubstringWithoutDup.getLength("abcdefcaa");
        int count2 = P236_LongestSubstringWithoutDup.getLength2("abcdefcaa");
        System.out.println(count);
        System.out.println(count2);
    }

}