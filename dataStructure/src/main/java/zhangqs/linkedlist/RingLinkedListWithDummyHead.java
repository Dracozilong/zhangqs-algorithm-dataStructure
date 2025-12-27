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

    @Override
    public String toString() {
        if (head == null) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        Node curr = head;

        // 添加环形标识
        builder.append("(环形: ");
        builder.append(curr.data);

        curr = curr.next;
        while (curr != head) {
            builder.append("->").append(curr.data);
            curr = curr.next;
        }

        // 显示回到起点的连接
        builder.append("->").append(head.data).append(")");
        return builder.toString();
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
