package InterVIew.Bilibilli.Problem2;

import java.util.*;

/*
数组排序成最小的数
输入一个证书数组，将他们连起来排成一个数，输出能排出的所有数字中最小的哪一个
 */
public class Main {
    public static String solution(int[] numbers) {
        int length = numbers.length;
        if (length == 0)
            return "";
        if (length == 1)
            return String.valueOf(numbers[0]);
        StringBuffer res = new StringBuffer();
        String[] str = new String[length];
        for (int i = 0; i < length; i++)
            str[i] = String.valueOf(numbers[i]);
        Arrays.sort(str, new Comparator<String>() {
            public int compare(String s_one, String s_two) {
                String c_one = s_one + s_two;
                String c_two = s_two + s_one;
                return c_one.compareTo(c_two);
            }
        });
        for (int i = 0; i < length; i++)
            res.append(str[i]);
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        int k = 0;
        List<Integer> list = new LinkedList<>();    //使用list是因为输入数组的元素个数不确定，所以采用动态链表
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ',') {    //找到输入字符串中的间隔符','
                list.add(Integer.parseInt(string.substring(k, i)));
                k = i + 1;
            }
        }
        list.add(Integer.parseInt(string.substring(k, string.length() - 1) + string.charAt(string.length() - 1)));
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);    //将list转换为数组
        }
        System.out.println(solution(array));
    }
}
