package zhangqs.sort.selectSort;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import zhangqs.utils.ArrayUtils;

import java.util.Arrays;


/**
 *  选择排序
 */
@Slf4j
public class SelectSort {

    //思路分析
     // 1.生成一个长度为10的随机数组
     // 2.遍历数组，找到最小的元素，然后与第一个位置交换，接着从剩余长度的数组中找到最小的元素，与第二个位置交换
     // 3.重复2，直到排序完成


    private SelectSort() {
    }

    /**
     * 选择排序
     * @param arr
     */
    public static void  selectSort(int[] arr){
        log.info("未排序前的数组为 ->{}", JSON.toJSONString(arr));
        for (int i = 0; i < arr.length; i++) {
            // 定义一个 变量记录当前位置的值
            int targetNum = arr[i];
            // 遍历当前数组 找到值最小的数的索引
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < targetNum){
                    arr[i] = arr[j];
                    arr[j] = targetNum;
                    targetNum = arr[i];
                }
            }
        }
     log.info("选择排序后的数组为 ->{}",JSON.toJSONString(arr));
    }

    /** 优化的点 : 没有必要单独的用一个变量记录 当前循环的最小值 只记录当前位置的索引即可  数组查找值通过下标就可以
     *            交换值的方法可以写成公共的方法
     *  选择排序 泛型优化
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void selectSortPatten(E[] arr){
        log.info("范型 未排序前的数组为 ->{}", JSON.toJSONString(arr));
        for (int i = 0; i < arr.length; i++) {
            int minxIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minxIndex]) < 0){
                        minxIndex = j;
                  // 交换值的方法
                  swap(arr,i,minxIndex);
                }
            }
        }
        log.info("范型 选择排序后的数组为 ->{}",JSON.toJSONString(arr));
    }

    /**
     * 交换 数组值的方法
     * @param arr
     * @param i
     * @param j
     * @param <E>
     */
    public static <E> void swap(E[]arr,int i,int j){
            E temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] randomArray = ArrayUtils.getRandomArray();
        Integer[] array  ={88,3,54,5,76,24,8,59,71,65};
//        SelectSort.selectSort(randomArray);
        SelectSort.selectSortPatten(array);
    }
}
