import java.lang.reflect.Array;
import java.util.ArrayList;

public class mianshi_46 {
    private int res;
    public int translateNum(int num) {
        res = 0;
        String buff = String.valueOf(num);
        dfs(buff,0);
        return res;
    }

    private void dfs(String buff, int index) {
        if (index == buff.length()){
            res++;
            return;
        }

        if (index == buff.length()-1 || buff.charAt(index)=='0' || Integer.valueOf(buff.substring(index,index+2))>25){
            dfs(buff,index+1);
            return;
        }

        dfs(buff,index+1);
        dfs(buff,index+2);
        return;
    }


    public static void main(String[] args) {
        new mianshi_46().translateNum(12258);
    }
}
