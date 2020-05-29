import java.util.HashMap;

public class Solution_76 {
    //        记录t中出现的字符以及出现的次数
    private HashMap<Character,Integer> tmap;
    //        记录滑动窗口中字符以及出现的次数
    private HashMap<Character,Integer> map;

    public String minWindow(String s, String t) {

        tmap = new HashMap<>();
        map = new HashMap<>();

        int s_length = s.length();
        int t_length = t.length();

        for (int i=0;i<t_length;i++){
            tmap.put(t.charAt(i),tmap.getOrDefault(t.charAt(i),0)+1);
        }

        int left = 0;
        int right = 0;
        int Cur_Window = 0;

        String res = s;


        while(right<s_length){

            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            right++;

            if (Judge()){

//                尽可能收缩左边界
                while (Judge() && left < right){
                    int val = tmap.get(s.charAt(left));
                    val --;
                    val = val <= 0 ? 0:val;
                    tmap.put(s.charAt(left),val);
                    left++;
                }
//                计算当前窗口长度,更新res
                Cur_Window = right - left;
                res = (Cur_Window>=res.length()) ? res : s.substring(left,right);
            }
        }
        return res;
    }


//    tmap是字符串t的信息（范围小）
//    map是滑动窗口的字符串信息(范围大)
    private boolean Judge(){
        for (Character key : tmap.keySet()){
            if (!map.containsKey(key) || tmap.get(key)>map.get(key)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution_76 s = new Solution_76();
        s.minWindow("ADOBECODEBANC","ABC");
    }
}
