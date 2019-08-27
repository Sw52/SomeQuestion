package sw.practice;

import java.util.HashSet;
import java.util.Set;

public class 集合交差并 {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        Set<String> result = new HashSet<>();

        set1.add("Liming");
        set1.add("Xiaohua");
        set1.add("Young");
        set1.add("Sw");

        set2.add("Xiaohua");
        set2.add("Wang");
        set2.add("Thunder");
        set2.add("Green");

        result.clear();
        result.addAll(set1);
        result.retainAll(set2); //仅保留set2也含有的元素
        System.out.println("交集"+result);

        result.clear();
        result.addAll(set1);
        result.removeAll(set2); //去除掉set2中含有的元素
        System.out.println("差集"+result);

        result.clear();
        result.addAll(set1);
        result.addAll(set2);    //添加set2中的元素
        System.out.println("并集"+result);
    }
}
