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
//    singleLinkedList.prepend(2);
    singleLinkedList.add(2);
    singleLinkedList.add(3);
    singleLinkedList.add(4);
    singleLinkedList.add(5);
    System.out.println(singleLinkedList);
    logger.info("singleLinkedList 为 =>{}", JSON.toJSONString(singleLinkedList));
  }
}