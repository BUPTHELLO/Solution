import java.util.LinkedList;
import java.util.List;

public class Solution_78 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        backtrack(0, nums, res, new LinkedList<>());
        return res;

    }

    private static void backtrack(int i, int[] nums, List<List<Integer>> res, LinkedList<Integer> tmp) {
            res.add(new LinkedList<>(tmp));

        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);

        }
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3}));
    }
}
