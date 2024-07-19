//package com.study;
//
//import java.util.concurrent.Callable;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.TimeUnit;
//
//import org.junit.Test;
//
//import com.google.common.cache.CacheBuilder;
//import com.google.common.cache.RemovalListener;
//import com.google.common.cache.RemovalNotification;
//import com.google.common.cache.Cache;;
///**
// * guava cache 测试
// *
// * @author    pengbo.zhao
// * @data 2019年11月5日 上午10:24:15
// *
// *
// *  cache的创建
// *
// *  {@link #createCache()}    创建一个简单的cache
// *
// *
// *
// */
//public class GuavaCache {
//
//
//
//    @Test
//    public void createCache() throws ExecutionException{
//        Cache<String,String> cache = CacheBuilder.newBuilder()
//
//                //设置并发数(以获取当前操作系统cpu数来确定并发数)
//                .concurrencyLevel(Runtime.getRuntime().availableProcessors())
//                //设置初始容量
//                .initialCapacity(1000)
//                //设置最大存储量
//                .maximumSize(900)
//                //设置过期时间(3秒内没有使用)在指定时间内没有进行读写，会移除key，下次取的时候从loading中取
//                .expireAfterAccess(3,TimeUnit.SECONDS)
//                //设置过期时间(写入3秒内过期)在一定时间内没有创建/覆盖时，会移除key，下次从loading中取
//                .expireAfterWrite(3, TimeUnit.SECONDS)
//                //设置引用清除(设置弱引用存储值)
//                .weakValues()
//                //设置统计信息
//                .recordStats()
//                //设置移除通知
//                .removalListener(new RemovalListener<String, String>() {
//                    @Override
//                    public void onRemoval(RemovalNotification<String, String> notification) {
//                        System.out.println(notification.getKey()+"-"+notification.getValue()+" is remove");
//                    }
//                })
//                //构建
//                .build();
//
//        cache.put("key1", "value1");
//        System.out.println(cache.getIfPresent("key1"));
//        String key2 = cache.get("key2",new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                return "value2";
//            }
//        });
//        System.out.println(key2);
//    }
//}