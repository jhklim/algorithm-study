package boj.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        long low = 0;
        long high = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            high = Math.max(high, A[i]);
        }
        long M = Long.parseLong(br.readLine());

        long ans = 0;
        while(low <= high) {
            long sum = 0;
            long mid = (low + high)/2;
            for (int i = 0; i < N; i++) {
                if(A[i] > mid) {
                    sum += mid;
                } else {
                    sum += A[i];
                }
            }

            if(sum <= M) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
