import java.util.HashMap;
import java.util.Stack;

public class Solution_20 {

    //使用字符串替换的方案
    public static boolean isValid(String s) {
        if (s == null || s.length() == 0){
            return false;
        }

        while (s.contains("()") || s.contains("{}") || s.contains("[]")){
            if (s.contains("()")){
                s=s.replaceAll("\\(\\)","");
            }
            if (s.contains("{}")){
                s=s.replaceAll("\\{\\}","");
            }
            if (s.contains("[]")){
                s=s.replaceAll("\\[\\]","");
            }
        }
        return s.equals("")?true:false;

    }

//    使用栈方案
public static boolean isValid1(String s) {
        if (s.length()%2 != 0){
            return false;
        }
        HashMap<Character,Character> hashMap = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        hashMap.put(')','(');
        hashMap.put(']','[');
        hashMap.put('}','{');

        for (int i = 0;i<s.length();i++){
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') stack.add(c);

            else {
                if(stack.isEmpty()) return false;
                if(stack.peek() != hashMap.get(c)) return false;
                stack.pop();
            }
        }
        if (!stack.isEmpty()) return false;

        return true;
}












    public static boolean isValid2(String s) {
        if(s.length() % 2 !=0) return false;
        Stack<Character>stack = new Stack<>();
        for (int i= 0;i<s.length();i++){
            if (s.charAt(i) == '('|| s.charAt(i)=='['|| s.charAt(i)== '{'){
                stack.add(s.charAt(i));
            }else {
                if (stack.isEmpty()) return false;
                if (!IsMatch(stack.peek(),s.charAt(i))) return false;
                stack.pop();
                }
            }
        if (stack.isEmpty()) return true;
        return false;
        }


    public static boolean IsMatch(char c1,char c2){
        if (c1 == '(' && c2 == ')') return true;
        if (c1 == '[' && c2 == ']') return true;
        if (c1 == '{' && c2 == '}') return true;
        return false;
    }



    public static void main(String[] arg){
        String str = "";
        System.out.println(isValid1(str));

    }
}
