/*
You are given the head of a linked list.

Remove every node which has a node with a greater value anywhere to the right side of it.

Return the head of the modified linked list.

 

Example 1:


Input: head = [5,2,13,3,8]
Output: [13,8]
Explanation: The nodes that should be removed are 5, 2 and 3.
- Node 13 is to the right of node 5.
- Node 13 is to the right of node 2.
- Node 8 is to the right of node 3.

Example 2:

Input: head = [1,1,1,1]
Output: [1,1,1,1]
Explanation: Every node has value 1, so no nodes are removed.
 

Constraints:

The number of the nodes in the given list is in the range [1, 105].
1 <= Node.val <= 105
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

// My solution but it exceed time limit : 27/32  Testcases passed
class Solution {
    public ListNode removeNodes(ListNode head) {   
        while(head != check_right(head)){
            head = check_right(head);
        }
        ListNode crr = head;
        ListNode temp = head.next;
        while(crr.next != null){
            while(temp != check_right(temp)){
                temp = check_right(temp);
            }
            crr.next = temp;
            crr = crr.next;
            temp = temp.next;
        }


        return head;
    }

    private ListNode check_right(ListNode tempNode){
        int val = tempNode.val;
        ListNode temp = tempNode;
        while(tempNode.val <= val && tempNode.next != null){
            tempNode = tempNode.next;
            if(tempNode.val > val){
                temp = tempNode;
                break;
            }
        }
        return temp;
    }
}

// Optimized code from solutions
class Solution {
    public ListNode removeNodes(ListNode head) {
        if(head.next == null){
            return head;
        }
        ListNode prevNode = head;
        ListNode currentNode = head.next;

        while(currentNode != null){
            ListNode nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        head.next = null;
        head = prevNode;

        prevNode = head;
        currentNode = head.next;
        while(currentNode != null){
            if(currentNode.val < prevNode.val){
                currentNode = currentNode.next;
            }
            else{
                ListNode nextNode = currentNode.next;
                currentNode.next = prevNode;
                prevNode = currentNode;
                currentNode = nextNode;
            }
            
        }
        head.next = null;
        head = prevNode;
        return head;
    }
}
