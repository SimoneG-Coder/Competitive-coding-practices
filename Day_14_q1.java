//reverse linked list
//iterative 
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next; // save next
            curr.next = prev;          // reverse link
            prev = curr;               // move prev forward
            curr = next;               // move curr forward
        }

        return prev; // new head
    }
}



//recursive 
class Solution {
    public ListNode reverseListRecursive(ListNode head) {
        // Base case: empty list or single node
        if (head == null || head.next == null) {
            return head;
        }

        // Reverse the rest of the list
        ListNode newHead = reverseListRecursive(head.next);

        // Fix current node
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}

