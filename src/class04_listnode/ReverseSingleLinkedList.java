package class04_listnode;

class Node {
    public int value;
    public Node next;
    // value和next是Node的两个属性
    public Node() {}
    public Node(int value) { this.value = value; }
    public Node(int value, Node next) { this.value = value; this.next = next; }
}


public class ReverseSingleLinkedList {
    public static void main(String[] args) {
        Node node = new Node(1,new Node(2, new Node(3, new Node((4)))));
        //LookList(node);
        LookList(ReverseList(node));
    }
    public static Node ReverseList(Node head) {
        Node next = null;
        Node pre = null;
        while (head != null) {
            //链表反转：先记住当前（head）节点的下一个节点（在这里命名为next）
            //双链表反转：先记住当前（head）节点的下一个节点（在这里命名为next）
            next = head.next;
            //链表反转：将当前节点的下一个指针更改为前一个
            //双链表反转：前一个和后一个的指针都更改
            head.next = pre;
            //更新节点位置
            pre = head;
            head = next;
        }
        //返回更新后的头结点pre
        return pre;

    }
    public static void LookList (Node node) {
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }
}
