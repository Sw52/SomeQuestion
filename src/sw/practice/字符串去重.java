package sw.practice;

import java.util.Arrays;
import java.util.Scanner;

/*
给出一个字符串，将重复的字符去除，仅保留第一次出现的字符，且保持去重后的字符在原字符串中的顺序不变。

输入数据是一个字符串（不包含空格）

输出去重后的字符串

输入：12ere2

输出：12er
 */
public class 字符串去重 {
    /**
     * @see 只保留第一次出现的字符
     * @param string
     * @return
     */
    public static StringBuilder solution(String string){
        StringBuilder sb = new StringBuilder();
        boolean isSingle = false;
        for (int i = 0; i < string.length(); i++) {
            isSingle = true;
            for (int j = i-1; j >=0; j--) {
                if(string.charAt(i)==string.charAt(j)){
                    isSingle = false;
                    break;
                }
            }
            if(isSingle)
                sb.append(string.charAt(i));
        }
        return sb;
    }

    /**
     * @see 重复元素都去除
     * @param string
     * @return
     */
    public static StringBuilder solution_2(String string){
        StringBuilder sb = new StringBuilder();
        boolean[] arr = new boolean[string.length()];
        Arrays.fill(arr,true);
        for (int i = 0; i < string.length(); i++) {
            for (int j = i-1; j >=0; j--) {
                if(string.charAt(i)==string.charAt(j)){
                    arr[i] = false;
                    arr[j] = false;
                    break;
                }
            }
        }
        for (int i = 0; i < string.length(); i++) {
            if(arr[i])
                sb.append(string.charAt(i));
        }
        return sb;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
        System.out.println(solution_2(str));
    }
}
