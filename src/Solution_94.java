import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution_94 {
    public static class TreeNode {
        private TreeNode(int x) { val = x; }
        int val;
        TreeNode left;
        TreeNode right;
    }
    //递归版本_中序遍历
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        dfs(res,root);
        return res;
    }
    private static void dfs(List<Integer> res, TreeNode root){
        if (root == null) return;

        dfs(res,root.left);
        res.add(root.val);
        dfs(res,root.right);

    }
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        dfs_1(res,root);
        return res;
    }
    private static void dfs_1(List<Integer> res, TreeNode root){
        if (root == null) return;
        res.add(root.val);
        dfs_1(res,root.left);
        dfs_1(res,root.right);
    }

    //非递归版本_中序遍历
    public static List<Integer> inorder_Traversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode tmp;

        while (root != null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }

            tmp = stack.pop();
            res.add(tmp.val);
            root = tmp.right;
        }
        return res;
    }
//  非递归版本，前序遍历
    public static List<Integer> preorder_Traversal(TreeNode root) {

        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return res;

        stack.push(root);
        while (!stack.isEmpty()){
            root = stack.pop();
            res.add(root.val);
            if (root.right != null)
                stack.push(root.right);
            if (root.left != null)
                stack.push(root.left);
        }
        return res;

    }

    public static void main(String[] args) {

    }
}
