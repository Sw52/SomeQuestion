package sw.practice.生产者AND消费者;

import java.util.LinkedList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        int maxLength = 10;
        生产者 s = new 生产者(list, maxLength);
        消费者 x = new 消费者(list);
        s.start();
        x.start();
    }
}
