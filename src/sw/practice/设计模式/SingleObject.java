package sw.practice.设计模式;

/**
 * 懒汉式，线程安全的单例模式
 * url：https://www.runoob.com/design-pattern/singleton-pattern.html
 */
public class SingleObject {
    //申明一个单例模式对象
    private static SingleObject instance;

    /**
     * 私有构造函数
     */
    private SingleObject() {
    }

    /**
     * @return
     * @see 唯一获取对象的方法
     */
    public static synchronized SingleObject getInstance() {
        if (instance == null)
            instance = new SingleObject();  //延迟加载，区别于饿汉式
        return instance;
    }

    public static void main(String[] args) {

    }
}
