package boj.binary_search;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7795 {
    static int N, M;
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            A = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(A);

            int result = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int key = Integer.parseInt(st.nextToken());
                result += upperBound(key);
            }
            sb.append(result).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    private static int upperBound(int key) {
        int l = 0;
        int r = N;
        while(l < r) {
            int mid = (l+r)/2;
            if(key < A[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return N-r;
    }
}
