package sw.practice.生产者AND消费者;

import java.util.List;

public class 消费者 extends Thread{
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
