package zhangqs.linkedlist;

// 实现一个单项链表
public class SingleLinkedList {

    //定一个头节点
    private Node head;

    // 单项链表的长度大小
    private int size;

    //对 单项链表进行初始化 在构造函数 定一个null 的头节点
    public SingleLinkedList() {
        this.head = null;
    }

    /**
     * 尾插法  在链表的尾部插入节点，传入Node节点需要的值
     * @param value
     */
    public void add(int value){
        Node node = new Node(value);
        // 判断头节点 是否为 null
        if (head ==null){
            head =node;
        }else {
            Node temp = head;
            while (temp.next!=null){
                temp =temp.next;
            }
            // 退出while 循环以后 说明当前temp 代表temp是链表的最后一个节点 把当前入参 Node 节点 赋值给最后一个节点的next域
            temp.next = node;
        }
        size++;
    }

    public void preAdd(int value){
        Node newHead = new Node(value);
        // 当前最新的Head的next 指向旧的next节点
        newHead.next =head;
        head = newHead;
        size++;
    }

    @Override
    public String toString() {
        return "SingleLinkedList{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }

    //创建一个私有的内部类 Node节点
    private class Node {
        public int data;

        public Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node() {
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }
}