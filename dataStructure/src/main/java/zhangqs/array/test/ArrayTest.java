package zhangqs.array.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zhangqs.array.Array;



public class ArrayTest {
    private final Logger logger = LoggerFactory.getLogger(ArrayTest.class);

    @Test
    public void test() {
        Array array = new Array(5);
        //logger.info(String.valueOf(array.size));
        // 新增 在数组的尾部添加数据
        array.add(0);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.addFirst(-1);
        array.addLast(6);

        // 获取对应index的 元素值
        logger.info("第一个元素为=>{}", JSON.toJSONString(array.get(0)));
        System.out.println(array);

    }
}