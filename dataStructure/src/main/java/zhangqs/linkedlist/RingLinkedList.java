package zhangqs.linkedlist;

/**
 * 环形链表
 */
public class RingLinkedList {

    private Node head;

    // 虚拟头节点
    public RingLinkedList() {
        this.head = null;
    }

    // 循环链表 头尾区别不大  不用区分 头插 还是尾插
    // 先找到尾节点 → 让尾节点的 next 指向新节点 → 再让新节点 next 指向原 head → 最后更新 head 指向新节点

    public void add(Integer data) {
        if (data == null) {
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
