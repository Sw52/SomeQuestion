package sw.practice.设计模式;

/**
 * 饿汉式，线程安全的单例模式
 */
class SingleHungry {
    //申明一个私有单利模式对象
    //初始即加载
    private static SingleHungry instance = new SingleHungry();

    /**
     * 私有构造函数
     */
    private SingleHungry() {
    }

    /**
     * @return
     * @see 唯一获取对象的方法
     */
    public static SingleHungry getInstance() {
        return instance;
    }
}

/**
 * 双重检查实现单例模式
 */
class SingleDCL {
    //申明一个私有的单例模式对象
    //使用volatile关键字禁止指令重排序
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
        if (instance == null) {                 // 第一重检查锁定
            synchronized (SingleDCL.class) {    // 同步锁定代码块
                if (instance == null)           // 第二重检查锁定
                    instance = new SingleDCL(); // 注意：非原子操作
            }
        }
        return instance;
    }

}

/**
 * 懒汉式，线程安全的单例模式
 * url：https://www.runoob.com/design-pattern/singleton-pattern.html
 */
class SingleLazy {
    //申明一个私有单例模式对象
    private static SingleLazy instance;

    /**
     * 私有构造函数
     */
    private SingleLazy() {
    }

    /**
     * @return
     * @see 唯一获取对象的方法
     */
    public static synchronized SingleLazy getInstance() {
        if (instance == null)
            instance = new SingleLazy();  //延迟加载，区别于饿汉式
        return instance;
    }


    public static void main(String[] args) {

    }
}
