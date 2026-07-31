class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode result = new ListNode();
      ListNode ptr = result;
      int carry = 0, sum = 0;
      while(l1 != null || l2 != null|| carry !=0){
        sum = carry;
       if(l1 != null){
            sum += l1.val;
            l1 = l1.next;
        }
       if(l2 != null){
            sum += l2.val;
            l2 = l2.next;
        }
        int num = sum %10;
        carry = sum/10;
        result.next = new ListNode(num);
        result = result.next;

      }
      return ptr.next;
    }
}
