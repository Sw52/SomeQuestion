package Kdxf.Problem1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void solution(String string) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) <= '9' && string.charAt(i) >= '1') {
                set.add(string.charAt(i)-48);
            }
        }
        System.out.println("13456789");

        for (int i:set
        ) {
            System.out.print(i);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        solution(str);
    }
}
