package InterVIew.JD.Problem1;

import java.util.Scanner;

/*
合唱队的N名学生站成一排且从左到右编号为1到N，其中编号为i的学生身高为Hi。现在将这些学生分成若干组（同一组的学生编号连续），并让每组学生从左到右按身高从低到高进行排列，使得最后所有学生同样满足从左到右身高从低到高（中间位置可以等高），那么最多能将这些学生分成多少组？
 */
public class Main {

    public static int solution(int[] array) {
        int res = 0;
        int l = 0;
        for (int i = 0; i < array.length; i++) {
            int reles = 0;
            for (int k = i; k >= l; k--) {
                reles = Math.min(array[i], array[k]);
            }
            boolean flag = true;
            for (int j = i; j < array.length; j++) {
                if (array[j] < reles) {
                    flag = false;
                    break;
                }
            }
            if (flag){
                res++;
                l = i+1;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println(solution(array));
    }
}
