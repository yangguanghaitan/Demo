package patterns.factory;

/**
 * @Auther d
 * @Date 2022/2/15 17:33
 * @Describe 具体的工厂Bean
 **/
public class ChinaCoffeeFactoryBean implements FactoryBean<ChinaCoffee>{
    private ChinaCoffee chinaCoffee;
    @Override
    public ChinaCoffee createObject() {
        chinaCoffee=new ChinaCoffee();
        return chinaCoffee;
    }

    @Override
    public Class<?> getObjectType() {
        return chinaCoffee.getClass();
    }
}
