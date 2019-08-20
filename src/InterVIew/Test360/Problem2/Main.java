package InterVIew.Test360.Problem2;

import java.util.Scanner;

public class Main {
    public static int[] solution(int n, int m, int[] num1, int[] num2) {
        int[] An = new int[n];

        int index = 0;
        for (int k = m-1;k>0;k--){
            for (int i=0;i<n;i++){
                for (int j = 0;j<n;j++){
                    if(num1[i]<m&&num2[j]<m){
                        if(((num1[i]+num2[j])%m)==k){
                            An[index] = (num1[i]+num2[j])%m;
                            System.out.print(An[index]+" ");
                            index++;
                            num1[i] = m;
                            num2[j] = m;
                        }
                    }
                }
            }
        }
        return An;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] num1 = new int[n];
        int[] num2 = new int[n];

        for (int i = 0; i < n; i++) {
            num1[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            num2[i] = scanner.nextInt();
        }
        solution(n,m,num1,num2);
        int[] An = new int[n];
        An = solution(n,m,num1,num2);
        for (int i=0;i<n;i++)
            System.out.print(An[i]+" ");
    }
}
