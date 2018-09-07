package chapter7;

/**
 * 不使用新的变量完成交换两个原有变量的值
 */
public class P312_ExchangeTwoNumbers {
    public static void exchange(int a, int b) {
        System.out.println("origin a=" + a + " , b=" + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("exchange a=" + a + " , b=" + b);
    }

    public static void exchange2(int a, int b) {
        System.out.println("origin a=" + a + " , b=" + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("exchange a=" + a + " , b=" + b);
    }
}
