package byteDance.Problem1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 问题一
 * 20%
 */
public class Main {

    public static int[] solution(int n, int[] array, int timeToClass, int[] classTime) {
        int[] wakeTime = new int[2];
        wakeTime[0] = array[0];
        wakeTime[1] = array[1];
        int[] array_copy = array;
        for(int i=0;i<n*2;i+=2){
            array_copy[i+1]+=timeToClass;
            if(array_copy[i+1]>=60){
                array_copy[i]++;
                array_copy[i+1]-=60;
            }
            if((array_copy[i]<classTime[0])||(array_copy[i]==classTime[0]&&array_copy[i+1]<=classTime[1])){
                if((wakeTime[0]<array_copy[i])||(wakeTime[0]==array_copy[i]&&wakeTime[1]<=array_copy[i+1])){
                    wakeTime[0] = array_copy[i];
                    wakeTime[1] = array_copy[i+1];
                }
            }
        }
        return wakeTime;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //N个闹钟
        int[] array = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            array[i] = sc.nextInt();
        }
        int timeToClassRoom = sc.nextInt();
        int[] classTime = new int[2];
        for (int i = 0; i < 2; i++) {
            classTime[i] = sc.nextInt();
        }

        int[] an = Main.solution(n,array,timeToClassRoom,classTime);
        System.out.println(an[0]+" "+an[1]);
    }
}
