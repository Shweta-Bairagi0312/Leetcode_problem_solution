class Solution {
    public Node insertPos(Node head, int pos, int val) {
        // code here
        if(pos==1){
            Node newNode = new Node(val);
            newNode.next = head;
            head = newNode;
            return newNode;
        }
        Node temp = head;
        for(int i = 1; i<pos-1; i++){
            temp = temp.next;
        }
        if(temp==null){
            return null;
        }
          Node newNode = new Node(val);
          newNode.next = temp.next;
          temp.next = newNode;
          return head;
        
    }
}
