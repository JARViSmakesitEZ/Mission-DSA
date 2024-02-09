class Node {
    public int data;
    public Node prev;
    public Node next;

    Node() {
        this.data = 0;
        this.prev = null;
        this.next = null;
    }

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    Node(int data, Node prev, Node next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}

public class ReverseDll {
    public static Node reverse_Dll(Node head) {
        Node newHead = null; // Initialize newHead to null
        Node dummyNode = head; // Corrected declaration of dummyNode

        while (dummyNode != null) {
            Node temp = dummyNode.next;
            dummyNode.next = dummyNode.prev;
            dummyNode.prev = temp;

            // Update newHead to the current node (last node after reversal)
            newHead = dummyNode;

            // Move to the next node
            dummyNode = temp;
        }

        // Return the newHead which is the new starting node after reversal
        return newHead;
    }
}
