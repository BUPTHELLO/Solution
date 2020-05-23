public class Solution_191 {
    public static int hammingWeight(int n) {
        int res = 0;
        String str = String.valueOf(n);
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '1') res++;
        }
        return res;
    }
    public static void main(String[] args) {
        int n = 000101;
        System.out.println(hammingWeight(00000000000000000000000010000000));
    }
}
