package InterVIew.Vivo.Problem1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
        if (input == null || input.length < 1)
            return -1;
        int end = 0;
        int max = 0;
        int steps = 0;
        for (int i = 0; i < input.length - 1; i++) {
            max = Math.max(max, input[i] + i);
            if (i == end) {
                end = max;
                steps++;
            }
        }
        if (max<input.length)
            return -1;

        return steps;


    }
}