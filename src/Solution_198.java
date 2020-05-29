public class Solution_198 {
    public int rob(int[] nums) {
        // 0号屋子到i号屋子能得到的最大金额
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i = 2;i<nums.length;i++){
            // 打劫i房屋
            int a = dp[i-2] + nums[i];
            // 不打劫i房屋
            int b = dp[i-1];

            dp[i] = Math.max(a,b);
        }

        return dp[nums.length-1];
    }
}
