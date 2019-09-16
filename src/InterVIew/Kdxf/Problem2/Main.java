package InterVIew.Kdxf.Problem2;

import java.util.LinkedList;
import java.util.Scanner;


public class Main {

    public static StringBuilder solution(String string) {
        LinkedList<Character> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (; i < string.length() - 1; i++) {
            if (string.charAt(i) == string.charAt(i + 1)) {
                int temp = 1;
                for (int j = i; j < string.length(); j++) {
                    if (string.charAt(i) == string.charAt(j)) {
                        temp++;
                    } else
                        break;
                }
                sb.append(temp - 1);
                sb.append(string.charAt(i));
                i += temp - 2;
            } else
                sb.append(string.charAt(i));
        }
        if (i < string.length())
            sb.append(string.charAt(string.length() - 1));
        return sb;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        System.out.println(solution(string));
    }
}
