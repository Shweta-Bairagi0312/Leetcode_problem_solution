class Solution {
    public Node insertAtFront(Node head, int x) {
        Node temp = new Node(x);
        temp.next = head;
        return temp;
    }
}
