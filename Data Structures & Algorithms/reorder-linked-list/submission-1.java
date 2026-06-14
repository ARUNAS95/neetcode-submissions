/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        
        ListNode mid = findMid(head);
        ListNode l1 = head;
        ListNode l2 = reverse(mid.next);
        mid.next = null;

        merge(l1, l2);
    }

    ListNode findMid(ListNode head){
        
        ListNode fast = head.next;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return slow;
        }

        return slow;
    }

    ListNode reverse(ListNode mid){
        ListNode curr = mid;
        ListNode prev = null;
       

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    void merge(ListNode l1, ListNode l2){
       while(l1 != null){
        ListNode temp = l1.next;
        l1.next = l2;
        l2 = temp;

        l1 = l1.next;
       }

      
    }
}
