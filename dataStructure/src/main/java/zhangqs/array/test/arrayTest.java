package zhangqs.array.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zhangqs.array.array;

import java.util.ArrayList;
import java.util.LinkedList;

public class arrayTest {
    private final Logger logger = LoggerFactory.getLogger(arrayTest.class);

    @Test
    public void test(){
        array array = new array(10);
        //logger.info(String.valueOf(array.size));
        // 新增 在数组的尾部添加数据
        array.add(0);
        array.add(1);
        array.add(2);
        array.add(3);
        // 获取对应index的 元素值
        Object o = array.get(2);
        // 新增 在指定的位置插入元素
        array.add(1,5);
        logger.info(JSON.toJSONString(array));
        logger.info(JSON.toJSONString(array.size()));
        array.delete(1);
        logger.info(JSON.toJSONString(array));
    }

}