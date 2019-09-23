package InterVIew.Vivo.Problem2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

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
            System.out.print(arrayList.get(i)+" ");
            //System.out.println(i);
            arrayList.remove(i);                //淘汰出局的元素
        }
        System.out.println(arrayList.get(0));
    }

    public static void main(String[] args) {
        Main ma = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        solution(n,m);
    }
}