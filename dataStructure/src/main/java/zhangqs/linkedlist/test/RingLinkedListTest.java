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

        Integer size = ringLinkedList.getSize();

        System.out.println(size);

        System.out.println(ringLinkedList);

        ringLinkedList.delete(0);

        System.out.println(ringLinkedList);

        System.out.println(ringLinkedList.getSize());

    }


}
