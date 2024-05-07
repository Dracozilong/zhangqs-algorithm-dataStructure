package zhangqs.sort.inserSort;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import zhangqs.utils.ArrayUtils;

/**
 *  插入排序
 */
@Slf4j
public class InsertSort {

    // 思路分析
    // 1. 从第一个元素开始，假设该元素已经被排序，获取第二个元素，如果第二个元素比第一个元素小 ，交换排序，使 arr[0,i)区间变的有序
    // 2. 获取第i个元素,与之前arr[0,i)中的每个元素进行比较,当arr[i]比arr[0,i)中某个元素小时，交换。
    // 3. 重复步骤2，直到i等于数组长度

    public static void main(String[] args) {
        int[] randomArray = ArrayUtils.getRandomArray();
        insertSort(randomArray);
    }

    public static void insertSort(int[] arr ){
        log.info("插入排序前的数据为=>{}", JSON.toJSONString(arr));
        for (int i = 1; i < arr.length; i++) {
            for (int j = i ; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        log.info("插入排序后的数据为=>{}", JSON.toJSONString(arr));
    }
}