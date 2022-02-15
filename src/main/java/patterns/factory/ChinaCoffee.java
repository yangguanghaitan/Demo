package patterns.factory;

/**
 * @Auther d
 * @Date 2022/2/15 17:32
 * @Describe 具体的产品
 **/
public class ChinaCoffee extends Coffee{
    @Override
    String getName() {
        return "中国咖啡";
    }
}
