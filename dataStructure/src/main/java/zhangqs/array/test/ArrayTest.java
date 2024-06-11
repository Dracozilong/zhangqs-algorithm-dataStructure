package zhangqs.array.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zhangqs.array.Array;

import java.util.ArrayList;
import java.util.HashMap;


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
        // 获取对应index的 元素值
        Object o = array.get(2);
        // 新增 在指定的位置插入元素
        logger.info(JSON.toJSONString(o));
        logger.info(JSON.toJSONString(array));
        logger.info(JSON.toJSONString(array.size()));
        Object o1 = array.delete(0);
        array.delete(1);
        array.delete(2);
        ArrayList<Object> objects = new ArrayList<>();
        logger.info(JSON.toJSONString(array.getCapacity()));
        System.out.println(o1);

    }
}