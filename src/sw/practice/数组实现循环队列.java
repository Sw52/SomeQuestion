package sw.practice;

public class 数组实现循环队列 {
    private int[] array = new int[5];
    private int index_head = 0;
    private int index_tail = 0;

    /**
     * @return
     * @see 判对队列是否为空
     */
    boolean isEmpty() {
        return index_head == index_tail;
    }

    /**
     * @return
     * @see 判断链表是否已满
     */
    boolean isFull() {
        return (index_tail + 1) % array.length == index_head;
    }

    /**
     * @see 删除链表头元素
     */
    public void del() {
        if (isEmpty()) {
            System.out.println("队列为空");
        } else {
            System.out.println(array[index_head]);
            index_head = (index_head + 1) % array.length;
        }
    }

    /**
     * 在链表尾拆入一个元素
     *
     * @param n
     */
    public void add(int n) {
        if (isFull()) {
            System.out.println("队列满");
        } else {
            array[index_tail] = n;
            index_tail = (index_tail + 1) % array.length;
        }
    }

    public static void main(String[] args) {
        数组实现循环队列 ne = new 数组实现循环队列();
        ne.add(1);
        ne.add(2);
        ne.add(2);
        ne.add(2);
        ne.del();
        System.out.println(ne.isEmpty());
        System.out.println(ne.isFull());
    }
}
