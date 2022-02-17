package patterns.observe.event01;

/**
 * @Auther d
 * @Date 2022/2/10 19:54
 * @Describe 具体的监听器，类似于观察者
 **/
public class Student implements HomeworkEventListen{
    private String name;
    public Student(String name){
        this.name = name;
    }

    @Override
    public void update(HomeworkEventObject o, Object arg) {
        Teacher teacher = o.getTeacher();
        System.out.printf("学生%s观察到（实际是被通知）%s布置了作业《%s》 \n",
                this.name, teacher.getName(), arg);
    }
}
