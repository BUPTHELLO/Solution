import java.util.ArrayList;
import java.util.List;

public class Solution_1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        List<Boolean> res = new ArrayList<>();
        for(int i=0;i<candies.length;i++){
            max = Math.max(max,candies[i]);
        }

        for(int i=0;i<candies.length;i++){
            if(candies[i]+extraCandies>=max){
                res.add(true);
            }else{
                res.add(false);
            }
        }
        return res;

    }
}
