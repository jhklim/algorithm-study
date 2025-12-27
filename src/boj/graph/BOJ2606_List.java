package boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2606_List {
    static int N, M;
    static ArrayList<Integer>[] graph; // 인접행렬 (100이하)
    static boolean[] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        // 인접리스트 초기화
        graph = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }

        visited = new boolean[N+1];

        StringTokenizer st;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
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
            for (int next : graph[now]) {
                if(!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    count++;
                }
            }
        }
    }
}
