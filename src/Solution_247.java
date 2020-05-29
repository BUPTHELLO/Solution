public class Solution_247 {
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            while(nums[i] != nums[nums[i]-1]) swap(nums, i, nums[i]-1);
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i] != i+1) return nums[i];
        }
        return 0;
    }

    private void swap(int[] nums, int i, int j){
        int buff = nums[i];
        nums[i] = nums[j];
        nums[j] = buff;
    }

    public static void main(String[] args) {
        Solution_247 s = new Solution_247();
        s.findDuplicate(new int[]{1,3,2,2,2});
    }
}
