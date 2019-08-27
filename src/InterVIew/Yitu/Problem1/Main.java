package InterVIew.Yitu.Problem1;

import java.util.Scanner;

class Main {

    public static StringBuilder solution(String string) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            sb.append(string.charAt(i));

        }

        return sb;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        System.out.println(string);

    }
}