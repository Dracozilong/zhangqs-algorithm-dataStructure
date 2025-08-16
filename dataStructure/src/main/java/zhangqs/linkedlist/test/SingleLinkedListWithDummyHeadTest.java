package zhangqs.linkedlist.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zhangqs.linkedlist.SingleLinkedListWithDummyHead;

public class SingleLinkedListWithDummyHeadTest {

    private final Logger logger = LoggerFactory.getLogger(SingleLinkedListWithDummyHeadTest.class);

    @Test
    public void test(){
        SingleLinkedListWithDummyHead singleLinkedListWithDummyHead = new SingleLinkedListWithDummyHead();
        singleLinkedListWithDummyHead.prepend(0);
        singleLinkedListWithDummyHead.addLast(1);
        singleLinkedListWithDummyHead.prepend(-1);
        singleLinkedListWithDummyHead.add(1,3);
//        singleLinkedListWithDummyHead.delete(1);
        singleLinkedListWithDummyHead.deleteByValue(0);
        System.out.println(singleLinkedListWithDummyHead);
    }
}