/*
You are given an array people where people[i] is the weight of the ith person, and an infinite number 
of boats where each boat can carry a maximum weight of limit. Each boat carries at most two people at 
the same time, provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.

 

Example 1:

Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)
Example 2:

Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)
Example 3:

Input: people = [3,5,3,4], limit = 5
Output: 4
Explanation: 4 boats (3), (3), (4), (5)
 

Constraints:

1 <= people.length <= 5 * 104
1 <= people[i] <= limit <= 3 * 104
*/

// My Solution
import java.util.*;
class Solution {
    public static void main(String[] art){
        Solution obj = new Solution();
        int[] people = {3,2,3,2,2};
        int limit = 6;   // Expected output is 3
        System.out.println(obj.numRescueBoats(people,limit));
    }
    
    public int numRescueBoats(int[] people, int limit) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i:people){
            list.add(i);
        }
        Collections.sort(list);
        Collections.reverse(list); 
        
        int boats=0;
        while(!list.isEmpty()){
            int temp = limit;
            int tempCount=0;
            ArrayList<Integer> tempList = new ArrayList<Integer>(list);
            for(Integer i : tempList){
                if(i<=temp){
                    temp = temp - i;
                    tempCount++;
                    list.remove(i);
                }
                if(tempCount == 2){
                    break;
                }
            }
            boats++;
            
        }
        return boats;
    }
}

// optimized code 
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boats = 0;
        Arrays.sort(people);
        int i=0,j=people.length-1;
        while(i<=j){
            if((people[j]+people[i])<=limit){
                i++;
            }
            j--;
            boats++;
        }
        return boats;
    }
}
