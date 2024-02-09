class Node {
    public int data;
    public Node next;

    Node() {
        this.data = 0;
        this.next = null;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class MergeTwoLists {
    public static Node mergeTwoLists(Node l1, Node l2) {
        Node dummyNode = new Node(-1);
        Node head = dummyNode;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                dummyNode.next = l1;
                dummyNode = dummyNode.next;
                l1 = l1.next;
            } else {
                dummyNode.next = l2;
                dummyNode = dummyNode.next;
                l2 = l2.next;
            }
        }

        // Add remaining nodes from l1 or l2 if any
        while (l1 != null) {
            dummyNode.next = l1;
            dummyNode = dummyNode.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            dummyNode.next = l2;
            dummyNode = dummyNode.next;
            l2 = l2.next;
        }

        head = head.next; // Move head to the actual starting node
        return head;
    }
}
