package patterns.adapter.one;

/**
 * @Auther d
 * @Date 2024/7/3 14:03
 * @Describe 类适配器模式
 **/
    public class Adapter extends Adaptee implements Target {

        /**
         * 采用继承的方式实现转换功能
         */
        @Override
        public void doubleHoleSocket() {
            // 调用继承的方法，对其进行增强或处理
            this.commonThreeHoleSocket();
            System.out.println("==========开始转换==========");
            System.out.println("oh，我变成了两孔插座");
        }
    }
