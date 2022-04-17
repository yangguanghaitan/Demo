package basic.enumeration;

import java.util.Arrays;

/**
 * @Auther d
 * @Date 2022/4/11 16:26
 * @Describe 枚举的一些测试，https://www.runoob.com/java/java-enum.html
 **/
public class EnumTest{
/**
 * 状态类型
 */
public enum Type {
    /**
     * 成功
     */
    SUCCESS(0),
    /**
     * 警告
     */
    WARN(301),
    /**
     * 错误
     */
    ERROR(500);
    private final int value;

    Type(int value) {
        System.out.println("构造器"+this.toString());
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
    public enum DataSourceType {
        /**
         * 主库
         */
        MASTER{
            @Override
            public void aa() {
                System.out.println("实现抽象方法");
            }
        },

        /**
         * 从库
         */
        SLAVE{
            @Override
            public void aa() {
                System.out.println("实现抽象方法");
            }
        };

        public abstract void aa();
    }

    public static void main(String[] args) {
        System.out.println(Type.WARN.name());
        System.out.println(Type.WARN.value());//对象的方法
        System.out.println(Type.WARN.value);//对象的属性
        Type[] values = Type.values();
        for (Type value : values) {
            System.out.println(value + " at index " + value.ordinal());
        }
        System.out.println(Arrays.toString(values));
        System.out.println("=========");
        System.out.println(DataSourceType.MASTER.name());
        System.out.println(DataSourceType.MASTER.ordinal());//索引位置
        System.out.println(DataSourceType.SLAVE.ordinal());//索引位置
        DataSourceType.SLAVE.aa();//调用实现的抽象方法
        System.out.println(DataSourceType.valueOf("SLAVE"));
        System.out.println(Type.class.getName());
        System.out.println(DataSourceType.class.getName());
    }
}