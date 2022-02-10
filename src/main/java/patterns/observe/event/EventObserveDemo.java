package patterns.observe.event;

/**
 * @Auther d
 * @Date 2022/2/10 19:47
 * @Describe java的事件模型通知程序，类似于观察者模式
 **/
public class EventObserveDemo {
    public static void main(String[] args) {
        //创建观察者
        Student student1=new Student("张三");
        Student student2=new Student("李四");
        //创建事件源，被观察者
        Teacher teacher=new Teacher("丽丽");
        teacher.addObserver(student1);
        teacher.addObserver(student2);
        //发布事件
        teacher.setHomework("寒假作业要完成");
    }
}
