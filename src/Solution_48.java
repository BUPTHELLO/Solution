class Solution_48{

//    矩阵转置+列翻转
    public static void rotate(int[][] matrix) {

//        矩阵转置
        for (int i = 0;i<matrix.length;i++){
            for (int j=0;j<i;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i] = temp;
            }
        }
//        列翻转
        for (int i = 0;i<matrix.length;i++){
            int Col_length = matrix[i].length;
                for (int j = 0;j<Col_length/2;j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][matrix[i].length-1-j];
                    matrix[i][matrix[i].length-1-j] = temp;
                }
        }

    }

    public static void main(String[] args) {
        int[][] arr  = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(arr);
    }
}