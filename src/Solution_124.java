
public class Solution_124 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    private int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        process(root);
        return res;
    }

    private int process(TreeNode root) {
        if(root == null) return 0;

        int left = Math.max(process(root.left),0);
        int right = Math.max(process(root.right),0);

        res = Math.max(res, root.val + left + right);
        return Math.max(left,right) + root.val;
    }


}
