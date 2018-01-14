package leetCode;

public class AddTwoNumbers {
 /*   You are given two non-empty linked lists representing two non-negative integers. The digits are stored
    in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

            Example

    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    Explanation: 342 + 465 = 807.*/

 static class ListNode {
     ListNode next;
     int val;

     ListNode(int x) {
         x = val;
     }
 }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode result=new ListNode(0);
      ListNode d=result;
      int sum=0;
      while(l1!=null || l2!=null){
          sum/=10;
          if(l1!=null){
              sum+=l1.val;
              l1=l1.next;
          }
          if(l2!=null){
              sum+=l2.val;
              l2=l2.next;
          }
          d.next=new ListNode(sum%10);
          d=d.next;
      }
      if(sum/10==1)
          d.next=new ListNode(1);
      return result.next;
    }
}
