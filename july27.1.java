class Solution {
    public boolean searchKey(Node head, int key) {
        Node temp = head;
        
            while(temp!=null){
                if(temp.data==key){
                    return true;
                }
                else{
                    temp = temp.next;
                }
            }
        
        return false;
        
    }
}
