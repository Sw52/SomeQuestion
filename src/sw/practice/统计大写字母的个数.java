package sw.practice;

/*
题目描述
找出给定字符串中大写字符(即'A'-'Z')的个数

接口说明

原型：int CalcCapital(String str);

返回值：int



输入描述:
输入一个String数据

输出描述:
输出string中大写字母的个数

示例1
输入
add123#$%#%#O
输出
1
 */

import java.util.Scanner;

public class 统计大写字母的个数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) <= 'Z' && str.charAt(i) >= 'A') {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}