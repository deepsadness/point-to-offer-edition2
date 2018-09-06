package chapter7;

/**
 * 扑克牌中的顺子
 * <p>
 * 抽取5张牌，判断是不是一个顺子。2-10为数字本身，A为1，J为11，Q为12，K为13，大小王可堪称任意数字。
 * <p>
 * 关键：
 * 1.大王当作0，可以做任何数
 * 3. 有2 就不是顺子
 * 3. 有1 就一定不能有非0的10一下的数字
 */
public class P298_ContinousCards {
    public static boolean isSunzi(int[] arr) {
        if (arr == null || arr.length != 5)
            return false;
        //排序
        shellSort(arr);
        //有序顺序.大王小王有4张
        int count0 = 0;
        while (arr[count0] == 0) {
            count0++;
        }

        int temp = arr[count0];
        //记录上一次的数字
        int last = temp;
        //排序之后，如果temp不是1，则没有1了
        boolean hasA = temp == 1;
        for (int i = count0 + 1; i < arr.length; i++) {
            //不能有相同的牌
            if ((temp = temp ^ arr[i]) == 0) {
                return false;
            }
            //不能有2
            if (arr[i] == 2) {
                return false;
            }
            if (hasA && arr[i] < 10) {
                return false;
            }

            if ((arr[i] - last == 1) || (last == 1 && arr[i] - last >= 9)) {   //这种情况是标准的顺子
                last = arr[i];
            } else { //不是的话，算一下相差的值
                if (arr[i] - last > count0 + 1) { //这种情况下，直接没救了
                    return false;
                } else {
                    int offset = arr[i] - last - 1;
                    count0 = count0 - offset; //扣去弥补的值
                    last = arr[i];
                }
            }

        }
        //最后活下来的，就是顺子
        return true;
    }

    private static void shellSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int length = arr.length;
        int gap = length / 2;
        while (gap >= 1) {
            for (int i = gap; i < length; i++) {
                int temp = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + gap] = arr[j];
                    j = j - gap;
                }
                arr[j + gap] = temp;
            }
            gap = gap / 2;
        }


    }

    //不排序
    public static boolean isSunzi2(int[] arr) {
        if (arr == null || arr.length != 5)
            return false;
        int[] temp = new int[14];
        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];
            if (i1 > 0 && temp[i1] != 0) {
                return false;
            }
            temp[i1]++;
        }

        int count0 = temp[0];
        int last = 0;
        for (int i = 1; i < temp.length; i++) {
            int value = temp[i];
            if (value != 0) {
                if (last != 0) {
                    int offset = i - last;
                    if ((last != 1 && offset > 1 + count0) || (last == 1 && offset < 9)) {
                        return false;
                    } else if (last != 1) {
                        count0 = count0 - (offset - 1);
                    }
                }
                last = i;
            }
        }
        //最后活下来的，就是顺子
        return true;
    }

}
