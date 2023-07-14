package project.queueDisruptor;

import com.lmax.disruptor.RingBuffer;

/**
 * @Auther d
 * @Date 2023/3/9 20:43
 * @Describe
 **/
public class OrderEventProducer {
    private final RingBuffer<OrderEvent> ringBuffer;
    public OrderEventProducer(RingBuffer<OrderEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }
    public void onData(String orderId) {
        long sequence = ringBuffer.next();
        try {
            OrderEvent orderEvent = ringBuffer.get(sequence);
            orderEvent.setId(orderId);
        } finally {
            ringBuffer.publish(sequence);
        }
    }
}