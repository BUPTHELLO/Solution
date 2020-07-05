import java.util.Stack;

public class Solution_32 {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] state = new int[s.length()];
        int res = 0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(i);
                continue;
            }
            if(stack.isEmpty()){
                state[i] = 1;
            } else{
                stack.pop();
            }
        }

        while(!stack.isEmpty()){
            state[stack.pop()] = 1;
        }

        int Cur = 0;
        for(int i=0; i<state.length; i++){
            if(state[i] == 1) Cur = 0;
            else if(state[i] == 0){
                Cur = Cur + 1;
                res = Math.max(res,Cur);
            }
        }
        return res;
    }
}
