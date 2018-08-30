package chapter3;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P124_RegularExpressionsMatchingTest {


    //直接使用.
    @Test
    public void matchSimpleDot() {
        String target = "aaa";
        String match1 = "a.a";
        checkResult(target, match1);
    }

    @Test
    public void matchSimpleStar1() {
        String target = "aaa";
        String match1 = "ab*ac*a";
        checkResult(target, match1);
    }

    @Test
    public void matchSimpleStar2() {
        String target = "aaa";
        String match1 = "aa*c*a";
        checkResult(target, match1);
    }

    @Test
    public void matchSimpleStar3() {
        String target = "aba";
        String match1 = "ab*a*c*a";
        checkResult(target, match1);
    }

    @Test
    public void matchEscapeNormalDot() {
        String target = "a.a";
        String match1 = "a\\.a";
        checkResult1(target, match1);
    }

    @Test
    public void matchEscapeNormalStar() {
        String target = "a*a";
        String match1 = "a\\*a";
        checkResult1(target, match1);
    }

    //直接使用.
    @Test
    public void matchEscape() {
        String target = "a.a";
        String match1 = "a\\.*a";
        checkResult1(target, match1);
    }

    //直接使用.
    @Test
    public void matchNo() {
        String target = "aaa";
        String match1 = "aa.a";
        checkResult(target, match1);

        String match2 = "ab*a";
        checkResult(target, match2);
    }

    private void checkResult(String target, String match1) {
        Pattern compile = Pattern.compile(match1);
        Matcher result = compile.matcher(target);
        Assert.assertEquals(result.matches(), P124_RegularExpressionsMatching.match(target, match1));
        Assert.assertEquals(result.matches(), P124_RegularExpressionsMatching.matchRecursive(target, match1));
    }

    private void checkResult1(String target, String match1) {
        Pattern compile = Pattern.compile(match1);
        Matcher result = compile.matcher(target);
        Assert.assertEquals(result.matches(), P124_RegularExpressionsMatching.match(target, match1));
    }

}