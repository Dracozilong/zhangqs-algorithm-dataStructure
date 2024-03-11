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

    /**
     *
     *  选择排序 泛型优化
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void selectSortPatten(E[] arr){
        log.info("范型 未排序前的数组为 ->{}", JSON.toJSONString(arr));
        for (int i = 0; i < arr.length; i++) {
            E mixNum = arr[i];
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(mixNum) < 0){
                    mixNum = arr[j];
                    arr[j] = arr[i];
                    arr[i] = mixNum;
                    mixNum = arr[i];
                }
            }
        }
        log.info("范型 选择排序后的数组为 ->{}",JSON.toJSONString(arr));
    }





    public static void main(String[] args) {
        int[] randomArray = ArrayUtils.getRandomArray();
//        SelectSort.selectSort(randomArray);
        SelectSort.selectSortPatten(Arrays.stream(randomArray).boxed().toArray(Integer[]::new));
    }
}
