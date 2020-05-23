public class Solution_41 {

    public static int firstMissingPositive(int[] nums) {
//        int length = nums.length;

        for (int i = 0;i<nums.length;i++){
//            设置桶
            while (nums[i]>=1 && nums[i] <= nums.length && nums[i]!=nums[nums[i]-1]){
                swap(nums,i,nums[i]-1);
            }
        }

        for (int i=0;i<nums.length;i++){
//            num[0] == 1,num[1]==2,num[2]==3 ...等等
            if (i+1 != nums[i]){
                return i+1;
            }
        }
        return nums.length+1;

    }


//    交换数组中i,j位置的元素
    public static void swap(int[] nums, int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

    }
}
