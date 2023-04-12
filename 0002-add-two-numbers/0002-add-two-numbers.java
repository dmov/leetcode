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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        final ListNode resultHead = new ListNode();
        ListNode resultTail = resultHead;

        int overflow = 0;
        while (l1 != null && l2 != null) {
            resultTail.next = new ListNode();
            resultTail = resultTail.next;

            int sum = l1.val + l2.val + overflow;
            overflow = fillValue(resultTail, sum);

            l1 = l1.next;
            l2 = l2.next;
        }

        resultTail.next = l1 == null ? l2 : l1;

        while (resultTail.next != null) {
            if (overflow > 0) {
                resultTail = resultTail.next;
                
                int sum = resultTail.val + overflow;
                overflow = fillValue(resultTail, sum);
            } else {
                break;
            }
        }
        if (overflow > 0) {
            resultTail.next = new ListNode(overflow);
        }

        return resultHead.next;
    }

    private int fillValue(ListNode resultTail, int sum) {
        int overflow = 0;
        
        if (sum >= 10) {
            overflow += 1;
            sum -= 10;
        }
        resultTail.val = sum;
        return overflow;
    }
}