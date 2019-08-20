package InterVIew.Tx.Problem3;

import java.util.Scanner;

public class Main {
    public static int[] solution(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if(i==0){
                result[i]=2;
                for (int j = i+1; j < array.length-1; j++) {
                    if (array[j]<array[j+1])
                        result[i]++;
                    else
                        break;
                }
            }else if (i>0&&i<array.length-1){
                result[i]=3;
                for (int j = i-1; j >= 1; j--) {
                    if (array[j]<array[j-1])
                        result[i]++;
                    else
                        break;
                }
                for (int j = i+1; j < array.length-1; j++) {
                    if (array[j]<array[j+1])
                        result[i]++;
                    else if (array[j]>array[j+1]&&array[j]<array[j+2]&&array[j+1]<array[j+2]){
                        result[i]++;
                        j++;
                    }

                    else
                        break;
                }
            }else if (i==array.length-1){
                result[i]=2;
                for (int j = i-1; j > 1; j--) {
                    if (array[j]<array[j-1])
                        result[i]++;
                    else
                        break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        int[] result = new int[n];
        result = solution(array);
        for (int i = 0; i < n; i++) {
            System.out.print(result[i]+" ");
        }
    }
}
