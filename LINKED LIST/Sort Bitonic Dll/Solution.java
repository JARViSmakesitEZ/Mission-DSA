class Node {
    public int data;
    public Node next;
    public Node prev;

    Node() {
        this.data = 0;
        this.next = null;
        this.prev = null;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
        this.prev = null;
    }
}


public class Solution{

    static Node reverse_Dll(Node head) {
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


    static Node Merge2SortedDLL(Node l1,Node l2){
        Node dummyNode = new Node(-1);
        Node head = dummyNode;
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                dummyNode.next = l1;
                l1.prev = dummyNode;
                dummyNode = l1;
                l1 = l1.next;
            } else {
                dummyNode.next = l2;
                l2.prev = dummyNode;
                dummyNode = l2;
                l2 = l2.next;
            }
        }
        // Add remaining nodes from l1 or l2 if any
        while (l1 != null) {
            dummyNode.next = l1;
            l1.prev = dummyNode;
            l1 = l1.next;
            dummyNode = dummyNode.next; // Move dummyNode forward
        }
        while (l2 != null) {
            dummyNode.next = l2;
            l2.prev = dummyNode;
            l2 = l2.next;
            dummyNode = dummyNode.next; // Move dummyNode forward
        }
        head = head.next; // Move head to the actual starting node
        return head;
    }



    static Node sortBitonicDLL(Node head) {
        Node dummyNode = head;
        int prevValue = Integer.MIN_VALUE;
        // Find the end of the first half of the list
        while (dummyNode != null && dummyNode.data > prevValue) {
            prevValue = dummyNode.data;
            dummyNode = dummyNode.next;
        }
        Node ll1EndNode = (dummyNode != null) ? dummyNode.prev : head.prev; // If dummyNode is null, the entire list is sorted
        if (ll1EndNode != null) {
            ll1EndNode.next = null; // Disconnect the first half from the second half
            head.prev = null; // Set the prev pointer of the new head (second half) to null
            Node head2 = dummyNode; // head2 is the start of the second half 
            // Merge and return the sorted list
            head2 = reverse_Dll(head2);
            return Merge2SortedDLL(head, head2);
        } else {
            return head; // List is already sorted, return head
        }
    }

}