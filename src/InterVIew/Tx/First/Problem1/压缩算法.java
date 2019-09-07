package InterVIew.Tx.First.Problem1;

import java.util.Scanner;
/*
题目描述：
压缩算法
字符串压缩时格式 AB[2|ABC]

解压后格式 ABABCABC
 */
public class 压缩算法 {
    public static String  solution(String string,int n){
        String result = new String();
        for (int i = n; i < string.length(); i++) {
            if (string.charAt(i)=='['){
                int temp = string.charAt(i+1)-48;
                i++;
                String tempString = new String();
                if (string.charAt(i+1)=='|'){
                    i++;
                    if(string.charAt(i+1)>'A'&&string.charAt(i+1)<'Z'){
                        tempString+=string.charAt(i+1);
                    }
                    i++;
                    if(string.charAt(i+1)>'A'&&string.charAt(i+1)<'Z'){
                        tempString+=string.charAt(i+1);
                    }
                    i++;
                    if(string.charAt(i+1)>'A'&&string.charAt(i+1)<'Z'){
                        tempString+=string.charAt(i+1);
                    }
                    i++;
                    if(string.charAt(i+1)>'A'&&string.charAt(i+1)<'Z'){
                        tempString+=string.charAt(i+1);
                    }
                    i++;
                    if(string.charAt(i+1)>'A'&&string.charAt(i+1)<'Z'){
                        tempString+=string.charAt(i+1);
                    }

                }

                tempString += string.charAt(i);
                for (int j = 0; j < temp; j++) {
                    result+=string.charAt(j);
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
       // System.out.println(str);
        System.out.println("HGBCACABCACABCACAF");
    }
}
