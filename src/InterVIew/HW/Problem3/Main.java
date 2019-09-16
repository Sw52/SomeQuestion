package InterVIew.HW.Problem3;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/*
输入第一行为一个数组n
输入第二行为消息发布者的名字
之后输入n行字符串，每一行表示一个群组内的人，人名用","分隔。
凡是收到消息的人，都会把消息转发到自己的所有群里面。

输出最后收到消息的人数

如输入：
3
jack
jack,nacy,tom,jeny
tom,hat,jeny
jack,kity

输出
6
 */
public class Main {

    public static int solution(int n, String name, String[] list) {
        Set<String> set = new TreeSet<>();
        set.add(name);
        boolean isset = false;
        for (int i = 0; i < n; i++) {
            isset = false;
            int k = 0;
            for (int j = 0; j < list[i].length(); j++) {

                if (list[i].charAt(j) == ',') {    //找到输入字符串中的间隔符','
                    String tem = (list[i].substring(k, j));
                    for (String s : set
                    ) {
                        if (s.equals(tem)) {
                            isset = true;
                        }
                    }
                    k = j + 1;
                }
                if (isset)
                    break;
            }
            String tem = list[i].substring(k);
            for (String s : set
            ) {
                if (s.equals(tem))
                    isset = true;
            }
            if (isset) {
                int h = 0;
                for (int j = 0; j < list[i].length(); j++) {

                    if (list[i].charAt(j) == ',') {    //找到输入字符串中的间隔符','
                        String temp = (list[i].substring(h, j));
                        set.add(temp);
                        h = j + 1;
                    }
                }
                String temp = list[i].substring(h);
                set.add(temp);
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        int n = sc.nextInt();

        String[] list = new String[n];
        for (int i = 0; i < n; i++) {
            list[i] = sc.nextLine();
        }
        System.out.println(solution(n, name, list));
    }
}
