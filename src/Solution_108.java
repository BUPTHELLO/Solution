public class Solution_108 {


public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length <= 0){
            return null;
        }
        return createTree(nums,0,nums.length);
    }

//    createTree是左闭右开区间，因此line15写成nums.length形式

    public static TreeNode createTree(int[] nums,int start,int end){
        if(start == end){
            return null;
        }
        int mid = (start+end)>>1;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = createTree(nums,start,mid);
        root.right = createTree(nums,mid+1,end);

        return root;
    }

    public static void main(String[] arg){
    int[] num = {-10,-3,0,5,9};
    TreeNode root = sortedArrayToBST(num);
    }
}
