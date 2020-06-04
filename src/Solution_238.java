import java.util.Arrays;

public class Solution_238 {
    public int[] productExceptSelf(int[] nums) {

        int[] pre = new int[nums.length];
        Arrays.fill(pre,1);
        pre[0] = 1;
        for(int i=1;i<nums.length;i++){
            pre[i] = pre[i-1] * nums[i-1];
        }

        int[] after = new int[nums.length];
        Arrays.fill(after,1);
        for(int i=nums.length-2;i>=0;i--){
            after[i] = after[i+1] * nums[i+1];
        }

        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            res[i] = pre[i]*after[i];
        }

        return res;
    }

}
