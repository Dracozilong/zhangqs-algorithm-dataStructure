package zhangqs.linkedlist;

import lombok.Getter;

/**
 * 环形链表 使用虚拟头节点
 */
public class RingLinkedListWithDummyHead {

    private Node head;

    @Getter
    private int size = 0;

    // 虚拟头节点 在参与计算逻辑的时候 head = dummyHead.next
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

        size++;
    }

    // 获取指定位置的元素
    // 链表本身 get的 意义不是很大， 需要get 的原因是为了方便测试 或者是教学
    public Integer get(int index){
        // 判断 index 是否合法
        if (index < 0 || index >= size) {
            return null;
        }
        // index 就是人为的给你的链表加上下标
        Node curr = head.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    /**
     * 按位置删除指定元素
     * @param index
     */
    public void delete(int index){
        // 判断该 index是否合法
        if (index < 0  || index > size -1){
            throw new IllegalArgumentException(" index out of range");
        }
        // NULL -> 1->2->3->4
        Node pre = head;
        Node curr = pre.next;
        for (int i = 0; i < index ; i++) {
            pre = curr;
            curr = curr.next;
        }
        pre.next = curr.next;
        size --;
    }

    /**
     * 获取长度
     * @return
     */
    public Integer getSize(){
        return size;
    }


    @Override
    public String toString() {

        if (size == 0) {
            return "(环形: 空)";
        }

        StringBuilder builder = new StringBuilder();
        Node curr = head.next;


        // 添加环形标识
        builder.append("(环形: ");
        builder.append(curr.data);

        curr = curr.next;
        // curr.next!=head  是判断当前节点是否是尾节点， curr !=head 是判断当前节点是否是虚拟头节点,用来遍历当前链表
        while (curr != head) {
            builder.append("->").append(curr.data);
            curr = curr.next;
        }

        // 显示回到起点的连接
        builder.append("->").append(head.next.data).append(")");
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
