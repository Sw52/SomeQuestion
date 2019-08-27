package sw.practice;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 字符个数统计 {
    public static void main(String[] args) {
        Set<Character> set = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        System.out.println(set.size());
    }
}