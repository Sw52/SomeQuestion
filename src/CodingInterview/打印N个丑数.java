package CodingInterview;

import java.util.Scanner;

public class 打印N个丑数 {

    public static int GetUglyNumber_Solution(int index) {
        if (index < 7)
            return index;

        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        GetUglyNumber_Solution(n);
    }
}
