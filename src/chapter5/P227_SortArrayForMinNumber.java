package chapter5;

/**
 * 把数组排列成最小的数
 * <p>
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，使其为所有可能的拼接结果中最小的一个。
 * 例如输入{3,32,321}，则输入321323。
 * <p>
 * 解题思路：
 * 主要就是数组排序。排出最小的序。
 * <p>
 * 此题需要对数组进行排序，关键点在于排序的规则需要重新定义。我们重新定义“大于”，“小于”，“等于”。如果a，b组成的数字ab的值大于ba，则称a"大于"b，小于与等于类似。比如3与32，因为332大于323，因此我们称3“大于”32。我们按照上述的“大于”，“小于”规则进行升序排列，即可得到题目要求的答案。
 */
public class P227_SortArrayForMinNumber {
    public static String sortForMinNumber(int[] arr) {
        //快速排序
        quickSort(arr, 0, arr.length - 1);


        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            result.append(String.valueOf(arr[i]));
        }
        return result.toString();
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int left = start;
        int right = end;
        int base = arr[left];

        while (left < right) {
            if (left < right && compareArr(arr[right], base) > 0) {
                right--;
            }

            if (left < right) {
                arr[left] = arr[right];
                left++;
            }

            if (left < right && compareArr(base, arr[left]) > 0) {
                left++;
            }

            if (left < right) {
                arr[right] = arr[left];
                right--;
            }
        }
        arr[left] = base;

        quickSort(arr, start, left - 1);
        quickSort(arr, left + 1, end);
    }

    private static int compareArr(int num1, int num2) {
        String str1 = String.valueOf(num1);
        String str2 = String.valueOf(num2);

        String str12 = str1 + str2;
        String str21 = str2 + str1;

        for (int i = 0; i < str21.length(); i++) {
            int i1 = str12.charAt(i) - str21.charAt(i);
            if (i1 == 0) {
                continue;
            } else {
                return i1;
            }
        }
        return 0;
    }

}
