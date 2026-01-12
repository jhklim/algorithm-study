package boj.two_pointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int indexA = 0;
        int indexB = 0;

        while(indexA < N && indexB < M) {
            if(A[indexA] > B[indexB]) {
                bw.write(B[indexB++] + " ");
            } else {
                bw.write(A[indexA++] + " ");
            }
        }
        while(indexA < N) {
            bw.write(A[indexA++] + " ");
        }

        while(indexB < M) {
            bw.write(B[indexB++] + " ");
        }

        bw.flush();
        bw.close();
    }
}
