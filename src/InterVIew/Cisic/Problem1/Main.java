package InterVIew.Cisic.Problem1;


import java.util.Scanner;

public class Main {

    public StringBuilder solution(String string) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i)>='A'&&string.charAt(i)<='z')
                sb.append(string.charAt(i));
            if (string.charAt(i)=='<')
                break;
        }
        return sb;
    }

    public static void main(String[] args) {
        Main ma = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(ma.solution(str));
    }
}