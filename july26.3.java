class Solution {
    Node deleteNode(Node head, int x) {
        // code here
        Node temp = head;
        Node ptr = null;
         if(head==null){
             return null;
         }
         if(x==1){
            head = head.next;
            return head;
         }
         for(int i = 1; i<x; i++){
             ptr = temp;
             temp = temp.next;
         }
         if(temp==null){
             return null;
         }
         ptr.next = temp.next;
         return head;
         
    }
}
