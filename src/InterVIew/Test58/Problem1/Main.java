package InterVIew.Test58.Problem1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();

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
        for (int i : list
        ) {
            hashSet.add(i);
        }
        System.out.println(hashSet.size());
    }
}