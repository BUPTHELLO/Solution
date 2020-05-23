import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution_98 {

    public static class TreeNode {
        private TreeNode(int x) { val = x; }
        int val;
        TreeNode left;
        TreeNode right;
    }

    /**
     * 中序遍历是上升序列
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
//        存放中序遍历的结果
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

//        二叉树中序遍历
        while (root!=null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode tmp = stack.pop();
            list.add(tmp.val);
            root = tmp.right;
        }

//        判断序列是否单调增加
        for (int i=0;i<list.size()-1;i++){
            if (list.get(i)>=list.get(i+1))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
