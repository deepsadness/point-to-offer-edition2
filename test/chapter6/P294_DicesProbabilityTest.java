package chapter6;

import org.junit.Test;

public class P294_DicesProbabilityTest {

    @Test
    public void dicesProbability() {
//        System.out.println("number = 0");
//        P294_DicesProbability.Solution1.dicesProbabilityRecursive(0);
//        System.out.println("number = 2");
//        P294_DicesProbability.Solution1.dicesProbabilityRecursive(2);
//        System.out.println("number = 11");
//        P294_DicesProbability.Solution1.dicesProbability(2);
        int print = P294_DicesProbability.Solution1.print(5, 3);
        System.out.println(print);
    }

    @Test
    public void solution2dicesProbabilityRecursive() {
        int number = 11;
        System.out.println("number = "+number);
        P294_DicesProbability.Solution2.dicesProbabilityRecursive(number);
//
//        System.out.println("number = "+number);
//        P294_DicesProbability.Solution2.dicesProbability(number);

    }

    @Test
    public void solution2dicesProbability() {
        int number = 11;
        System.out.println("number = "+number);
        P294_DicesProbability.Solution2.dicesProbability(number);
    }
}