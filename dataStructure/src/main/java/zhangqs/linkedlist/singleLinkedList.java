package zhangqs.linkedlist;

// 实现一个单项链表
public class singleLinkedList {

    //定一个头节点
    private Node head;

    // 单项链表的长度大小
    private int size;

    //对 单项链表进行初始化
    public singleLinkedList(Node head) {
        this.head = head;
    }

    public singleLinkedList (int data){
        this.head = new Node(data);
    }

    /**
     *  尾插法 在链表的尾部插入节点,传入Node节点
     * @param node
     */
    public void add(Node node){
        // 需要一个 temp节点，赋值头节点
        Node temp = head;
        // 需要找到最后的一个节点
        while (temp.next!=null){
            temp =temp.next;
        }
        // 退出while 循环以后 说明当前temp 代表temp是链表的最后一个节点 把当前入参 Node 节点 赋值给最后一个节点的next域
        temp.next = node;
        size++;
    }

    /**
     * 尾插法  在链表的尾部插入节点，传入Node节点需要的值
     * @param value
     */
    public void add(int value){
        Node node = new Node(value);

        Node temp = head;
        while (temp.next!=null){
            temp =temp.next;
        }
        // 退出while 循环以后 说明当前temp 代表temp是链表的最后一个节点 把当前入参 Node 节点 赋值给最后一个节点的next域
        temp.next = node;
        size++;
    }


    //创建一个静态的内部类 Node节点
    private static class Node {
        public int data;

        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}