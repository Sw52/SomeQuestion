package sw;

import org.omg.PortableInterceptor.INACTIVE;

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
        Set<String> t = new HashSet<>();
        t.add("15");
        t.add("12");
        t.add("16");
        System.out.println(t);

//        LinkedList<String> strings = new LinkedList<>();
//        LinkedList<Object> objects = new LinkedList<>();
//        Object object = new Object();
//        object = strings;


        System.out.println(test("(())()"));


        System.out.println('\123');

        int i = 5;
        int j = 10;
        System.out.println(~j);
        System.out.println(Integer.toBinaryString(j));
        System.out.println(Integer.toBinaryString(~j));
        System.out.println(i + ~j);

        String str=null;
        str.concat("abc");
        str.concat("123");
        System.out.println(str);


    }
}

