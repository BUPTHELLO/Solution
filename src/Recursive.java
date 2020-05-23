import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Recursive {


    /**
     * 只使用递归方案做
     * 输入：["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     * @param s
     */
    public static void reverseString(char[] s) {
        if (s == null ||s.length==0) return;
        help(s,0,s.length-1);
    }

    /**
     * 在left和right区间实现翻转
     * @param s
     * @param left
     * @param right
     */
    private static void help(char[] s,int left,int right){
        if (left>=right) return;

        char c = s[left];
        s[left] = s[right];
        s[right] = c;
        help(s,++left,--right);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 给定 1->2->3->4, 你应该返回 2->1->4->3
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode FirstNode = head;
        ListNode SecondNode = head.next;
        FirstNode.next = swapPairs(SecondNode.next);
        SecondNode.next = FirstNode;
        return SecondNode;
    }

    /**
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> dg = new LinkedList<>();

        if (numRows == 0) return dg;
        if (numRows == 1){
            dg.add(new LinkedList<>());
            dg.get(0).add(1);
            return dg;
        }

 //       新的 = 这一行的 + 上面全部的

 //        拿到上面全部的
        dg = generate(numRows-1);

//        生成第n行的东西
        List<Integer> temp = new LinkedList<>();
        temp.add(1);
        for (int i=0;i<dg.get(numRows-2).size()-1;i++){
            int result = dg.get(numRows-2).get(i)+dg.get(numRows-2).get(i+1);
            temp.add(result);
        }
        temp.add(1);

        dg.add(temp);

        return dg;


    }

    /**
     * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
     * @param rowIndex
     * @return
     */
    public static List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0){
            List<Integer> res = new LinkedList<>();
            res.add(1);
            return res;
        }



        List<Integer> res = new LinkedList<>();
        List<Integer> tmp = getRow(rowIndex-1);
        res.add(1);
        for (int i=0;i<tmp.size()-1;i++){
            res.add(tmp.get(i)+tmp.get(i+1));
        }
        res.add(1);

        return res;
    }

    /**
     * 翻转一个单链表
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;


        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;

    }

    /**
     *斐波那契数列计算
     * @param N
     * @return
     */
    public static int fib(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return fib(N-1)+fib(N-2);
    }

    /**
     * 爬楼梯问题
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n == 0||n == 1) return 1;
        int result = climbStairs(n-1)+climbStairs(n-2);
        return result;
    }

    /**
     * 动态规划爬楼梯问题
     * @param n
     * @return
     */
    public static int climbStairs_DP(int n) {
        int[] DP = new int[n+1];
        DP[0] = 0;
        DP[1] = 1;
        DP[2] = 2;
        for (int i=3;i<=n;i++){
            DP[i] = DP[i-1]+DP[i-2];
        }
        return DP[n];
    }


//      Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    /**
     * 二叉树最大深度
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;


//        找到左,右子树的头结点
        TreeNode L = root.left;
        TreeNode R = root.right;

        int L_depth = maxDepth(L);
        int R_depth = maxDepth(R);

        int res = Math.max(L_depth,R_depth) + 1;
        return res;
    }

    /**
     * 有序链表的合并
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;


        if (l1.val<l2.val){
            ListNode p1 = l1.next;
            ListNode res = mergeTwoLists(p1,l2);
            l1.next = res;
            return l1;
        }else{
            ListNode p2 = l2.next;
            ListNode res = mergeTwoLists(l1,p2);
            l2.next = res;
            return l2;
        }

    }

    public static void main(String[] args) {
        generate(5);
        getRow(3);


    }
}
