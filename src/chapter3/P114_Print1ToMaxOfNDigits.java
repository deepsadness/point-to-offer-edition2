package chapter3;

import java.util.Arrays;
import java.util.Objects;

/**
 * 打印从1到最大的n位数
 * 题目要求：
 * 比如输入2，打印1,2......98,99；
 * <p>
 * 考虑大数问题的陷阱。integer.MAX位的数字已经超过了Integer.Max
 */
public class P114_Print1ToMaxOfNDigits {

    /**
     * 使用模拟的逻辑加法运算
     */
    public static class DigitNumber {
        private int digits;
        private char[] buffer;

        public static DigitNumber min() {
            DigitNumber digitNumber = new DigitNumber();
            digitNumber.digits = 1;
            digitNumber.buffer = new char[1];
            digitNumber.buffer[0] = '1';
            return digitNumber;
        }

        public static DigitNumber max(int digits) {
            if (digits < 1) {
                return null;
            }
            DigitNumber digitNumber = new DigitNumber();
            digitNumber.digits = digits;
            digitNumber.buffer = new char[digits];
            for (int i = 0; i < digits; i++) {
                digitNumber.buffer[i] = '9';
            }
            return digitNumber;
        }

        public static DigitNumber justChar(char[] value) {
            if (value == null || value.length == 0) {
                return null;
            }

            for (int i = 0; i < value.length; i++) {
                char curValue = value[i];
                if (curValue < '0' || curValue > '9') {
                    return null;
                }
            }
            DigitNumber digitNumber = new DigitNumber();
            int length = value.length;
            char first = value[0];
            digitNumber.digits = (first >= '0' && first <= '9') ? length : length - 1;
            digitNumber.buffer = value;
            return digitNumber;
        }

        public static DigitNumber just(String value) {
            if (value == null) {
                return null;
            }
            char[] chars = value.toCharArray();
            return DigitNumber.justChar(chars);
        }

        public DigitNumber increase() {
            char[] tempBuffer = new char[digits + 1];
            int curIndex = 0;
            boolean overflow = true;
            while (curIndex < digits) {
                char curValue = this.buffer[digits - 1 - curIndex];
                if (overflow) {
                    if (curValue == '9') {
                        tempBuffer[digits - curIndex] = '0';
                        overflow = true;
                    } else {
                        tempBuffer[digits - curIndex] = (char) (curValue + 1);
                        overflow = false;
                    }
                } else {
                    tempBuffer[digits - curIndex] = curValue;
                }
                curIndex++;
            }
            int offset = 1;
            int count = digits;
            if (overflow) {
                offset--;
                count++;
                tempBuffer[0] = '1';
            }
            return DigitNumber.just(String.valueOf(tempBuffer, offset, count));
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(digits);
            int start = 0;
            if (buffer.length > digits) {
                start++;
            }
            for (int i = start; i < digits; i++) {
                stringBuilder.append(buffer[i]);
            }
            return stringBuilder.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DigitNumber that = (DigitNumber) o;
            return digits == that.digits &&
                    Arrays.equals(buffer, that.buffer);
        }

        @Override
        public int hashCode() {

            int result = Objects.hash(digits);
            result = 31 * result + Arrays.hashCode(buffer);
            return result;
        }
    }

    public static String printMaxOfNDigits(int digits) {
        if (digits < 1) {
            return "";
        }
        DigitNumber max = DigitNumber.max(digits);
        DigitNumber temp = DigitNumber.min();
        StringBuilder stringBuilder = new StringBuilder();

        //调用equals方法实际上会遍历比较。时间复杂为n,如果用长度来比较的话，就比较好。因为再进位，长度就会增加
        while (temp.digits <= max.digits) {
            stringBuilder.append(temp.toString()).append(",");
            temp = temp.increase();
        }

        return stringBuilder.toString();
    }


    public static String printMaxOfNDigits2(int digits) {
        return "";
    }



}
