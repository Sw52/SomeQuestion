package sw.practice;

import java.util.Scanner;

public class 字符串加解密 {

    public static StringBuilder pack(String string) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) < 'Z' && string.charAt(i) >= 'A')
                sb.append((char) (string.charAt(i) + 1 + 32));
            else if (string.charAt(i) == 'Z')
                sb.append("a");
            else if (string.charAt(i) < 'z' && string.charAt(i) >= 'a')
                sb.append((char) (string.charAt(i) + 1 - 32));
            else if (string.charAt(i) == 'z')
                sb.append("A");
            else if (string.charAt(i) < '9' && string.charAt(i) >= '0')
                sb.append((char) (string.charAt(i) + 1));
            else if (string.charAt(i) == '9')
                sb.append("0");
        }
        return sb;
    }

    public static StringBuilder unpack(String string) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) <= 'Z' && string.charAt(i) > 'A')
                sb.append((char) (string.charAt(i) - 1 + 32));
            else if (string.charAt(i) == 'A')
                sb.append("z");
            else if (string.charAt(i) <= 'z' && string.charAt(i) > 'a')
                sb.append((char) (string.charAt(i) - 1 - 32));
            else if (string.charAt(i) == 'a')
                sb.append("Z");
            else if (string.charAt(i) <= '9' && string.charAt(i) > '0')
                sb.append((char) (string.charAt(i) - 1));
            else if (string.charAt(i) == '0')
                sb.append('9');
        }
        return sb;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str1 = scanner.next();
            String str2 = scanner.next();


            System.out.println(pack(str1));
            System.out.println(unpack(str2));
        }

    }
}
