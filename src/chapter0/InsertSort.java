package chapter0;

/**
 * 插入排序
 */
public class InsertSort {

    /**
     * 希尔排序
     * 希尔排序需要定义一个步长
     */
    public static void shellSort(int[] arr) {
        int length = arr.length;
        //这里就是简单的定义步长为长度的一般
        int gap = length / 2;
        int j = 0;
        int temp = 0;
        //当步长大于等于1时
        while (gap >= 1) {
            //从这个步长开始遍历。因为后面会减去步长，所以其实等于从0开始遍历
            for (int i = gap; i < length; i++) {
                // 得到当前的值
                temp = arr[i];
                // 得到上一个这个步长位置上的值
                j = i - gap;

                while (j >= 0 && arr[j] > temp) {
                    //往右便宜步长个单位
                    arr[j + gap] = arr[j];
                    //index往前移动
                    j = j - gap;
                }
                //再将index移动回来
                arr[j + gap] = temp;
            }
            //不断的缩小步长
            gap = gap / 2;
        }
    }
}
