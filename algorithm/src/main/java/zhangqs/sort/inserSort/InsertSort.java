package zhangqs.sort.inserSort;

/**
 *  插入排序
 */
public class InsertSort {

    // 思路分析
    // 1. 从第一个元素开始，假设该元素已经被排序，获取第二个元素，如果第二个元素比第一个元素小 ，交换排序，使 arr[0,i)区间变的有序
    // 2. 获取第i个元素,与之前arr[0,i)中的每个元素进行比较,当arr[i]比arr[0,i)中某个元素小时，交换。
    // 3. 重复步骤2，直到i等于数组长度

    public static void insertSort(int[] arr ){
        // 定一个 长度和 传入数组大小相等的数组
        int[] resultArray =new int[arr.length];
//        // 默认 第一个元素已经被排序
//        resultArray[0] = arr[0];
        // 传入的数组从第二个开始遍历
        for (int i = 0; i < arr.length; i++) {
            // 假设第一个元素已经被排序，获取第二个元素
            int currentValue = arr[i];

            for (int j = i+1; j > 0 ; j--) {
                // 找寻当前resultArray[0,j)中比currentValue大的元素，交换位置
                if(resultArray[j] > currentValue){

                }
            }
        }
    }
}