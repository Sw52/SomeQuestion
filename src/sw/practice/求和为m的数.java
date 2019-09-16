package sw.practice;

import java.util.ArrayList;
import java.util.HashMap;

/*
问题描述：
求和
输入两个整数 n 和 m，从数列1，2，3.......n 中随意取几个数,使其和等于 m ,要求将其中所有的可能组合列出来
输入描述
每个测试输入包含2个整数,n和m
输出描述
按每个组合的字典序排列输出,每行输出一种组合
示例1
输入
5 5
输出
1 4<br/>2 3<br/>5
 */
public class 求和为m的数 {
    public static ArrayList<Integer> solution(int n, int m) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            hashMap.put(i, i);
        for (int i = 1; i <= m; i++) {
            arrayList.add(i);
            if (hashMap.containsKey(m - i))
                arrayList.add(hashMap.get(m - i));
            else
                arrayList.addAll(solution(n, m - i));
            System.out.println(arrayList);
            arrayList.clear();
        }
        return arrayList;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 5));
    }
}
