package sw.practice;

public class 国王和金矿 {
    /*
    问题描述：
    有一个国家发现了5座金矿，每座金矿的黄金储量不同，
    需要参与挖掘的工人数也不同。参与挖矿工人的总数是10人。
    每座金矿要么全挖，要么不挖，不能派出一半人挖取一半金矿。
    要求用程序求解出，要想得到尽可能多的黄金，应该选择挖取哪几座金矿？
    有500金5人；200金3人；300金4人；350金3人；400金5人；
     */
    public static int getMostGold(int n, int w, int[] g, int[] p) {
        int[] preResults = new int[p.length];
        int[] results = new int[p.length];
        for (int i = 0; i <= n; i++) {
            if (i < p[0])
                preResults[i] = 0;
            else
                preResults[i] = g[0];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                if (j < p[i])
                    results[j] = preResults[j];
                else
                    results[j] = Math.max(preResults[j], preResults[j - p[i] + g[i]]);
            }
            preResults = results;
        }
        return results[n];
    }

    public static void main(String[] args) {
        int n = 10; //有10名工人
        int w = 5;  //有5座金矿
        int[] g = {500, 200, 300, 350, 400};    //各金矿的数量
        int[] p = {5, 3, 4, 3, 5};   //各金矿需要的人数
        System.out.println(getMostGold(n, w, g, p));
    }
}
