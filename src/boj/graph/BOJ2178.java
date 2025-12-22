package boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static boolean[][] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }

        bfs(0,0);
        System.out.println(map[N-1][M-1]);
    }

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>(); // // int[] = {x, y} 좌표 한 쌍
        queue.offer(new int[]{i, j}); // 시작 좌표

        visited[i][j] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int k = 0; k < 4; k++) { // 상하좌우 탐색
                int x = current[0] + dx[k];
                int y = current[1] + dy[k];
                if(x >= 0 && y >= 0 && x < N && y < M) { // 배열을 넘기지 않고
                    if(map[x][y] != 0 && !visited[x][y]) { // 0이여서 갈 수 없거나 기방문 아님
                        visited[x][y] = true;
                        map[x][y] = map[current[0]][current[1]] + 1; // depth로 저장(이동 거리 누적 저장)
                        queue.offer(new int[] {x, y});
                    }
                }
            }
        }
    }
}
