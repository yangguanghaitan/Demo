package patterns.factory;

/**
 * @Auther d
 * @Date 2022/2/15 17:26
 * @Describe 抽象的工厂Bean
 **/
public interface FactoryBean<T> {
    T createObject();
    Class<?> getObjectType();
}
