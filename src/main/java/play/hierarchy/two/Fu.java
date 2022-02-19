package play.hierarchy.two;

/**
 * @Auther d
 * @Date 2022/2/19 18:21
 * @Describe
 **/
class Fu {
    Fu() {
        super();
        show();
        return;
    }

    void show() {
        System.out.println("fu show");
    }
}

class Zi extends Fu {
    int num = 8;
    boolean f = true;

    Zi() {
        super();
        System.out.println("zi cons num..." + num);
    }

    void show() {
        System.out.println(f);
        System.out.println("zi show..." + num);
    }
}

/**
 * @Auther d
 * @Date 2022/2/19 17:51
 * @Describe 测试多个类或者接口继承特性的位置
 * 1.通过super初始化父类内容时，子类的成员变量并未显示初始化，
 * 等super()父类初始化完毕后，才进行子类的成员变量显式初始化,
 * super()方法调用其他方法时是调用子类未初始化成员变量的方法。
 * 示例简单执行即可
 * 2，实例化包括对成员变量进行赋值
 **/
class Demo {
    public static void main(String[] args) {
        Zi z = new Zi();
        z.show();
    }
}
