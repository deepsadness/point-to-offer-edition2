package chapter6;

import org.junit.Test;

public class P284_ReverseWordsInSentenceTest {

    @Test
    public void reverse() {
        String str = "I am a student.";
        String reverse = P284_ReverseWordsInSentence.reverse(str);
        System.out.println(reverse);
    }

    @Test
    public void reverse2() {
        String str = "I am a student.";
        String reverse = P284_ReverseWordsInSentence.reverse2(str);
        System.out.println(reverse);
    }
}