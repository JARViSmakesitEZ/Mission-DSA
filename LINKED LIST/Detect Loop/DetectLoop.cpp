#include <unordered_map>

class Node {
public:
    int data;
    Node *next;

    Node() {
        this->data = 0;
        next = nullptr;
    }

    Node(int data) {
        this->data = data;
        this->next = nullptr;
    }

    Node(int data, Node* next) {
        this->data = data;
        this->next = next;
    }
};

bool detectCycle(Node* head) {
    std::unordered_map<Node*, char> visited;
    Node* slow = head;
    Node* fast = head;
    while (fast != nullptr) {
        slow = slow->next;
        fast = fast->next;
        if (fast != nullptr) {
            fast = fast->next;
        }
        if (slow == fast && slow != nullptr) {
            return true;
        }
    }
    return false;
}
