package java8Feature.Lambda.getAndAccept;

/**
 * @Auther d
 * @Date 2022/6/10 10:01
 * @Describe
 **/
public interface LambdaFunction<T,R> {
    R apply(T t);
}
