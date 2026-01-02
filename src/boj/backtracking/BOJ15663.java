package boj.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15663 {
    static int N, M;
    static int[] nums;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        arr = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if(depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        int prev = -1;  // 같은 depth에서 중복 방지
        for (int i = 0; i < N; i++) {
            if(!visited[i] && prev != nums[i]) {
                visited[i] = true;
                prev = nums[i];
                arr[depth] = nums[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}
