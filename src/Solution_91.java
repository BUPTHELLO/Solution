public class Solution_91 {
    /**
     * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
     *
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
     *
     * 示例 1:
     *
     * 输入: "12"
     * 输出: 2
     * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
     * 示例 2:
     *
     * 输入: "226"
     * 输出: 3
     * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
     *
     * @param s
     * @return
     */
    public static int numDecodings(String s) {
        return help(s,0);
    }

    /**
     * 从index到字符串结尾解码总数
     * @param s
     * @param index
     * @return
     */
    private static int help(String s,int index){
        if (index == s.length()) return 1;
        if (s.charAt(index) == '0') return 0;



        int ans1 = help(s,index+1);
        int ans2 = 0;
        if (index < s.length()-1){
            int ten = s.charAt(index) - '0';
            int one = s.charAt(index+1) - '0';
            if (ten*10+one<=26){
                ans2 = help(s,index+2);
            }
        }
        return ans1+ans2;
    }
    public static void main(String[] args) {
        System.out.println(numDecodings("1"));
    }
}
