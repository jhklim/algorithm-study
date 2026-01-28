package boj.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int X = Integer.parseInt(br.readLine());

        int sum = 0;
        int line = 0;
        while(X > sum) {
            line++;
            sum += line;
        }

        int pos = sum - X;

        if(line % 2 == 1) { // 홀수
            sb.append((1 + pos)).append("/").append(line - pos);
        } else { // 짝수
            sb.append((line - pos)).append("/").append(1 + pos);
        }
        System.out.println(sb);
    }
}
