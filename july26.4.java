class Solution {
    void printList(Node head) {
        // code here
      Node temp = head;
      while(temp!= null){
          System.out.print(temp.data+" ");
          temp = temp.next;
      }
    }
}
