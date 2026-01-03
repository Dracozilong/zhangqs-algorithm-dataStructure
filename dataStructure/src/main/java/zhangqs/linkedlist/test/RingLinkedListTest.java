package zhangqs.linkedlist.test;

import zhangqs.linkedlist.RingLinkedList;
import zhangqs.linkedlist.SingleLinkedList;

/**
 * 环形链表 测试
 */
public class RingLinkedListTest {

    public static void main(String[] args) {
        RingLinkedList ringLinkedList = new RingLinkedList();

        ringLinkedList.add(1);
        ringLinkedList.add(2);
        ringLinkedList.add(3);

        System.out.println(ringLinkedList);

        Integer size = ringLinkedList.getSize();

        System.out.println(size);

    }
}
