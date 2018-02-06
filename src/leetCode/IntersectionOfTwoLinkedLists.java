package leetCode;

public class IntersectionOfTwoLinkedLists {
  /*  Write a program to find the node at which the intersection of two singly linked lists begins.


    For example, the following two linked lists:

    A:          a1 → a2
                   ↘
    c1 → c2 → c3
                   ↗
    B:     b1 → b2 → b3
    begin to intersect at node c1.*/
  static class ListNode{
      ListNode next;
      int val;
      ListNode(int x) { val=x;}
  }
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
     int lens1=getLength(headA),lens2=getLength(headB);
     while(lens1>lens2){
         lens1--;
         headA=headA.next;
     }
     while(lens2>lens1){ lens2--; headB=headB.next;}
     while(headA!=headB){
         headA=headA.next;headB=headB.next;
     }
     return headA;

  }
  public static int getLength(ListNode root){
      int result=0;
      while(root!=null){
          result+=1;
          root=root.next;
      }
      return result;
  }
}
