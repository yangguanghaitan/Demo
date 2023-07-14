package project.queueDisruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;
import java.util.concurrent.Executors;

/**
 * @Auther d
 * @Date 2023/3/9 20:47
 * @Describe
 **/
@Slf4j
public class DisruptorDemo {
    public static void main(String[] args) throws InterruptedException {
        Disruptor<OrderEvent> disruptor = new Disruptor<>(
                OrderEvent::new,
                1024 * 1024,
                Executors.defaultThreadFactory(),
                ProducerType.SINGLE,
                new YieldingWaitStrategy()
        );
        disruptor.handleEventsWith(new OrderEventHandler());//连接消费端
//      disruptor.handleEventsWithWorkerPool();//也是连接消费端
        disruptor.start();
        RingBuffer<OrderEvent> ringBuffer = disruptor.getRingBuffer();
        OrderEventProducer eventProducer = new OrderEventProducer(ringBuffer);
        eventProducer.onData(UUID.randomUUID().toString());
    }
}