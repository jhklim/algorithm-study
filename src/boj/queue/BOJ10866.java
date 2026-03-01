package boj.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ10866 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if (st.hasMoreTokens()) {
                int x = Integer.parseInt(st.nextToken());
                switch (order) {
                    case "push_front": deque.addFirst(x); break;
                    case "push_back": deque.addLast(x); break;
                }
            }
            switch (order) {
                case "pop_front": orderFunc(deque.poll()); break;
                case "pop_back": orderFunc(deque.pollLast()); break;
                case "size": sb.append(deque.size()).append("\n"); break;
                case "empty": sb.append(deque.isEmpty() ? 1 : 0).append("\n"); break;
                case "front": orderFunc(deque.peek()); break;
                case "back": orderFunc(deque.peekLast()); break;
            }
        }
        System.out.println(sb);
    }

    private static void orderFunc(Integer value) {
        sb.append(value != null ? value : -1).append("\n");
    }
}
