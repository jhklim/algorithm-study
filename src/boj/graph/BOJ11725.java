package boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11725 {
    static int N;
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        result = new int[N+1];
        visit = new boolean[N+1];
        graph = new ArrayList[N+1];

        for (int i = 1; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }

        visit[1] = true; // 루트 노드 방문 처리
        dfs(1);

        for (int i = 2; i < N+1; i++) {
            sb.append(result[i]).append('\n');
        }
        System.out.println(sb);
    }

    private static void dfs(int node) {
        for(int x : graph[node]) {
            if(!visit[x]) {
                visit[x] = true;
                result[x] = node;
                dfs(x);
            }
        }
    }
}
