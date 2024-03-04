package zhangqs.utils;

/**
 * 数组工具类
 */
public class ArrayUtils {

    // 返回一个 int类型的长度为10的随机数组
    public static int[] getRandomArray() {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        return array;
    }
}
