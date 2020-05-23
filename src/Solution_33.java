public class Solution_33 {

//    常规的二分法查找
    /**
     *
     * @param arr 输入有序数组
     * @param target 目标值
     * @return 目标值索引
     */
    public static int BinarySearch(int[] arr,int target,int Left,int Right){
        while (Left<=Right){
//   注意：移位运算优先级低于加减运算
//   (Right-Left)>>1 + Left 等效 (Right-Left)>>(1 + Left);
//   也可以写成(Right-Left>>1) + Left;

            int mid = ((Right-Left)>>1) + Left;
            if (arr[mid] == target) return mid;
            if (arr[mid]<target){
                Left = mid+1;
            }else
                Right = mid-1;
        }
        return -1;
    }

    /**
     *leetcode_153
     * @param nums 输入数组，二分法搜索
     * @return 数组旋转点索引
     *
     * 进一步，旋转数组找最大值和最小值也可以用二分法直接进行
     */
    public static int rotate_index(int[] nums){
        int left = 0;
        int right = nums.length-1;
        // 没有数组没有进行旋转操作
        if (nums[right]>=nums[left]) return left;

        while (left<right){
            int mid = left +(right-left>>1);
            if (nums[mid]>nums[right]) left = mid+1;
            else if (nums[mid]<nums[right]) right = mid;
//            不需要考虑nums[mid]==nums[right]情形
//            因为循环结束时有left==right
//            else if (nums[mid] == nums[right]) break;
        }



//            或者也可以这样写，跟上面的写法等效
//        while (left<right){
//            int mid = left +(right-left>>1);
//            if (nums[mid]>nums[mid+1]) return mid+1;
//            else if (nums[mid]>nums[right]) left = mid+1;
//            else if (nums[mid]<nums[right]) right = mid;
//                // 数组元素不重复，所以该情况不出现
//            else if (nums[mid] == nums[right]) break;
//        }



        return left;
    }

    public static int search(int[] arr,int target){
        if(arr == null || arr.length == 0) return -1;

        if(arr.length == 1){
            return arr[0] == target?0:-1;
        }

        int index = rotate_index(arr);
        if (index == 0) return BinarySearch(arr,target,0,arr.length-1);


//        将数组分解为0~index-1和index~arr.length-1两部分,分别进行查询；
        int part_1 = BinarySearch(arr,target,0,index-1);
        int part_2 = BinarySearch(arr,target,index,arr.length-1);

        if (part_1 != -1 && part_2 == -1) return part_1;
        if (part_1 == -1 && part_2 != -1) return part_2;

        return -1;
    }



    public static void main(String[] args) {
        int[] arr1 = {3,1};
        System.out.println(search(arr1,1));

    }
}
