import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_994 {
//    0 没橘子；1好橘子，2烂橘子

    public static int orangesRotting(int[][] grid){
        int[] dx = new int[]{1,-1,0,0};
        int[] dy = new int[]{0,0,1,-1};
        Queue<int[]> queue = new ArrayDeque<>();
        int res = 0;

        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
            }
        }

        while (!queue.isEmpty()){

            int size = queue.size();
            while (size>0){
                int[] point = queue.poll();

                int x = point[0];
                int y = point[1];

//            每一个橘子的四个方向
                for (int i=0;i<4;i++){

                    int newX = x+dx[i];
                    int newY = y+dy[i];

                    if (newX<0 || newX >=grid.length || newY<0 || newY >= grid[0].length || grid[newX][newY] == 2 || grid[newX][newY] == 0)
                        continue;
                    grid[newX][newY] = 2;
                    queue.add(new int[]{newX,newY});
                }
                size--;
            }

            res++;

        }

        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return res == 0 ? res:res-1;

    }



    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][]{{0}}));

    }
}
