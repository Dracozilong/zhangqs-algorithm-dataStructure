package zhangqs.linkedlist;

import cn.hutool.core.util.ObjectUtil;
import lombok.Getter;

/**
 * 环形链表
 */
public class RingLinkedList {

    private Node head;

    @Getter
    private int size = 0;

    // 虚拟头节点
    public RingLinkedList() {
        this.head = null;
    }

    // 循环链表 头尾区别不大  不用区分 头插 还是尾插
    // 先找到尾节点 → 让尾节点的 next 指向新节点 → 再让新节点 next 指向原 head → 最后更新 head 指向新节点
    // 复杂度分析: 循环链表 新增值 无论是指定位置新增 还是在首尾新增 都需要找到需要插入节点的前一个节点,遍历链表的时间复杂度 O(n)
    //           单纯的插入操作 时间复杂度是O(1)

    public void add(int data) {
        if (ObjectUtil.isNull(data)) {
            return;
        }

        // 创建一个新节点
        Node newNode = new Node(data);

        // 当前 没有节点
        if (head == null){
            // 当前创建的节点 作为第一个节点
            head = newNode;
            // 指向 自己
            newNode.next = head;
        }else {
            // 找到尾节点
            Node curr = head;
            while (curr.next != head) {
                curr = curr.next;
            }
            // 赋值 尾节点的 next
            curr.next = newNode;
            newNode.next = head;
        }

        size++;
    }

    /**
     * 在指定位置插入元素
     * @param index
     * @param value
     */
    public void add(int index,int value ){
        // 1. 校验需要插入的位置是否存在
        rangeCheckForAdd(index);
        // 2. 判断头节点是否为 null
        Node node = new Node(value);
        if (head ==null){
            // 当前创建的节点 作为第一个节点
            head = node;
            // 指向 自己
            node.next = head;
            return;
        }

        if (index == 0){
            // 找到尾节点
            Node curr = head;
            while (curr.next!= head){
                curr = curr.next;
            }
            // 重新赋值头节点
            node.next = curr.next;
            curr.next = node;
            head = node;
            size++;
        } else {
            Node curr = head;
            for (int i = 0; i < index-1; i++) {
                curr =curr.next;
            }
            node.next = curr.next;
            curr.next = node;
            size++;
        }
    }

    // 获取指定位置的元素
    // 链表本身 get的 意义不是很大， 需要get 的原因是为了方便测试 或者是教学
    public Integer get(Integer index){
        // 判断 index 是否合法
        if (index < 0 || index >= size) {
            return null;
        }
        // index 就是人为的给你的链表加上下标
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    /**
     * 按照 位置删除节点
     * @param index
     */
    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index out of range");
        }

        // 判断是否为空
        if (head == null) {
            return;
        }

        // 删除头节点 头节点本身既是数据 又是头节点
        if (index == 0) {
            if (size == 1) {
                head = null;
            } else {
                Node tail = head;
                while (tail.next != head) {
                    tail = tail.next;
                }
                tail.next = head.next;
                head = head.next;
            }
            size--;
            return;
        }

        // 删除非头节点
        Node pre = head;
        Node curr = head.next;

        for (int i = 1; i < index; i++) {
            pre = curr;
            curr = curr.next;
        }

        pre.next = curr.next;
        size--;
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

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
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
