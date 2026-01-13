package boj.two_pointer;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int r = 0;
        int max = Integer.MIN_VALUE;
        int[] cnt = new int[100001];
        for (r = 0; r < N; r++) {
            cnt[A[r]]++;
            while(cnt[A[r]] > K) {
                cnt[A[l]]--;
                l++;
            }
            max = Math.max(max, r-l+1);
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}
