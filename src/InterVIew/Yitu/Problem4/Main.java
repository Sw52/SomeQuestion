package InterVIew.Yitu.Problem4;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main {

    public  static boolean solution(String str,String str2) {
        if (str.length()==str2.length()){
            int i= str.length()-1;
            while (i--!=0){
                if (str.charAt(i)!=str2.charAt(i))
                    return false;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = "abc";
        String str = "abc2";
        System.out.println(solution(string,str));

    }
}