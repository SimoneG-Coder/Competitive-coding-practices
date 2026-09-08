// FAST AND SLOW POINTERS
//Initially both fast and slow pointers point to head
//Fast pointer moves by 2 positions
//Slow pointer moves by 1 position
//Cycle detected - slow ahead of fast by 1 step (Slow = fast.next)
//for odd number of nodes condition is fast->next != null, for even nodes while condition is fast != null

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;           // move 1 step
            fast = fast.next.next;      // move 2 steps

            if (slow == fast) {
                return true;            // cycle detected
            }
        }

        return false; // reached end → no cycle
    }
}

//Detect Sart of the loop 
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Step 2: Find start of cycle
                ListNode ptr1 = head;
                ListNode ptr2 = slow;

                while (ptr1 != ptr2) {
                    ptr1 = ptr1.next;
                    ptr2 = ptr2.next;
                }
                return ptr1; // start of loop
            }
        }

        return null; // no cycle
    }
}



