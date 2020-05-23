import java.util.HashSet;
import java.util.Stack;

public class Solution_73 {

    /**
     * 注意一定先全部遍历完再置0
     * 不能在遍历的过程中置0
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        Stack<Integer> Row = new Stack<>();
        Stack<Integer> Col = new Stack<>();

        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                if (matrix[i][j] == 0) {
                    Row.add(i);
                    Col.add(j);
                }
            }
        }

        while (!Row.isEmpty()){
            int temp = Row.pop();
            for (int j=0;j<matrix[0].length;j++){
                matrix[temp][j] = 0;
            }
        }

        while (!Col.isEmpty()){
            int temp = Col.pop();
            for (int j = 0;j<matrix.length;j++){
                matrix[j][temp] = 0;
            }
        }

    }

    /**
     * 官方解法
     * @param matrix
     */
    public void Ans(int[][] matrix){
        HashSet<Integer> Row = new HashSet<>();
        HashSet<Integer> Col = new HashSet<>();

        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                if (matrix[i][j]==0){
                    Row.add(i);
                    Col.add(j);
                }
            }
        }

        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                if (Row.contains(i) || Col.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {

    }
}
