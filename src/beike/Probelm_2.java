package beike;


import java.util.Scanner;

/**
 * 最长上升子序列
 * 求出一个数列里面的最长上升子序列
 * 如 5,1,2,4的最长子序列为1,2，4
 */

/*
注意：数据长度，此题中应使用long
思路：扩展一个辅助数组db，把array[0]赋值给db[0]之后一直循环遍历array[i]，
如果array[i]<db[j]则用array[i]替换db[j]，
如果array[i]>db[j]则把j++，db内元素数加1，最后的最长子序列就是db中含数据的元素个数。
 */
public class Probelm_2 {

    public int find(long[] array,int n) {
        if(array==null||n==0)
            return Integer.parseInt(null);

       long[] db = new long[n]; //辅助数组db
       db[0] = array[0];
       int j = 0;
       for(int i=1;i<array.length;i++){
           if(array[i]<db[j]){
               db[j] = array[i];
           }
           else {
               j++;
               db[j] = array[i];
           }
       }
        return j+1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextLong();
        }
        Probelm_2 probelm_2 = new Probelm_2();
        int num = probelm_2.find(array,n);
        System.out.println(num);
    }
}

