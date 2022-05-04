package jvm.classloader.two;


import java.io.*;

/**
 * @Auther d
 * @Date 2022/5/3 21:42
 * @Describe
 **/
public class FileClassLoader extends ClassLoader {
    private String rootDir;

    public FileClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }



    static String rootDirr = "D:/workspace/Demo/src/main/resources";
    //创建两个不同的自定义类加载器实例
    static FileClassLoader loader1 = new FileClassLoader(rootDirr);
    static FileClassLoader loader2 = new FileClassLoader(rootDirr);

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        //1,通过自定义findClass创建类的Class对象,不会查找缓存，所以jvm是多个实例对象
//        definFindClass();

        //2,直接调用父类的loadClass()方法,会查找缓存,所以jvm中加载的类是同一个对象
        superLoadClass();
    }

    public static void definFindClass() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> object1 = loader1.findClass("classloader.ClassLoaderTest");
        Class<?> object2 = loader2.findClass("classloader.ClassLoaderTest");

        System.out.println("findClass->obj1:" + object1.hashCode());
        System.out.println("findClass->obj2:" + object2.hashCode());

        //ClassLoaderTest类中唯一的方法
        System.out.println(object1.newInstance().toString() +"==="+ object2.newInstance().toString());
    }

    /**
     * @param name
     * @return java.lang.Class<?>
     * @author d
     * @date 2022/5/4 7:54
     * @Description 根据 {@link #rootDir} + name路径获取类的字节码的字节数组
     **/
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = getClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            //直接生成class对象
            return defineClass(name, classData, 0, classData.length);
        }
    }

    public  static void superLoadClass() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> obj1 = loader1.loadClass("jvm.classloader.two.ClassLoaderTest");
        Class<?> obj2 = loader2.loadClass("jvm.classloader.two.ClassLoaderTest");
        //不同实例对象的自定义类加载器
        System.out.println("loadClass->obj1:" + obj1.hashCode());
        System.out.println("loadClass->obj2:" + obj2.hashCode());
        //系统类加载器
        System.out.println("Class->obj3:" + ClassLoaderTest.class.hashCode());
        //ClassLoaderTest类中唯一的方法
        System.out.println(obj1.newInstance().toString() +"==="+ obj2.newInstance().toString());
    }




    private byte[] getClassData(String className) {
        String path = classNameToPath(className);
        try {
            InputStream ins = new FileInputStream(path);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesNumRead = 0;
            // 读取类文件的字节码
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    private String classNameToPath(String className) {
        return rootDir + File.separatorChar
                + className.replace('.', File.separatorChar) + ".class";
    }
}
