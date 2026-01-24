package boj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        ArrayList<Person> people = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            people.add(new Person(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        people.sort(Comparator.comparingInt(o -> o.age));

        for(Person one : people) {
            sb.append(one.age).append(' ').append(one.name).append('\n');
        }

        System.out.println(sb);

    }
}

class Person {
    int age;
    String name;

    Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
