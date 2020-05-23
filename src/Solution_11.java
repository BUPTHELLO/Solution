public class Solution_11 {
//    时间复杂度O(n^2),空间复杂度O(1)
    public static int maxArea_force(int[] height) {
        int res = 0;
        for (int i = 0; i<height.length;i++){
            for (int j = i+1; j<height.length;j++){
                res = Math.max(res,Math.min(height[i],height[j])*(j-i));
            }
        }
        return res;
    }

//    双指针法：移动低的一边
//
//    面积受到宽度和两者高度的最小值乘积确定：
//    1、若移动高的边，宽度肯定会减少，高度不会发生改变，因此面积肯定会减少
//    2、若移动低的边，宽度会减少，高度有可能增加，因此面积有可能变大
//
//    因此需要把2情况遍历一遍求得最大面积


    public static int maxArea(int[] height){
        int res = 0;
        int left = 0;
        int right = height.length-1;

        while (left < right){
            res = Math.max(res,Math.min(height[left],height[right])*(right-left));
            if (height[left]<height[right]){
                left++;

            }else {
                right--;
            }
        }
        return res;
    }

    public static void main(String[] arg){

        int[] temp = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(temp));

    }
}
