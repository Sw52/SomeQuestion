package sw.practice.设计模式;

/**
 * 饿汉式，线程安全的单例模式
 */
class Singleton {
    //申明一个私有单利模式对象
    private static Singleton instance = new Singleton();

    /**
     * 私有构造函数
     */
    private Singleton() {
    }

    /**
     * @return
     * @see 唯一获取对象的方法
     */
    public static Singleton getInstance() {
        return instance;
    }
}

/**
 * 双重检查实现单例模式
 */
class SingleDCL {
    //申明一个私有的单例模式对象
    private static volatile SingleDCL instance;

    /**
     * 私有构造函数
     */
    private SingleDCL() {

    }

    /**
     * @see 获取单例对象的接口
     * @return
     */
    public static SingleDCL getInstance() {
        if (instance == null) {// 第一重检查锁定
            synchronized (SingleDCL.class) {// 同步锁定代码块
                if (instance == null)// 第二重检查锁定
                    instance = new SingleDCL();// 注意：非原子操作
            }
        }
        return instance;
    }

}

/**
 * 懒汉式，线程安全的单例模式
 * url：https://www.runoob.com/design-pattern/singleton-pattern.html
 */
public class SingleObject {
    //申明一个私有单例模式对象
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
