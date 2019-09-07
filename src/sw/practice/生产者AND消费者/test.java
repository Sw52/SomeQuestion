package sw.practice.生产者AND消费者;

import java.util.LinkedList;
import java.util.List;
public class test {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        int maxLength = 1000;
        生产者 s = new 生产者(list,maxLength);
        消费者 x = new 消费者(list);
        s.run();
        x.run();



    }
}

class 消费者 implements Runnable{
    private List<Integer> list;
    public 消费者(List list){
        this.list = list;
    }

    @Override
    public void run() {
        while (true){
            synchronized (list){
                try {
                    while (list.isEmpty()){
                        System.out.println("消费者"+Thread.currentThread().getName()+"list为空，进行wait");
                        list.wait();
                        System.out.println("消费者"+Thread.currentThread().getName()+"退出wait");
                    }
                    Integer integer = list.remove(0);
                    System.out.println("消费者"+Thread.currentThread().getName()+"消费数据"+integer);
                    list.notifyAll();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}

