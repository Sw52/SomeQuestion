package sw.practice.生产者AND消费者;

import java.util.List;
import java.util.Random;

public class 生产者 implements Runnable {

    private List<Integer> list;
    private int maxLength;

    public 生产者(List list, int maxLength){
        this.list = list;
        this.maxLength = maxLength;
    }
    @Override
    public void run() {
        while (true){
            synchronized (list){
                try{
                    while (list.size()==maxLength){
                        System.out.println("生产者"+Thread.currentThread().getName()+"list已达到最大容量，进行wait");
                        list.wait();
                        System.out.println("生产者"+Thread.currentThread().getName()+"退出wait");
                    }
                    Random random = new Random();
                    int i = random.nextInt();
                    System.out.println("生产者"+Thread.currentThread().getName()+"生产的数据"+i);
                    list.add(i);
                    list.notifyAll();
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
