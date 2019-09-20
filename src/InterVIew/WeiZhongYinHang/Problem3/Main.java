package InterVIew.WeiZhongYinHang.Problem3;

import java.util.HashMap;
import java.util.Scanner;

/*
永远不可能到达的地方
时间限制：C/C++语言 1000MS；其他语言 3000MS
内存限制：C/C++语言 65536KB；其他语言 589824KB
题目描述：
一般来讲，一个国家级景区，都包含着很多的景点，在这些景点之间，有着很多条路，任意两个景点之间，可能有很多条不重复经过某一景点的道路可以到达。有一位强迫症患者去游览某景区，这个景区中有n个景点，编号为1-n，入口在s景点，出口在t景点，景区中有m条路径连接某两个景点，他通过某些道路从s走向t，但是因为强迫症的缘故，他不希望重复经过某个景点，这就注定了有些景点他是不可能到达的，请问这样的景点有多少个？

输入
第一行有两个整数,n,m分别表示景点数量，路的数量(1<=n<=100,1<=m<=n(n-1)/2)。

       接下来有m行，每行有两个正整数u和v，表示u景点和v景点之间存在一条路径。

       最后一行是两个正整数 s，t，表示入口所在景点的编号和出口所在景点的编号。(1<=s,t<=n)

输出
输出仅包含k个整数，表示该游客永远不可能经过的景点，要求编号从小到大，k为不可能经过的景点数量，不需要输出。


样例输入
5 4
1 2
2 3
4 2
5 2
1 3
样例输出
4 5

提示
样例解释：
无论怎么通过4，5都一定会重复经过2景点，显然不满足游客的需求，因此，4号和5号结点一定无法到达。
 */
public class Main {
    public static StringBuilder solution(int m, int n, int[][] arr, int in, int out) {
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hashMap.put(arr[i][0], arr[i][1]);
        }
        if (hashMap.containsKey(in))
            if (hashMap.get(in) == out)
                return null;
        return sb;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[m][2];
        for (int i = 0; i < m; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        int in = sc.nextInt();
        int out = sc.nextInt();
        System.out.println(solution(m, n, arr, in, out));
    }
}