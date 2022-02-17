package patterns.observe.event01;

import java.util.EventObject;

/**
 * @Auther d
 * @Date 2022/2/10 19:50
 * @Describe 事件
 **/
public class HomeworkEventObject extends EventObject {
    public HomeworkEventObject(Object source) {
        super(source);
    }

    public HomeworkEventObject(Teacher teacher) {
        super(teacher);
    }

    public Teacher getTeacher(){
        return (Teacher)super.getSource();
    }

}
