import java.util.ArrayList;
import java.util.List;


//思路巧妙，不太会，重点看一下

public class Solution_17 {
    private static List<String>  res = new ArrayList<>();
    private static String[] letter_map = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    //递归方法实现
    public static List<String> letterCombinations(String digits) {


        if (digits.length() == 0||digits == ""){
            return new ArrayList<>();
        }
        Inter(digits,0,"");
        return res;
    }
    public static void Inter(String digits, int index,String letter){
        if (digits.length() == index){
            res.add(letter);
            return;
        }

//        char c = digits.charAt(index);
//        int tmp = c - '0';

        String temp = letter_map[digits.charAt(index)-'0'];
        for (int i = 0;i<temp.length();i++){
            Inter(digits,index+1,letter+temp.charAt(i));
        }

    }

    //队列方法实现
    public static List<String> letterCombinations_Queue(String digits) {
        if(digits == "" || digits.length() == 0){
            return new ArrayList<>();
        }
        res.add("");

        for (int i=0;i<digits.length();i++){
            String temp = letter_map[digits.charAt(i) - '0'];
            int size = res.size();
            for (int j = 0;j<size;j++){
                String tmp = res.remove(0);
                for (int k = 0;k<temp.length();k++){
                    res.add(tmp+temp.charAt(k));
                }
            }


        }
        return res;
    }


    public static void main(String[] arg){

        String str  = "234";
        System.out.println(letterCombinations_Queue(str));

    }
}
