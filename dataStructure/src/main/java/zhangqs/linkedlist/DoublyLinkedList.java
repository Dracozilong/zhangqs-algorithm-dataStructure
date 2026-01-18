package zhangqs.linkedlist;

/**
 * 双向链表 非虚拟头节点
 */
public class DoublyLinkedList {

    // 双向链表支持 正向或者反向遍历,这是和单向链表很大的区别!!!!

    public Node head;

    public int size;

    public DoublyLinkedList() {
        this.head = null;
    }

    /**
     * 新增节点 尾插
     * @param data
     */
    public void  add(int data) {

        // 新增节点
        Node doublyNode = new Node(data);

        // 如果当前链表为空
        if (null == head){
            head = doublyNode;
        }else {
           Node temp = head;
           // 找到最后一个尾节点
           while (temp.next != null){
               temp =temp.next;
           }
           temp.next = doublyNode;
        }
        size++;
    }



    /**
     * 记录了前驱 和后驱的 节点 占用内存空间更多
      */
    public static class Node{
        /**
         * 值
         */
        int data;
        /**
         * 下一个节点
         */
        Node next;

        /**
         * 前一个节点
         */
        Node pre;

        public Node() {
        }

        public Node(int data){
            this.data= data;
        }
    }


}
