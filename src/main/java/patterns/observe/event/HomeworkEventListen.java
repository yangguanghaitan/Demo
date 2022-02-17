package patterns.observe.event;

import java.util.EventListener;

/**
 * @Auther d
 * @Date 2022/2/10 19:48
 * @Describe 监听器接口
 **/
public interface HomeworkEventListen extends EventListener {
    public void update(HomeworkEventObject o, Object arg);
}
