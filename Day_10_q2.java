//Merge 2 sorted lists
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0); // placeholder
        ListNode cur = dummy;

        // Two pointers: temp1 for list1, temp2 for list2
        ListNode temp1 = list1;
        ListNode temp2 = list2;

        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                cur.next = temp1;
                temp1 = temp1.next;
            } else {
                cur.next = temp2;
                temp2 = temp2.next;
            }
            cur = cur.next;
        }

        // Attach the remainder
        cur.next = (temp1 != null) ? temp1 : temp2;

        return dummy.next; // skip dummy
    }
}
