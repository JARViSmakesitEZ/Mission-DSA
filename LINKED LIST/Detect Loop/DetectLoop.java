import java.util.HashMap;

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

public class DetectLoop {
    // This method is called tortoise and hare method or Floyd's cycle detection algorithm
    // Another approach is hashing
    public static boolean detectCycle(Node head) {
        HashMap<Node, Character> visited = new HashMap<>();
        Node slow = head;
        Node fast = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            if (slow == fast && slow != null) {
                return true;
            }
        }
        return false;
    }
}
