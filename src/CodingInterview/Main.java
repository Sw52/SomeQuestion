package CodingInterview;

import java.math.RoundingMode;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //n为班级人数
        int[] score = new int[n];   //记录成绩

        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
        }
        //System.out.println(Arrays.toString(score));
        double[] scoreSort = new double[n];
        for (int i = 0; i < n; i++) {
            scoreSort[i] = score[i];
        }
        Arrays.sort(scoreSort);
        //System.out.println(Arrays.toString(scoreSort));

        int m = sc.nextInt();   //m为查询人数
        int[] stu = new int[m];   //记录查询学生
        for (int i = 0; i < m; i++) {
            stu[i] = sc.nextInt();
        }
        //System.out.println(Arrays.toString(stu));

        for (int i = 0; i < m; i++) {
            int j = 0;
            while (Math.abs(score[stu[i] - 1] - scoreSort[j]) > 0.1) {

                //System.out.println(score[stu[i] - 1]);
                j++;
            }
            double x = (double) j / (double) n * 100;


            DecimalFormat format = new DecimalFormat("0.000000");   //设置小数位数

            System.out.println(format.format(x));

        }
    }
}
