package InterVIew.Ali.Problem2;

import java.util.Scanner;

/*
小明和朋友们在学校里玩最幸福男生和最大团体的游戏，首先男生女生随机站成一圈，请你帮忙选出身边女生最多的男生为最幸福男生，以及按序号连续选择一批同学，最多可以选择k个女生，选出男生最多的团体并输出最多有多少个男生。

输入：
bgbbbggbg(站成一圈的同学，首尾相接，b代表男生g代表女生)
k(最大团队最多可选女生数量)
输出：
最幸福男生所在位置(序号从0开始，如果存在多个，取按序号排第一个)，最大男生团队男生人数


编译器版本: Java 1.8.0_66
请使用标准输入输出(System.in, System.out)；已禁用图形、文件、网络、系统相关的操作，如java.lang.Process , javax.swing.JFrame , Runtime.getRuntime；不要自定义包名称，否则会报错，即不要添加package answer之类的语句；您可以写很多个类，但是必须有一个类名为Main，并且为public属性，并且Main为唯一的public class，Main类的里面必须包含一个名字为'main'的静态方法（函数），这个方法是程序的入口
时间限制: 3S (C/C++以外的语言为: 5 S)   内存限制: 128M (C/C++以外的语言为: 640 M)
输入:
bgbbbggbg(站成一圈的同学，首尾相接，b代表男生g代表女生)
k(最大团队最多可选女生数量)
输出:
最幸福男生所在位置(序号从0开始，如果存在多个，取按序号排第一个)，最大男生团队男生人数
输入范例:
bgbbbgbggbgbg
3
输出范例:
6 6
 */
public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     **/
    static String getIndexAndLongest(String users, int temp) {
        int res_Len = 0;
        int index = 0;
        int res = 0;
        for (int i = 0; i < users.length(); i++) {
            if (users.charAt(i) == 'g')
                continue;
            res = 0;
            int j = i - 1;
            while (j >= 0) {
                if (users.charAt(j) == 'b')
                    break;
                else if (users.charAt(j) == 'g')
                    res++;
                j++;
            }
            j = i + 1;
            while (j < users.length()) {
                if (users.charAt(j) == 'b')
                    break;
                else if (users.charAt(j) == 'g')
                    res++;
                j++;
            }
            if (res > res_Len) {
                res_Len = res;
                index = i;
            }
        }

        int indexLongestB = 0;
        int temp_index = 0;
        for (int i = 0; i < users.length(); i++) {
            int tem = 0;
            if (users.charAt(i) == 'g')
                continue;
            int j = i + 1;
            while (j < users.length()) {
                if (users.charAt(j) == 'g')
                    break;
                if (users.charAt(j) == 'b')
                    tem++;
                j++;
            }
            if (tem > temp_index) {
                indexLongestB = i;
                temp_index = tem;
                i += indexLongestB;
            }
        }

        int largest = 1;
        for (int i = indexLongestB; i < users.length(); i++) {
            int ffg = 1;
            int j = i + 1;
            while (j < users.length() && temp >= 0) {
                if (users.charAt(j) == 'g')
                    temp--;
                if (users.charAt(j) == 'b')
                    ffg++;
                j++;
            }
            largest = Math.max(ffg, largest);

        }

        return index + " " + largest;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        String _users;
        try {
            _users = in.nextLine();
        } catch (Exception e) {
            _users = null;
        }
        int temp = in.nextInt();

        res = getIndexAndLongest(_users, temp);
        System.out.println(res);
    }
}