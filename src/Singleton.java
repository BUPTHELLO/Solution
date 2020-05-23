public class Singleton {
////    饿汉式加载
//    private Singleton(){}
//    private static Singleton Instance = new Singleton();
//    public Singleton getInstance(){
//        return Instance;
//    }

////    懒汉式加载
    private Singleton(){}
    private static Singleton Instance = null;

    public Singleton getInstance(){
        if (Instance == null)
            Instance = new Singleton();
        return Instance;
    }

////    懒汉式（双重同步锁）,必须使用volatile关键字修饰单例引用。
//    private Singleton(){}
//    private static volatile Singleton Instance = null;
//    public Singleton getInstance(){
//        if (Instance == null){
//            synchronized (Singleton.class){
//                if (Instance == null)
//                    Instance = new Singleton();
//            }
//        }
//        return Instance;
//    }
}
