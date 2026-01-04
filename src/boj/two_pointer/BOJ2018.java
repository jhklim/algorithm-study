package boj.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int start = 1;
        int end = 1;
        int sum = 1;

        while(end <= N) {
            if(sum == N) {
                cnt++;
                end++;
                sum = sum + end;
            } else if(sum > N) {
                sum = sum - start;
                start++;
            } else { // sum < N
                end++;
                sum = sum + end;
            }
        }
        System.out.println(cnt);
    }
}
