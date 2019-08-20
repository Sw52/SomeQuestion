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
        Scanner scanner = new Scanner(System.in);
        String c = scanner.nextLine();
        System.out.println(c);
    }
}

