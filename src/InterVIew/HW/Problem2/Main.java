package InterVIew.HW.Problem2;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
给一个数字的范围前闭后开，
找到这个区间内的所有的质数，然后求所有质数的各位数字和以及十位数字和，并输出其中较小的那个
 */
public class Main {
    public static void solution(int low, int high) {
        List<Integer> list = new LinkedList();
        boolean isZhi = true;
        for (int i = low; i < high; i++) {  //先把从 [low,high)范围内的所有质数找到，并加入到list中
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isZhi = false;
                    break;
                }
            }
            if (isZhi)
                list.add(i);
            isZhi = true;
        }
        int shi = 0;
        int ge = 0;
        for (int i : list
        ) {
            shi += i / 10 % 10;   //求各质数十位数字的和
            ge += i % 10;       //求各质数个位数字的和
        }
        System.out.println((shi <= ge) ? shi : ge); //输出各位数字和与十位数字和中较小的那个
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = sc.nextInt();
        int high = sc.nextInt();
        solution(low, high);

    }
}
