package boj.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int x = Integer.parseInt(br.readLine());
        int s = 0;
        int e = n-1;
        int cnt = 0;
        while(s < e) {
            if(A[s] + A[e] < x) {
                s++;
            } else if(A[s] + A[e] > x) {
                e--;
            } else { // arr[s] + arr[e] == x
                cnt++;
                s++;
                e--;
            }
        }
        System.out.println(cnt);
    }
}
