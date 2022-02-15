package patterns.factory;

/**
 * @Auther d
 * @Date 2022/2/15 17:36
 * @Describe  工厂方法,两个具体的工厂bean（china和America），制造对应的咖啡
 **/
public class FactoryMethodDemo {
    public static void main(String[] args) {

        AmericaCoffeeFactoryBean americaCoffeeFactoryBean=new AmericaCoffeeFactoryBean();
        AmericCoffee americCoffee = americaCoffeeFactoryBean.createObject();
        System.out.println(americaCoffeeFactoryBean.getObjectType());
        System.out.println(americCoffee.getName());


        ChinaCoffeeFactoryBean chinaCoffeeFactoryBean=new ChinaCoffeeFactoryBean();
        ChinaCoffee chinaCoffee = chinaCoffeeFactoryBean.createObject();
        System.out.println(chinaCoffeeFactoryBean.getObjectType());
        System.out.println(chinaCoffee.getName());
    }
}
