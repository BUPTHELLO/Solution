public class Solution_53 {

//    暴力法，时间复杂度O(n^2)，通过：200/202
    public static int maxSubArray_force(int[] nums) {
        int res = Integer.MIN_VALUE;
        for (int i = 0;i<nums.length;i++){
            for (int j = i+1;j<=nums.length;j++){
                res = Integer.max(res,Sum(nums,i,j));
            }
        }
        return res;
    }
    private static int Sum(int[] num,int i,int j){
        int res = 0;
        while (i<j){
            res = num[i] + res;
            i++;
        }
        return res;
    }

//    动态规划：令状态dp[i]表示以A[i]作为末尾的连续序列的最大和。
    public static int maxSubArray(int[] nums) {
        int[] dp_matrix = new int[nums.length];
        dp_matrix[0] = nums[0];

        for (int i = 1;i<nums.length;i++){
            dp_matrix[i] = Math.max(dp_matrix[i-1]+nums[i],nums[i]);
        }

//        在dp_matrix中找最大值
        int res = dp_matrix[0];
        for(int i = 0;i<dp_matrix.length;i++){
            res = Math.max(res,dp_matrix[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(maxSubArray_force(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

    }
}
