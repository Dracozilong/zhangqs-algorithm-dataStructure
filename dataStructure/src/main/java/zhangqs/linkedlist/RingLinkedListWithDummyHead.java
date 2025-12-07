package zhangqs.linkedlist;

/**
 * 环形链表 使用虚拟头节点
 */
public class RingLinkedListWithDummyHead {


    private Node head;

    // 虚拟头节点
    public RingLinkedListWithDummyHead() {
        this.head = new Node(null);
        // 初始化时让虚拟头节点指向自己，形成空的环
        this.head.next = this.head;
    }

    public void add(Integer data) {
        if (data == null) {
            return;
        }

        // 创建一个新节点
        Node newNode = new Node(data);

        // 找到尾节点（指向head的节点）
        Node tail = head;
        while (tail.next != head) {
            tail = tail.next;
        }

        // 在尾部插入新节点
        tail.next = newNode;
        newNode.next = head;
    }


    // 定义一个Node节点
    private class Node {
        Integer data;
        Node next;

        public Node() {
        }

        public Node(Integer data) {
            this.data = data;
        }
    }
}
