package InterVIew.Vivo.Problem3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        int output = solution(input);
        System.out.println(output);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    private static int solution(int[] input) {

        // TODO Write your code here
        if(input==null||input.length<1)
            return -1;
        if(input.length==1)
            return input[0];
        Arrays.sort(input);
        long x = 0;
        long y = 0;

        for (int i = input.length - 1; i >= 0; i--) {
            if (x<y) {
                x += input[i];
            } else {
                y += input[i];
            }
        }
        return (int) Math.abs(x - y);
    }
}