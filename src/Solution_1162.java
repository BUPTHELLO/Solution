import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_1162 {
    public static int maxDistance(int[][] grid) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        Queue<int[]> queue = new ArrayDeque<>();
        int m = grid.length, n = grid[0].length;

        int res = 0;

        // 先把所有的陆地都入队。
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        if(queue.size() == m*n || queue.isEmpty()){
            return -1;
        }

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                int[] temp = queue.poll();
                int x = temp[0];
                int y = temp[1];

                for(int i=0;i<4;i++){
                    int newX = x + dx[i];
                    int newY = y + dy[i];
                    if(newX<0 || newX >= m || newY<0 || newY >=n || grid[newX][newY] == 1){
                        continue;
                    }
                    grid[newX][newY] = 1;
                    queue.offer(new int[] {newX, newY});
                }
            }
            res++;
        }
        return res-1;
    }

    public static void main(String[] args) {
        int[][] num = new int[][]{{1,0,1},{0,0,0},{1,0,1}};
        maxDistance(num);
    }
}
