class Solution {
    public Node removeLastNode(Node head) {
        // code here
        if( head.next==null){
            return null;
        }
        Node temp = head;
        Node ptr  = new Node(-1);
        while(temp.next != null){
            ptr = temp;
            temp = temp.next;
            
        }
        ptr.next = null; 
        return head;
        
    }
}
