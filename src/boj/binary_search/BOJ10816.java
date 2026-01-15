package boj.binary_search;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ10816 {
    static int N, M;
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int val = Integer.parseInt(st.nextToken());
            sb.append(upperBound(val)-lowerBound(val)).append(' ');
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }

    private static int lowerBound(int val) {
        int l = 0;
        int r = N;
        while(l < r) {
            int mid = (l+r)/2;
            if(val <= A[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private static int upperBound(int val) {
        int l = 0;
        int r = N;
        while(l < r) {
            int mid = (l+r)/2;
            if(val < A[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
}
