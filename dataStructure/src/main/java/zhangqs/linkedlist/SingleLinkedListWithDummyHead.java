package zhangqs.linkedlist;

/**
 * 使用虚拟头节点 操作单项链表
 * @author zhangqs
 * @date 2024/08/05 06:54
 */
public class SingleLinkedListWithDummyHead {

    //定一个头节点
    private Node dummyHead;

    // 单项链表的长度大小
    private int size;

    //对 单项链表进行初始化 在构造函数 定一个null 的头节点
    public SingleLinkedListWithDummyHead() {
        this.dummyHead = new Node(null);
    }

    /**
     *  使用 虚拟头节点 进行头插法
     * @param value
     */
    public void prepend(int value){
        Node newNode = new Node(value);
        newNode.next = dummyHead.next; // 虚拟头节点next的指向赋值给新的节点的next指向
        dummyHead.next = newNode; // 虚拟头节点的next 指向 真正的头节点
        size++;
    }

    /**
     * 使用尾插法
     * @param value
     * @author zhangqs
     * @date 2024/08/01 07:19
     */
    public void addLast(int value){
        Node newNode = new Node(value);
        Node tmp = dummyHead;
        while(tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = newNode;
        size++;
    }



    //创建一个私有的内部类 Node节点
    private class Node {
        public Object data;

        public Node next;

        public Node(Object data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }

    @Override
    public String toString() {
        // 从头节点开始遍历这个链表
        // 用一个变量 初始化赋值头节点
        Node curr = dummyHead.next;
        StringBuilder builder = new StringBuilder();
        builder.append(curr.data);
        while (curr.next!=null){
            curr =curr.next;
            builder.append("->").append(curr.data);
        }
        return builder.toString();
    }
}