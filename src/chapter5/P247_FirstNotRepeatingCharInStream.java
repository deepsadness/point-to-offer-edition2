package chapter5;

/**
 * 字符流中第一个只出现一次的字符
 */
public class P247_FirstNotRepeatingCharInStream {
    interface Stream {
        void addNum(char c);

        char findFirstNotRepeatChar();
    }

    public static class Default implements Stream {
        private int[] times;
        private int index;

        public Default() {
            index = 0;
            times = new int[256];
            //-1表示未出现，>=0表示出现的位置且仅出现一次，-2表示出现两次及以上
            for (int i = 0; i < 256; i++)
                times[i] = -1;
        }

        @Override
        public void addNum(char ch) {
            if (times[ch] == -1)
                times[ch] = index;
            else
                times[ch] = -2;
            index++;
        }

        @Override
        public char findFirstNotRepeatChar() {
            int minIndex = 256;
            char ret = '\77'; //若没有只出现一次的字符，显示\77，即？
            for(int i=0;i<256;i++){
                if(times[i]>=0 && times[i]<minIndex) {
                    minIndex = times[i];
                    ret = (char)i;
                }
            }
            return ret;
        }
    }
}
