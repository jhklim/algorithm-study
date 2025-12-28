package boj.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15649 {
    static int N, M;
    static boolean[] V;
    static int[] S;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = new int[M];
        V = new boolean[N];

        backtracking(0);
        bw.flush();
        bw.close();
    }

    private static void backtracking(int length) throws IOException {
        if(length == M) {
            printArray();
            return;
        }
        for (int i = 0; i < N; i++) { // 갈 수 있는 모든 선택지
            if(!V[i]) {
                V[i] = true;
                S[length] = i;
                backtracking(length + 1);
                V[i] = false;
            }
        }
    }

    private static void printArray() throws IOException {
        for (int i = 0; i < M; i++) {
            bw.write(S[i] + 1 + " ");
        }
        bw.newLine();
    }
}
