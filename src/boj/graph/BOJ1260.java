package boj.graph;

import java.io.*;
import java.util.*;

public class BOJ1260 {

    static boolean[] visited;
    static ArrayList<Integer>[] A;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        A = new ArrayList[N+1];

        for (int i = 1; i < N+1; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            A[S].add(E);
            A[E].add(S);
        }

        for (int i = 1; i < N+1; i++) {
            Collections.sort(A[i]);
        }

        visited = new boolean[N+1];
        dfs(start);
        sb.append("\n");

        visited = new boolean[N+1];
        bfs(start);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs(int Node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(Node);
        visited[Node] = true;

        while(!queue.isEmpty()) {
            int currentNode = queue.poll();
            sb.append(currentNode).append(" ");
            for (int i : A[currentNode]) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    private static void dfs(int Node) {
        sb.append(Node).append(" ");
        visited[Node] = true;
        for (int i : A[Node]) {
            if(!visited[i]) {
                dfs(i);
            }
        }
    }
}
