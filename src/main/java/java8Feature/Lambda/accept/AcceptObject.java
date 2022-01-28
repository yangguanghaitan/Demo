package java8Feature.Lambda.accept;

/**
 * @Auther d
 * @Date 2022/1/28 12:23
 * @Describe
 **/
@FunctionalInterface
public interface AcceptObject<T> {
    void accept(T t);
}
