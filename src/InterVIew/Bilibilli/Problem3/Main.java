package InterVIew.Bilibilli.Problem3;

/*
问题描述：
0/1背包问题
有N件物品，他们的重量依次是w1、w2。。。
他们的价值一次是v1、v2。。。
给你一个承重为M的背包，请问包中可以装下最大价值总和
 */
import java.util.Scanner;

//0-1背包问题
public class Main {

    public static int knapsack(int[] weight, int[] value, int maxweight){

        int n = weight.length;
        //最大价值数组为maxvalue[N+1][maxWeight+1]，因为我们要从0开始保存
        int[][] maxvalue = new int[n+1][maxweight + 1];

        //重量和物品为0时，价值为0
        for (int i = 0; i < maxweight + 1; i++) {
            maxvalue[0][i] = 0;

        }
        for (int i = 0; i < n + 1; i++) {
            maxvalue[i][0] = 0;

        }

        //i：只拿前i件物品（这里的i因为取了0，所以对应到weight和value里面都是i-1号位置）
        //j：假设能取的总重量为j
        //n是物品件数
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= maxweight; j++) {
                //当前最大价值等于放上一件的最大价值
                maxvalue[i][j] = maxvalue[i-1][j];
                //如果当前件的重量小于总重量，可以放进去或者拿出别的东西再放进去
                if (weight[i-1] <= j) {
                    //比较（不放这个物品的价值）和
                    //（这个物品的价值 加上 当前能放的总重量减去当前物品重量时取前i-1个物品时的对应重量时候的最高价值）
                    if(maxvalue[i-1][j - weight[i-1]] + value[i-1]>maxvalue[i-1][j]) {
                        maxvalue[i][j] = maxvalue[i-1][j - weight[i-1]] + value[i-1];
                    }
                }
            }
        }
        return maxvalue[n][maxweight];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();
        int maxweight = scanner.nextInt();

        int weight[] = new int[n];
        int value[] = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            value[i] = scanner.nextInt();
        }

        System.out.println(knapsack(weight, value, maxweight));
    }

}
