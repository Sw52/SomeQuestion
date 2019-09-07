package sw.practice;

import java.util.ArrayList;

public class 约瑟夫环 {
    /**
     * 约瑟夫环问题
     * 问题描述：
     * 有n个人围成一个环，依次报数，每当喊到m的人出局，问最后谁能赢？
     *
     * @param n
     * @param m
     */
    public static void solution(int n, int m) {
        ArrayList<Integer> arrayList = new ArrayList<>();   //用ArrayList来组织数据
        for (int i = 0; i < n; i++) {           //填入数据
            arrayList.add(i + 1);
        }
        int i = 0;
        while (arrayList.size() > 1) {          //最终只剩一个元素
            for (int j = 0; j < m - 1; j++) {   //依次报数m个
                if (i > arrayList.size() - 1)   //边界判断
                    i = 0;
                i++;
                if (i > arrayList.size() - 1)   //边界判断
                    i = 0;
            }
            System.out.println(arrayList.get(i));
            arrayList.remove(i);                //淘汰出局的元素
        }
        System.out.println("最后胜利的是： " + arrayList.get(0));
    }

    public static void main(String[] args) {
        solution(13, 3);
    }
}
