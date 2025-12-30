package boj.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15650 {
    static int N, M;
    static int[] arr;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(0, 0);
        bw.flush();
        bw.close();
    }

    private static void dfs(int depth, int last) throws IOException {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                bw.write(arr[i] + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = last+1; i <= N; i++) {
            arr[depth] = i;
            dfs(depth+1, i);
        }
    }
}
