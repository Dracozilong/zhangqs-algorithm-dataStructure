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

    // 循环链表 头尾区别不大  不用区分 头插 还是尾插
    // 先找到尾节点 → 让尾节点的 next 指向新节点 → 再让新节点 next 指向原 head → 最后更新 head 指向新节点

    public void add(Integer data) {
        if (data == null) {
            return;
        }
        // 创建一个新节点
        Node newNode = new Node(data);

        // 当前 没有节点
        if (head.next ==null){
            // 当前创建的节点 作为第一个节点
            head.next = newNode;
            // 指向 自己
            newNode.next = newNode;
        }else {
            // 找到尾节点sss
            Node curr = head.next;
            while (curr.next != head.next) {
                curr = curr.next;
            }
            // 赋值 尾节点的 next
            curr.next = newNode;
            newNode.next = head.next;
        }
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
