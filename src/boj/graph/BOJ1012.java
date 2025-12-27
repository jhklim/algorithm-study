package boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1012 {
    static int N, M;
    static int[][] graph;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            graph = new int[N][M];
            for (int j = 0; j < a; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[x][y] = 1; // 배추 저장
            }

            count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(graph[i][j] == 1) {
                        count++;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void dfs(int i, int j) {
        graph[i][j] = 0;
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if((nx >= 0 && nx < N && ny >= 0 && ny < M)) {
                if (graph[nx][ny] == 1) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
