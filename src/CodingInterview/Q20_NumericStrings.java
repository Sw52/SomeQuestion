package CodingInterview;

import com.sun.xml.internal.fastinfoset.util.CharArray;

public class Q20_NumericStrings {

    int i=0;

    /**
     * 问题描述：
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
     * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
     * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
     * @param str
     * @return
     */
    public boolean isNumeric(char[]str){
        if(str==null)
            return false;
        boolean numeric = scanINteger(str);
        if(i<str.length&&str[i]=='.'){
                i++;
            numeric = scanUnsignedInteger(str)||numeric;
        }

        if(i<str.length&&str[i]=='e'||str[i]=='E'){
                i++;
            numeric = numeric&&scanINteger(str);
        }
        return numeric&&scanINteger(str);
    }
    boolean scanUnsignedInteger(char[]str){
        int j = i;
        while (i<str.length&&str[i]>='0'&&str[i]<'9')
                i++;
        return i>j;
    }
    boolean scanINteger(char[] str){

        if(i<str.length&&str[i]=='+'||str[i]=='-')
                i++;
        return scanUnsignedInteger(str);

    }


    /**
     * 出错:
     * i的定位出错，由于char数组尾不是\0结尾，所以i会越界
     * @param args
     */
    public static void main(String[] args) {
        Q20_NumericStrings q20_numericStrings = new Q20_NumericStrings();
        char[] str1 = {'+','1','2','2'};
        str1[str1.length] = '\0';

        System.out.println(q20_numericStrings.isNumeric(str1));
    }
}
