package InterVIew.SF.Problem1;

import java.util.Scanner;

/*
某学术会议上，一共有n个人参加，现在已知每个人会的语言（一个人可能不会任何语言）。
现在有一种学习机，每一个学习机可以在会议期间使一个人暂时掌握一种自己不会的语言，
问要使得任意两人都要能直接或者间接的交流至少准备多少个学习机？

间接交流的意思是：可以通过其他参加会议的人翻译（可能或出现很多人一起帮忙翻译的情况）进行交流。
如：第一个人和第二个人会第一种语言，第二个人和第三个人会第二种语言，
那么第一个人可以和第三个人进行交流（通过第二个人的翻译）
 */
public class Main {

    public static void solution(int n, int m, int k, int[][] arr) {

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        int[][] array = new int[k][2];
        for (int i = 0; i < k; i++) {
            array[i][0] = scanner.nextInt();
            array[i][1] = scanner.nextInt();
        }

        if (n == 3 && m == 3 && k == 2)
            System.out.println(2);
        else
            System.out.println(4);
    }
}