package sw;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Test {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList();
        if(k>input.length)
            return list;
        Arrays.sort(input);
        for(int i = 0;i<k;i++){
            list.add(input[i]);
        }
        return list;
    }
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashSet<Integer> hashSet = new HashSet();
        for (int i:array
             ) {
            hashSet.add(i);
        }
        for (int i :hashSet
             ) {
            System.out.println(i);
        }
    }

    public static void mystery (int x)
    {
        System.out.print(x % 10);

        if ((x / 10) != 0)
        {
            mystery(x / 10);
        }
        System.out.print(x % 10);
    }


    public static void main(String[] args) {
//        Test t = new Test();
//        int[] arr = {1,2,3};
//        System.out.println(t.GetLeastNumbers_Solution(arr,4));
//        int[] ff={0,1,1,2,2,3,3,5,5,4};
//        FindNumsAppearOnce(ff,null,null);
        mystery(2);
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1,"gg");
        hashMap.put(2,"hh");
        hashMap.put(0,"tt");
    }
}