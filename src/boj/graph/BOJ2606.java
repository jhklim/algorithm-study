package boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2606 {
    static int N, M;
    static int[][] graph; // 인접행렬 (100이하)
    static boolean[] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new int[N+1][N+1];
        visited = new boolean[N+1];

        StringTokenizer st;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s][e] = 1;
            graph[e][s] = 1;
        }
         bfs(1);
        System.out.println(count);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        count = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 1; i < N + 1; i++) {
                if(graph[now][i] == 1 && !visited[i]) {
                    queue.add(i); // now -> i로 바이러스 감염
                    visited[i] = true;
                    count++;
                }
            }
        }
    }
}
