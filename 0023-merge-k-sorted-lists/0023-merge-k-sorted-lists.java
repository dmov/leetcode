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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode result = lists[0];
        for (int i = 1; i < lists.length; i++) {
            result = mergeTwoSortedLists(result, lists[i]);
        }
        return result;
    }

    private ListNode mergeTwoSortedLists(ListNode firstList, ListNode secondList) {
        final ListNode resultHead = new ListNode();

        ListNode resultTail = resultHead;
        while (firstList != null && secondList != null) {
            resultTail.next = new ListNode();
            resultTail = resultTail.next;
            
            if (firstList.val < secondList.val) {
                resultTail.val = firstList.val;
                firstList = firstList.next;
            } else {
                resultTail.val = secondList.val;
                secondList = secondList.next;
            }
        }
        resultTail.next = firstList == null ? secondList : firstList;
        
        return resultHead.next;
    }
}