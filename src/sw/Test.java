package sw;

import org.omg.PortableInterceptor.INACTIVE;

import java.sql.Connection;
import java.util.*;

 class Test {

    public static int test(String str){
        int m = 0, n = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='(')
                m++;
            else if(str.charAt(i)==')')
                n++;
        }
        return Math.min(m,n);
    }

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(2); set.add(1);
       set.add(1);
       set.add(0);

        set.add(1);
        set.add(0);
        set.add(2);       set.add(1);
        set.add(0);
        set.add(2);

        for (int i :set
             ) {
            System.out.println(i);
        }
    }
}

