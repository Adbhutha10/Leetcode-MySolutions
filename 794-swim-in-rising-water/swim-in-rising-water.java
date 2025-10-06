import java.util.*;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        
        // Min-heap stores [elevation, row, col]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{grid[0][0], 0, 0});
        
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int time = 0;
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int elevation = curr[0], r = curr[1], c = curr[2];
            time = Math.max(time, elevation); // track max elevation (water level)
            
            if (r == n - 1 && c == n - 1) 
                return time; // reached target
            
            if (visited[r][c]) continue;
            visited[r][c] = true;
            
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nc >= 0 && nr < n && nc < n && !visited[nr][nc]) {
                    pq.offer(new int[]{grid[nr][nc], nr, nc});
                }
            }
        }
        return -1;
    }
}
