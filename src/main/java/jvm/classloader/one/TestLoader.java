package jvm.classloader.one;

/**
 * @Auther d
 * @Date 2022/5/1 22:14
 * @Describe jdk三类加载器：应用类，扩展类，启动类加载器
 **/
public class TestLoader {
    public static void main(String[] args) throws ClassNotFoundException {
        TestLoader testLoader=new TestLoader();

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统类加载器AppClassLoader=="+systemClassLoader);

//        Class<?> loader = testLoader.getClass().getClassLoader().loadClass("aa.TestLoader");
        ClassLoader loader = testLoader.getClass().getClassLoader();
        System.out.println("系统类加载器AppClassLoader=="+TestLoader.class.getClassLoader());
        System.out.println("系统类加载器AppClassLoader=="+loader);
        System.out.println("AppClassLoader的父类加载器=="+loader.getParent());
        System.out.println("ExtClassLoader的父类加载器=="+loader.getParent().getParent());

    }


}
