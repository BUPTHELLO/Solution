public class Solution_38 {

    public static String countAndSay(int n) {
        if ( n == 1) return "1";
        String res = "1";
        int count = 1;
        while (n>1){
            res = res +"#";
            String temp = "";
            for (int i = 0;i<res.length() - 1;i++){
                if (res.charAt(i) == res.charAt(i+1)){
                    count++;
                }else {
                    temp = temp + count+res.charAt(i);
                    count = 1;
                }
            }
            res = temp;
            n--;
        }

    return res;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));

    }
}
