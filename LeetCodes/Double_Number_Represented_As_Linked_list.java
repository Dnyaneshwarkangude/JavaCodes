/*
You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.
Return the head of the linked list after doubling it.

Example 1:
Input: head = [1,8,9]
Output: [3,7,8]
Explanation: The figure above corresponds to the given linked list which represents the number 189. Hence, 
the returned linked list represents the number 189 * 2 = 378.

Example 2:
Input: head = [9,9,9]
Output: [1,9,9,8]
Explanation: The figure above corresponds to the given linked list which represents the number 999. 
Hence, the returned linked list reprersents the number 999 * 2 = 1998. 
 

Constraints:

The number of nodes in the list is in the range [1, 104]
0 <= Node.val <= 9
The input is generated such that the list represents a number that does not have leading zeros, except the number 0 itself.
*/

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

// 1st Approach : my approach is convert number form from list to String and then get each single char from list and convert it to digit
//                then add that to new list. ( But it beats only 5% users)

import java.math.BigInteger;
class Solution {
    public ListNode doubleIt(ListNode head) {
        String num = "";
        ListNode temp = head;
        while(temp != null){
            num = num + String.valueOf(temp.val);
            temp = temp.next;
        }

        BigInteger big = new BigInteger(num);                    
        num = String.valueOf(big.multiply(new BigInteger("2")));   // here we can use int or long if our digits are small in list
        ListNode newHead = new ListNode(num.charAt(0)-'0'); 
        ListNode crrNode = newHead;
        for(int i=1; i<num.length(); i++){
            int n = num.charAt(i)-'0';
            ListNode newNode = new ListNode(n);
            crrNode.next = newNode;
            crrNode = crrNode.next;
        }
        
        return newHead;
    }
}

// 2nd Approach : like normal multiplication of numbers on paper. ( 51% beats)
class Solution {
    public ListNode doubleIt(ListNode head) {
        if(head.next == null){
            if(head.val == 0){
                return head;
            }
            if(head.val * 2 <10){
                head.val = head.val*2;
                return head;
            }
            int n = head.val * 2;
            head.val = n/10;
            head.next = new ListNode(n % 10);
            return head;
        }
        head = reverseList(head);
        ListNode crr = head;
        ListNode prev = head;
        int r = 0, n = 0;
        while(crr != null){
            n = crr.val * 2 + n/10;
            r = n % 10;
            crr.val = r;
            prev = crr;
            crr = crr.next;
        } 
        if(n/10 != 0 ){
            ListNode newNode = new ListNode(n/10);
            prev.next = newNode;
        }

        return reverseList(head);

    }

    private ListNode reverseList(ListNode head){
        // if(head.next == null){
        //     return head;
        // }
        ListNode prev = null;
        ListNode crr = head;
        while(crr != null){
            ListNode temp = crr.next; 
            crr.next = prev;
            prev = crr;
            crr = temp;
        }  
        head = prev;
        return head;
    }

}

// Optimized code from solution
class Solution {
    public ListNode doubleIt(ListNode head) {
        ListNode head1 = new ListNode();
        head1.next = head;

        ListNode left = head1;
        ListNode right = head;
        while (right != null) {
            if (right.val * 2 >= 10) {
                left.val += 1;
            }
            right.val = (right.val * 2) % 10;
            left = left.next;
            right = right.next;
        }
        return head1.val > 0 ? head1 : head;
    }
}
