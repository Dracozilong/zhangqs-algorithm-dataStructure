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
        singleLinkedListWithDummyHead.addLast(1);
        singleLinkedListWithDummyHead.addLast(2);
        singleLinkedListWithDummyHead.addLast(3);
        singleLinkedListWithDummyHead.addLast(4);

        singleLinkedListWithDummyHead.add(4,5);
        System.out.println(singleLinkedListWithDummyHead);
    }
}