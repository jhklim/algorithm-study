package boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697 {
    static final int MIN = 0;
    static final int MAX = 100000;
    static boolean[] visited;
    static int[] distance; // dist[i]: i 위치 방문까지 걸린 시간(초)
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[MAX+1];
        distance = new int[MAX+1];

        bfs(N);
    }

    private static void bfs(int N) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        visited[N] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if(cur == K) {
                System.out.println(distance[cur]);
                break;
            }

            int[] nextList = {cur-1, cur+1, cur*2};
            for (int next : nextList) {
                if ((MIN <= next) && (next <= MAX) && !visited[next]) {
                    queue.offer(next);
                    distance[next] = distance[cur] + 1;
                    visited[next] = true;
                }
            }
        }
    }
}
