package zhangqs.linkedlist.test;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zhangqs.linkedlist.SingleLinkedList;

import java.util.ArrayList;

public class SingleLinkedListTest {

  private final Logger logger = LoggerFactory.getLogger(SingleLinkedListTest.class);

  @Test
  public void test(){
    SingleLinkedList singleLinkedList = new SingleLinkedList();
    singleLinkedList.add(1);
    singleLinkedList.add(2);
    singleLinkedList.add(3);
    singleLinkedList.add(4);
    singleLinkedList.add(1,5);
    System.out.println(singleLinkedList);
  }

}
