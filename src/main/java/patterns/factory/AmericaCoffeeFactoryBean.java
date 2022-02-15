package patterns.factory;

/**
 * @Auther d
 * @Date 2022/2/15 17:33
 * @Describe 具体的工厂Bean
 **/
public class AmericaCoffeeFactoryBean implements FactoryBean<AmericCoffee>{
    private Coffee coffee;
    @Override
    public AmericCoffee createObject() {
        this.coffee=new AmericCoffee();
        return (AmericCoffee) coffee;
    }

    @Override
    public Class<?> getObjectType() {
        return coffee.getClass();
    }
}
