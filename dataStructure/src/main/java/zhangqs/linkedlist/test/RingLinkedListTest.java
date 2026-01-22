package zhangqs.linkedlist.test;

import zhangqs.linkedlist.RingLinkedList;

/**
 * 环形链表 测试
 */
public class RingLinkedListTest {

    public static void main(String[] args) {
        RingLinkedList ringLinkedList = new RingLinkedList();

        ringLinkedList.add(1);
        ringLinkedList.add(2);
        ringLinkedList.add(3);
        ringLinkedList.add(4);
        ringLinkedList.add(5);

        Integer size = ringLinkedList.getSize();

        System.out.println(size);

        System.out.println(ringLinkedList);

        ringLinkedList.add(3,-4);

        System.out.println(ringLinkedList);

    }


}
