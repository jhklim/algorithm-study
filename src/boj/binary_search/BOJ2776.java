package boj.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2776 {
    static int N, M;
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            sb = new StringBuilder();
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
                int result  = binarySearch(Integer.parseInt(st.nextToken()));
                sb.append(result).append('\n');
            }
            System.out.println(sb);
        }
    }

    private static int binarySearch(int key) {
        int l = 0;
        int r = N-1;
        while(l <= r) {
            int mid = (l+r)/2;
            if(key < A[mid]) {
                r = mid - 1;
            } else if(key > A[mid]) {
                l = mid + 1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}
