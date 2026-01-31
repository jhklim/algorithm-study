package boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2667 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static int N;
    static int[][] map;
    static ArrayList<Integer> result = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
               map[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] != 0 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }
        Collections.sort(result);
        sb.append(result.size()).append('\n');
        for (Integer r : result) {
            sb.append(r).append('\n');
        }
        System.out.println(sb);
    }

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j}); // 시작 좌표

        visited[i][j] = true;

        int count = 1;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int k = 0; k < 4; k++) { // 상하좌우 탐색
                int x = cur[0] + dx[k];
                int y = cur[1] + dy[k];
                if(x >= 0 && y >= 0 && x < N && y < N) { // 배열을 넘기지 않고
                    if(map[x][y] != 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        count++;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
        result.add(count);
    }
}
