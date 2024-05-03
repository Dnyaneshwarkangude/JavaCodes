/*
Given two version numbers, version1 and version2, compare them.

Version numbers consist of one or more revisions joined by a dot '.'. Each revision consists of digits and may contain leading zeros. 
Every revision contains at least one character. Revisions are 0-indexed from left to right, with the leftmost revision being revision 0, 
the next revision being revision 1, and so on. For example 2.5.33 and 0.1 are valid version numbers.

To compare version numbers, compare their revisions in left-to-right order. Revisions are compared using their integer value ignoring any leading zeros. 
This means that revisions 1 and 001 are considered equal. If a version number does not specify a revision at an index, then treat the revision as 0. 
For example, version 1.0 is less than version 1.1 because their revision 0s are the same, but their revision 1s are 0 and 1 respectively, and 0 < 1.

Return the following:

If version1 < version2, return -1.
If version1 > version2, return 1.
Otherwise, return 0.
 

Example 1:

Input: version1 = "1.01", version2 = "1.001"
Output: 0
Explanation: Ignoring leading zeroes, both "01" and "001" represent the same integer "1".
Example 2:

Input: version1 = "1.0", version2 = "1.0.0"
Output: 0
Explanation: version1 does not specify revision 2, which means it is treated as "0".
Example 3:

Input: version1 = "0.1", version2 = "1.1"
Output: -1
Explanation: version1's revision 0 is "0", while version2's revision 0 is "1". 0 < 1, so version1 < version2.
 

Constraints:

1 <= version1.length, version2.length <= 500
version1 and version2 only contain digits and '.'.
version1 and version2 are valid version numbers.
All the given revisions in version1 and version2 can be stored in a 32-bit integer.
*/

// My Solution : 
import java.util.*;
class Solution {
    public static void main(String[] art){
        Solution o = new Solution();
        String s1 = "7.5.2.4";               // Expected ans = -1
        String s2 = "7.5.3";
        System.out.println(o.compareVersion(s1,s2));
    }
    public int compareVersion(String version1, String version2) {
        if(version1.equals(version2)){
            return 0;
        }
        ArrayList<Integer> v1 = new ArrayList<>();
        ArrayList<Integer> v2 = new ArrayList<>();
        String[] a1 = version1.split("\\.");
        String[] a2 = version2.split("\\."); 
        for(String s:a1){
            v1.add(Integer.valueOf(s));
        }
        for(String s:a2){
            v2.add(Integer.valueOf(s));
        } 
        while(!v1.isEmpty() && !v2.isEmpty()){
            if(v1.get(0) > v2.get(0)){
                return 1;
            }
            if(v1.get(0) < v2.get(0)){
                return -1;
            }
            if(v1.get(0) == v2.get(0)){
                v1.remove(0);
                v2.remove(0);
            }
        }
        if(!v1.isEmpty()){
            boolean flag = false;
            for(int val:v1){
                if(val>0){
                    flag = true;
                    break;
                }
            }
            if(flag){
                return 1;
            }
        }
        if(!v2.isEmpty()){
            boolean flag = false;
            for(int val:v2){
                if(val>0){
                    flag = true;
                    break;
                }
            }
            if(flag){
                return -1;
            }
        }
        return 0;
    }
}

// Optimized code from leetcode user(someone )
class Solution {
    public int compareVersion(String version1, String version2) {
        int n = version1.length(), m = version2.length();
        int i = 0, j = 0;
        while (i < n || j < m) {
            int x = 0;
            for (; i < n && version1.charAt(i) != '.'; ++i) {
                x = x * 10 + version1.charAt(i) - '0';
            }
            ++i; // 跳过点号
            int y = 0;
            for (; j < m && version2.charAt(j) != '.'; ++j) {
                y = y * 10 + version2.charAt(j) - '0';
            }
            ++j; // 跳过点号
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }
}
