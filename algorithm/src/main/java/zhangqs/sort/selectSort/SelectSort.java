package zhangqs.sort.selectSort;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import zhangqs.utils.ArrayUtils;


/**
 *  选择排序
 */
@Slf4j
public class SelectSort {

    //思路分析
     // 1.生成一个长度为10的随机数组
     // 2.遍历数组，找到最小的元素，然后与第一个位置交换，接着从剩余长度的数组中找到最小的元素，与第二个位置交换
     // 3.重复2，直到排序完成

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

    public static void main(String[] args) {
        int[] randomArray = ArrayUtils.getRandomArray();
        SelectSort.selectSort(randomArray);
    }
}
