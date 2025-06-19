class Solution 
{
    public int partitionArray(int[] nums, int k) 
    {
        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Initialize group count to 1
        int count = 1;

        // Step 3: Set the minimum of the first group
        int min = nums[0];

        // Step 4: Traverse from index 1
        for (int i = 1; i < nums.length; i++) 
        {
            // Step 5: If current number too far from min, start a new group
            if (nums[i] - min > k) 
            {
                count++;        
                min = nums[i];  
            }
        }

        // Step 6: Return total group count
        return count;
    }
}