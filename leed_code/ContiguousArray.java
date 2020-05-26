/*

Contiguous Array

Question:

Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Note: The length of the given binary array will not exceed 50,000

*/

class ContiguousArray {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> indexMap = new HashMap<>();
        indexMap.put(0,-1);
        int maxLen=0,count=0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] == 0) {
                count -= 1;
            } else {
                count += 1;
            }
            if(indexMap.containsKey(count)) {
                maxLen = Math.max(maxLen,i-indexMap.get(count));
            } else {
                indexMap.put(count,i);
            }
        }
        return maxLen;
    }
}