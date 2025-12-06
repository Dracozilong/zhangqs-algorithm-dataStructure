package zhangqs.linkedlist;

/**
 * 环形链表
 */
public class RingLinkedList {

    private Node head;

    // 虚拟头节点
    public RingLinkedList() {
        this.head = new Node(null);
    }

    // 循环链表 头插入法
    // 先找到尾节点 → 让尾节点的 next 指向新节点 → 再让新节点 next 指向原 head → 最后更新 head 指向新节点


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
