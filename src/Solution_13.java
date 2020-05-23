import java.util.HashMap;

public class Solution_13 {
    public static int romanToInt(String s) {
        int res = 0;
        HashMap<String,Integer> hashMap = new HashMap();
        hashMap.put("I",1);
        hashMap.put("V",5);
        hashMap.put("X",10);
        hashMap.put("L",50);
        hashMap.put("C",100);
        hashMap.put("D",500);
        hashMap.put("M",1000);
        hashMap.put("IV",4);
        hashMap.put("IX",9);
        hashMap.put("XL",40);
        hashMap.put("XC",90);
        hashMap.put("CD",400);
        hashMap.put("CM",900);

        for (int i = 0; i<s.length();){
            if (i+2<=s.length()&&hashMap.containsKey(s.substring(i,i+2))){
               res = res + hashMap.get(s.substring(i,i+2));
               i = i+2;
            }else {
                res = res + hashMap.get(s.substring(i,i+1));
                i++;
            }
        }
        return res;
    }

    public static void main(String[] arg) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}