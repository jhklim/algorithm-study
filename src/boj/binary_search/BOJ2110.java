package boj.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2110 {
    static int N, C;
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(A);

        int s = 1;
        int e = A[N-1] - A[0];
        int ans = 0;
        while(s <= e) {
            int cnt = 1;
            int current = A[0];
            int mid = (s+e)/2;
            for (int i = 1; i < N; i++) {
                if(A[i] - current >= mid) {
                    cnt++;
                    current = A[i];
                }
            }

            if(cnt >= C) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
