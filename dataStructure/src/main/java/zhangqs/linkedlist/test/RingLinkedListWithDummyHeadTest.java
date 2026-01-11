package zhangqs.linkedlist.test;

import zhangqs.linkedlist.RingLinkedListWithDummyHead;

public class RingLinkedListWithDummyHeadTest {

    public static void main(String[] args) {
        RingLinkedListWithDummyHead ringLinkedListWithDummyHead = new RingLinkedListWithDummyHead();
        ringLinkedListWithDummyHead.add(1);
        ringLinkedListWithDummyHead.add(2);
        ringLinkedListWithDummyHead.add(3);
        ringLinkedListWithDummyHead.add(4);

        Integer data = ringLinkedListWithDummyHead.get(1);
        System.out.println(ringLinkedListWithDummyHead);
        System.out.println(ringLinkedListWithDummyHead.getSize());
        ringLinkedListWithDummyHead.delete(3);
        System.out.println(ringLinkedListWithDummyHead);
        System.out.println(ringLinkedListWithDummyHead.getSize());
    }
}
