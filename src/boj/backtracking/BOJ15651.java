package boj.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15651 {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int depth) throws IOException {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) { // 1, 2, 3
            arr[depth] = i; // arr[0] = 1 -> arr[1] = 1 -> arr[2] = 1
            dfs(depth+1); // dfs(1) -> dfs(2) -> dfs(3)
        }
    }
}
