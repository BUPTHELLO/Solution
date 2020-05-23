public class Solution_26 {

//    双指针方案
    public int removeDuplicates(int[] nums) {
        int i=0;
        for (int j = 0; j<nums.length;j++){
            if (nums[i] == nums[j]) continue;
            nums[i+1] = nums[j];
            i++;
        }

        return i+1;
    };
    public static void main(String[] args) {

    }
}
