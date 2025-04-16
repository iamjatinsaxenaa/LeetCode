class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>(); // Stores frequency of elements in current window
        int same = 0, j = 0;
        long good = 0;

        // Sliding window from left to right
        for (int i = 0; i < n; i++) {
            // Expand the window until we have at least `k` good pairs
            // A "good pair" is any pair of indices with equal values
            while (same < k && j < n) {
                same += map.getOrDefault(nums[j], 0); // Count how many same numbers seen so far (this adds new good pairs)
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1); // Update frequency of nums[j]
                j++; // Expand the window to the right
            }

            // If current window has at least k good pairs, all subarrays starting from i to end will also have it
            if (same >= k) {
                good += n - (j - 1); // Add all valid subarrays starting from index i
            }

            // Shrink window from left (move i forward)
            map.put(nums[i], map.get(nums[i]) - 1); // Reduce frequency of the outgoing element
            same -= map.get(nums[i]); // Subtract the number of good pairs that included nums[i]
        }

        return good;
    }
}