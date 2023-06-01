package class04_listnode;

import java.time.DayOfWeek;

public class ReverseDoubleLinkedList {
    public static class DoubleNode {
        int value;
        DoubleNode last;
        DoubleNode next;

        DoubleNode() {}
        DoubleNode(int value) {this.value = value;}
        //DoubleNode(int value, DoubleNode last, DoubleNode next) {this.value = value; this.last = last; this.next = next;}
    }

    public static void main(String[] args) {
        DoubleNode n0 = new DoubleNode(0);
        DoubleNode n1 = new DoubleNode(1);
        DoubleNode n2 = new DoubleNode(2);
        DoubleNode n3 = new DoubleNode(3);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = null;
        n0.last = null;
        n1.last = n0;
        n2.last = n1;
        n3.last = n2;

        DoubleNode head = n0;

        DoubleNode node = RevDouLinkedList(head);
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }

    public static DoubleNode RevDouLinkedList(DoubleNode head) {
        DoubleNode next = null, last = null;
        while (head != null) {
            next = head.next;
            last = head.last;
            head.last = next;
            head.next = last;
            head = head.last;
        }
        return last.last;
    }
}
