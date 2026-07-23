class Solution {
    public Node insertAtEnd(Node head, int x) {
        // code here
        Node ptr = new Node(x);
        if(head==null){
            return ptr;
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = ptr;
        ptr.next = null;
        
        return head;
    }
}
