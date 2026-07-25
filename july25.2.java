class Solution {
    public int GetNth(Node head, int index) {
        // Code here
       Node temp = head;
       for(int i = 1; i<index && temp != null; i++){
           temp = temp.next;
       }
       if(temp==null){
           return -1;
       }
       return temp.data;
    }
}
