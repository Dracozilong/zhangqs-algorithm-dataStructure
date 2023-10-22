package zhangqs.linkedlist.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zhangqs.array.test.arrayTest;
import zhangqs.linkedlist.SingleLinkedList;

public class singleLinkedListTest {

  private final Logger logger = LoggerFactory.getLogger(arrayTest.class);

  @Test
  public void test(){
    SingleLinkedList singleLinkedList = new SingleLinkedList();
    singleLinkedList.add(1);
    System.out.println(singleLinkedList.toString());
    logger.info("singleLinkedList 为 =>{}", JSON.toJSONString(singleLinkedList));
  }
}