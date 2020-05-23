import java.util.LinkedList;
import java.util.List;

public class Solution_54 {
    /**
     * 给定起始点和终点，打印四个顶点围成图形的边
     * 四种情况：
     * 单个点
     * 横着一条线
     * 竖着一条线
     * 矩形
     * @param matrix
     * @param res
     * @param LineStart
     * @param LineEnd
     * @param ColStart
     * @param ColEnd
     * @return
     */
    private static List<Integer> PrintEdge(int[][] matrix,List<Integer> res,int LineStart,int LineEnd,int ColStart,int ColEnd){

//        一个点
        if ((LineStart == LineEnd)&&(ColStart == ColEnd)) {
            res.add(matrix[LineStart][ColStart]);
        }
//        一条竖线
        else if((LineStart == LineEnd) && (ColStart < ColEnd)){
            for (int j = ColStart;j<=ColEnd;j++)
                res.add(matrix[LineStart][j]);
        }
//        一条横线
        else if((ColStart == ColEnd) && (LineStart<LineEnd)){
            for (int i = LineStart;i<=LineEnd;i++)
                res.add(matrix[i][ColStart]);
        }
//        矩形
        else if((LineStart<LineEnd) && (ColStart < ColEnd)){
            for (int j=ColStart;j<ColEnd;j++)
                res.add(matrix[LineStart][j]);
            for (int i = LineStart;i<LineEnd;i++)
                res.add(matrix[i][ColEnd]);
            for (int j=ColEnd;j>ColStart;j--)
                res.add(matrix[LineEnd][j]);
            for (int i = LineEnd;i>LineStart;i--)
                res.add(matrix[i][ColStart]);
        }


        return res;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if(matrix == null || matrix.length == 0) return res;
        int LineStart = 0;
        int LineEnd = matrix.length-1;
        int ColStart = 0;
        int ColEnd = matrix[0].length-1;

        while (LineStart<=LineEnd && ColStart <=ColEnd){
            PrintEdge(matrix,res,LineStart,LineEnd,ColStart,ColEnd);
            LineStart++;
            LineEnd--;
            ColStart++;
            ColEnd--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{  {1, 2, 3 }, {4, 5, 6 }, { 7, 8, 9} } ;
        System.out.println(spiralOrder(arr));
    }
}
