/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode firstPointer = head;
        ListNode secondPointer = head;

        while (firstPointer.next != null 
        && secondPointer.next != null && secondPointer.next.next != null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next.next;
            if (firstPointer == secondPointer) {
                return true;
            }
        }
        return false;
    }
}