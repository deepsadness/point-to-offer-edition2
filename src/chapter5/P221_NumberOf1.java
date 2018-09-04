package chapter5;

/**
 * 1~n整数中1出现的次数
 * <p>
 * 输入一个整数，求1~n这n个整数中1出现的次数。
 * 如输入12，则包含1的数字有1,10,11,12，一共出现了5次1，因此输入5。
 */
public class P221_NumberOf1 {

    //暴力求解的方式
    public static int getNumber1Times(int num) {
        if (num < 1) return 0;

        int count = 0;
        for (int i = num; i >= 1; i--) {
            count += isContainsNumber1Times(i);
        }
        return count;
    }

    public static int isContainsNumber1Times(int num) {
        int temp = num;
        int count = 0;
        while (temp != 0) {
            if ((temp % 10) == 1) {
                count++;
            }
            temp = temp / 10;
        }
        return count;
    }

    //观察数字规律
    private static int getNumber1Times2(String num) {
        if (num == null || num.length() == 0) return 0;
        char firstChar = num.charAt(0);
        String apartFirstString = num.substring(1);

        int countFirst1 = 0;
        if (firstChar > '1') {
            countFirst1 = power10(num.length() - 1);
        } else {
            countFirst1 = Integer.parseInt(apartFirstString) + 1;
        }
        int countOthers = (firstChar - '0') * power10(num.length() - 2) * (num.length() - 1);

        return countFirst1 + countOthers + numberOf1Between1AndN(Integer.parseInt(apartFirstString));
    }

    private static int power10(int n) {
        int result = 1;
        for (int i = 0; i < n; i++)
            result *= 10;
        return result;
    }

    public static int numberOf1Between1AndN(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n < 10) {
            return 1;
        }
        String strN = n + "";
        return getNumber1Times2(strN);
    }
}
