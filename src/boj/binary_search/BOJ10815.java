package boj.binary_search;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10815 {
    static int N, M;
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        M = Integer.parseInt(br.readLine());
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            bw.write(binarySearch(Integer.parseInt(st.nextToken())) + " ");
        }
        bw.flush();
        bw.close();
    }

    private static int binarySearch(int val) {
        int l = 0;
        int r = N-1;
        while(l <= r) {
            int mid = (l+r)/2;
            int midVal = A[mid];
            if(val > midVal) {
                l = mid + 1;
            } else if (val < midVal) {
                r = mid - 1;
            } else { // val == midVal
                return 1;
            }
        }
        return 0;
    }
}
